/*20160509 ShujunZhou
 * 给出一个链表L和另一个链表P，他们包含以升序排列的整数。操作PrintLows(L, P)
 * 将打印L中的那些由P所指向的位置上的元素。例如p=1,3,4,6那么，L中的第一，三，
 * 四，六个元素被打印出来。
 * */

# include <stdio.h>
# include <stdlib.h>
 
struct Node;
typedef struct Node * Position;
typedef Position List;

List creatList(int a[], int length);
void printLosts(List L, List P);

struct Node
{
	int Data;
	List Next;
};

int main(void)
{
	int a[10] = {2, 5, 8, 10, 21, 53, 59, 82, 101, 206};
	int b[5] = {1, 5, 6, 7, 8};
	
	List L = creatList(a, 10);
	List P = creatList(b, 5);

	printLosts(L, P);

	return 0;
}

List creatList(int a[], int length)
{
	List Temp = NULL;
	List New = NULL;
	List Header = (List)malloc(sizeof(struct Node));
	if (Header == NULL)
	{
		exit(-1);
	}

	Temp = Header;
	for (int i = 0; i < length; i++)
	{
		New = (List)malloc(sizeof(struct Node));
		if (New == NULL)
		{
			exit(-1);
		}
		New->Data = a[i];

		Temp->Next = New;
		Temp = New;
		Temp->Next = NULL;
	}
	Temp = NULL;

	return Header;
}

void printLosts(List L, List P)
{
	int Counter = 1;
	Position Lpos = NULL;
	Position Ppos = NULL;

	Lpos = L->Next;
	Ppos = P->Next;
	
	while (Lpos != NULL && Ppos != NULL)
	{
		if (Ppos->Data == Counter++)//判断链表P中的元素是否等于1,2,3...,一旦等于便读取L链表中相应位置的元素
		{
			printf("%d ", Lpos->Data);
			Ppos = Ppos->Next;
		}
		Lpos = Lpos->Next;
	}
}
