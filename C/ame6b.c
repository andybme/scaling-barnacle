/*
Andy Me
CSC 251
February 10th, 2020
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void)
{
	srand(time(0));
	for (int i = 0; i < 10; i++)
	{
		int x = 0, y = 0, z = 0;
//		printf("x = %d, y = %d, z = %d\n", x, y, z);
//		printf("Enter a seed: \n");
//		scanf("%d", &y);
		x = rand()%31 + 50;
//		printf("x = %d, y = %d, z = %d\n", x, y, z);
		printf("Random number: %d\n", x);
	}
}
