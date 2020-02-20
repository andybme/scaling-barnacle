/*
Andy Me
Lab 7
February 19th, 2020
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 5

void arrprint(int arr1[], int arr2[], int arrsize);

int main(void)
{
	int i,j;
	int firstArray[SIZE] = {2, 4, 6, 8, 10};
	int secondArray[SIZE] = {1, 3, 5, 7, 9};
	int buffer = 0;
	
	arrprint(firstArray, secondArray, SIZE);

	for (i = 0; i < SIZE; ++i)
	{
		buffer = firstArray[i];
		firstArray[i] = secondArray[i];
		secondArray[i] = buffer;
	}

	arrprint(firstArray, secondArray, SIZE);

}


void arrprint(int arr1[], int arr2[], int arrsize)
{
	int i;
	for (i = 0; i < arrsize; ++i)
	{
		printf("firstArray[%d] = %d, secondArray[%d] = %d\n", i, arr1[i], i, arr2[i]);
	}
}