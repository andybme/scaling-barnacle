/*
Andy Me
March 2nd, 2020
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int primeTest(int x);

int main(void)
{
	int x, pTBool;
	printf("Please enter a positive integer: ");
	scanf("%d", &x);
	pTBool = primeTest(x);
	if (pTBool == 0)
	{
		printf("The number entered is not prime.\n");
	} else
	{
		printf("The number entered is prime.\n");
	}
	return EXIT_SUCCESS;
}

int primeTest(int x)
{
	int i;
	for (i = x - 1; i > 1; i--)
	{
		printf("i = %d, x = %d\n", i, x);
		if (x % i == 0)
		{
			return 0;
		}
	}
	return 1;
}
