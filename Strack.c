# include <stdio.h>
# include <stdlib.h>
# define MAX 100

typedef struct NodeType
{
	int id;
	int password;
	struct NodeType * next;
} NodeType;

NodeType *  CreatList(int); //��������ѭ������
NodeType * GetNode(int, int);  //�õ�һ���ڵ�
void PrintList(NodeType *);      //��ӡѭ������
int IsEmptyList(NodeType *);   //�ж������Ƿ�Ϊ��
void JosephusOperate(NodeType *, int);  //���С�Լɪ�򻷡�����

int main(void)
{
	int n; //��ȡ����
	int m;//��ȡ��ʼ����

	do
	{
		printf("���������������Ϊ%d������" , MAX);
		scanf_s("%d", &n);

		if (n < 1 || n > 100)
		{
			printf("�����������������룡");
		}
	} while (n < 1 && n > MAX);

	printf("�������ʼ���룺");
	scanf_s("%d", &m);
	NodeType * pHead = CreatList(n);   //��������ѭ������
	printf("\n----------��ӡԼɪ��------------\n");
	PrintList(pHead);
	printf("\n----------��ӡԼɪ��------------\n");
	JosephusOperate(pHead, m);

	system("pause");
	return 0;
}

NodeType * CreatList(int n)
{
	int i = 0;
	int iPassword = 0;

	NodeType * pHead = NULL;
	NodeType * pNew = NULL;//�½ڵ�
	NodeType * pCur = NULL;//β�ڵ�

	for (i = 1; i <= n; i++)
	{
		printf("�������%d���˵����룺", i);
		scanf_s("%d", &iPassword);
		pNew = GetNode(i, iPassword);
		if (pHead == NULL)
		{
			pHead = pCur = pNew;
			pCur->next = pHead;
		}
		else
		{
			pNew->next = pCur->next;//��β����
			pCur->next = pNew;          //ǰ�������ڵ�����
			pCur = pNew;                    //pCurָ��β�ڵ�
		}
	}
	printf("����ѭ�����������\n");
	return pHead;
}

NodeType * GetNode(int iId, int iPassword)
{
	NodeType * pNew = (NodeType *)malloc(sizeof(NodeType));

	if (pNew == NULL)
	{
		printf("Error, The memory is not enough!\n");
		exit(-1);
	}

	pNew->id = iId;
	pNew->password = iPassword;
	pNew->next = NULL;

	return pNew;
}

void PrintList(NodeType * pHead)
{
	NodeType * pCur = pHead;

	if (!IsEmptyList(pHead))
	{
		do
		{
			printf("%3d %7d\n", pCur->id, pCur->password);
			pCur = pCur->next;
		} while (pCur != pHead);
	}
}

int IsEmptyList(NodeType * pHead)
{
	if (!pHead)
	{
		printf("The List is empty");
		return 1;
	}

	return 0;
}

void JosephusOperate(NodeType * pHead, int iPassword)
{
	int iCounter = 0;
	int iFlag = 1;
	NodeType * pPrv = NULL;
	NodeType * pCur = NULL;
	NodeType * pDel = NULL;

	pPrv = pCur = pHead;

	while (pPrv->next != pHead)
	{
		pPrv = pPrv->next;
	}
	while (iFlag)
	{
		for (iCounter = 1; iCounter < iPassword; iCounter++)
		{
			pPrv = pCur;
			pCur = pCur->next;
		}
		if (pPrv == pCur)
		{
			iFlag = 0;
		}
		pDel = pCur;
		pPrv->next = pCur->next;
		pCur = pCur->next;
		iPassword = pDel->password;
		printf("��%d���˳��У�����%d��\n", pDel->id, pDel->password);
		free(pDel);
		pDel = NULL;
	}
	pHead = NULL;
	getchar();
}

