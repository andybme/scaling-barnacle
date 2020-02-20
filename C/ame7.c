/*
Andy Me
Lab 7
February 19th, 2020
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 5

void arrprint(int arrp[], int arrsize);

int main(void)
{
	int arr[SIZE] = {2, 4, 6, 8, 10};
	int arr1[6] = {0};
	int arr2[3][5] = {{2, 4, 6, 8, 10}, {1, 2, 3, 4, 5}, {1, 3, 5, 7, 9}};
	int i,z,x,y,j;

	arr1[0] = 1;
	arr1[1] = 2;
	arr1[2] = 3;
	arr1[3] = 4;
	arr1[4] = 5;
	arr1[5] = 6;

	printf("arr1[3] = %d \n", arr1[3]);

	for (i = 0; i < SIZE; ++i)
	{
		arr[i] = 1;
	}

	for (i = 0; i < SIZE; ++i)
	{
		printf("arr[%d] = %d \n", i, arr[i]);
	}
	for (i = 0; i < 3; ++i)
	{
		for (j = 0; j < 5; ++j)
		{
			printf("arr2[%d][%d] = %d \n", i,j, arr2[i][j]);
		}
	}

}


void arrprint(int arrp[], int arrsize)
{
	int i;
	for (i = 0; i < arrsize; ++i)
	{
		printf("arr[%d] = %d \n", i, arr[i]);
	}
}