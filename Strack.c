# include <stdio.h>
# include <stdlib.h>
# define MAX 100

typedef struct NodeType
{
	int id;
	int password;
	struct NodeType * next;
} NodeType;

NodeType *  CreatList(int); //创建单向循环链表
NodeType * GetNode(int, int);  //得到一个节点
void PrintList(NodeType *);      //打印循环链表
int IsEmptyList(NodeType *);   //判断链表是否为空
void JosephusOperate(NodeType *, int);  //运行“约瑟夫环”问题

int main(void)
{
	int n; //获取人数
	int m;//获取初始密码

	do
	{
		printf("请输入人数（最多为%d个）：" , MAX);
		scanf_s("%d", &n);

		if (n < 1 || n > 100)
		{
			printf("输入有误，请重新输入！");
		}
	} while (n < 1 && n > MAX);

	printf("请输入初始密码：");
	scanf_s("%d", &m);
	NodeType * pHead = CreatList(n);   //创建单向循环链表
	printf("\n----------打印约瑟夫环------------\n");
	PrintList(pHead);
	printf("\n----------打印约瑟夫环------------\n");
	JosephusOperate(pHead, m);

	system("pause");
	return 0;
}

NodeType * CreatList(int n)
{
	int i = 0;
	int iPassword = 0;

	NodeType * pHead = NULL;
	NodeType * pNew = NULL;//新节点
	NodeType * pCur = NULL;//尾节点

	for (i = 1; i <= n; i++)
	{
		printf("请输入第%d个人的密码：", i);
		scanf_s("%d", &iPassword);
		pNew = GetNode(i, iPassword);
		if (pHead == NULL)
		{
			pHead = pCur = pNew;
			pCur->next = pHead;
		}
		else
		{
			pNew->next = pCur->next;//首尾相连
			pCur->next = pNew;          //前后两个节点相连
			pCur = pNew;                    //pCur指向尾节点
		}
	}
	printf("单向循环链表创建完毕\n");
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
		printf("第%d个人出列（密码%d）\n", pDel->id, pDel->password);
		free(pDel);
		pDel = NULL;
	}
	pHead = NULL;
	getchar();
}

