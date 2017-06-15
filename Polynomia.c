# include <stdio.h> 
# include <stdlib.h>
# define MaxDegree 360

typedef struct polynomia
{
	int CoeffArray[MaxDegree + 1];
	int HighPower;
} * Polynomia;

void Zeropolynomia(Polynomia);//初始化数组
Polynomia  AddPolynomia(Polynomia, Polynomia, Polynomia);
Polynomia MultPolynomial(Polynomia, Polynomia, Polynomia);
void Print(Polynomia);

int main(void)
{
	int i = 0;

	Polynomia poly1 = malloc(sizeof(struct polynomia));
	Polynomia poly2 = malloc(sizeof(struct polynomia));
	Polynomia poly = malloc(sizeof(struct polynomia));

	Zeropolynomia(poly1);
	Zeropolynomia(poly2);
	Zeropolynomia(poly);

	poly1->HighPower = 3;
	poly1->CoeffArray[0] = 2;
	poly1->CoeffArray[1] = 5;
	poly1->CoeffArray[2] = 6;
	poly1->CoeffArray[3] = 7;

	poly2->HighPower = 5;
	poly2->CoeffArray[0] = 3;
	poly2->CoeffArray[2] = 6;
	poly2->CoeffArray[3] = 2;
	poly2->CoeffArray[4] = 1;
	poly2->CoeffArray[5] = 3;

	AddPolynomia(poly1, poly2, poly);

	Print(poly);

	MultPolynomial(poly1, poly2, poly);
	Print(poly);

	getch();
}

void Zeropolynomia(Polynomia Poly)
{
	int i;
	for (i = 0; i <= MaxDegree; i++){
		Poly->CoeffArray[i] = 0;
	}
}

Polynomia AddPolynomia(Polynomia poly1, Polynomia poly2, Polynomia poly){
	int i;

	poly->HighPower = (poly1->HighPower > poly2->HighPower) ? poly1->HighPower : poly2->HighPower;

	for (i = 0; i <= poly->HighPower; i++)
	{
		poly->CoeffArray[i] = poly1->CoeffArray[i] + poly2->CoeffArray[i];
	}

	return poly;
}

Polynomia MultPolynomial(Polynomia poly1, Polynomia poly2, Polynomia poly){
	int i, j;

	poly->HighPower = poly1->HighPower + poly2->HighPower;//最高項冪，必然是兩個因式最高項冪之和
	//相乘即对应项系数相加
	if (poly->HighPower > MaxDegree + 1)
	{
		printf("数组空间不足");
	}
	else
	{
		for (i = 0; i <= poly1->HighPower; i++)
		{
			for (j = 0; j <= poly2->HighPower; j++)
			{
				poly->CoeffArray[i + j] = poly1->CoeffArray[i] * poly2->CoeffArray[j];//對影響係數相乘，冪相加
			}
		}
	}

	return poly;
}

void Print(Polynomia poly)
{
	int i;

	for (i = poly->HighPower; i >= 0; i--)
	{
		if (i != 0 && poly->CoeffArray[i] != 0)
		{
			if (poly->CoeffArray[i] != 1)
			{
				printf("%dX^%d + ", poly->CoeffArray[i], i);
			}
			else
			{
				printf("X^%d + ", i);
			}
		}
		else if (poly->CoeffArray[i] != 0)
		{
			printf("%d", poly->CoeffArray[i]);
		}
	}
	printf("\n");
}