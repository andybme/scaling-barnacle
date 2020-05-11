/*
Andy Me
March 4th, 2020
*/
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#define SIZE 30

void printer(int arr[], int size);
void filleven(int arr[]);
void fillodd(int arr[]);
void swap(int arr[], int arr2[]);
void fillRand(int arr[]);
void sort(int arr[],int  arr2[],int  arr3[]);

int main(void)
{
	srand(time(0));
	int arr[SIZE] = {0};
	int arr2[SIZE] = {0};
	int arr3[SIZE * 2] = {0};
	printer(arr, SIZE);
	filleven(arr);
	printer(arr, SIZE);
	fillodd(arr2);
	printer(arr2, SIZE);
	swap(arr, arr2);
	printer(arr, SIZE);
	printer(arr2, SIZE);
	fillRand(arr);
	fillRand(arr2);
	printer(arr, SIZE);
	printer(arr2, SIZE);
	sort(arr, arr2, arr3);
	printer(arr3, SIZE * 2);
	return EXIT_SUCCESS;
}

void printer(int arr[], int size)
{
	int i;
	for (i = 0; i < size; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}

void filleven(int arr[SIZE])
{
	int i;
	for (i = 0; i < SIZE; i++)
	{
		arr[i] = i * 2;
	}
}

void fillodd(int arr[SIZE])
{
	int i;
	for (i = 0; i < SIZE; i++)
	{
		arr[i] = (i * 2) + 1;
	}
}

void swap(int arr[SIZE], int arr2[SIZE])
{
	int i, swapBuffer;
	for (i = 0; i < SIZE; i++)
	{
		swapBuffer = arr[i];
		arr[i] = arr2[i];
		arr2[i] = swapBuffer;
	}
}

void fillRand(int arr[SIZE])
{
	int i;
	for (i = 0; i < SIZE; i++)
	{
		arr[i] = (rand() % 255);
	}
}

void sort(int arr[SIZE], int arr2[SIZE], int arr3[SIZE * 2])
{
	int i, buffer = 0, loc;
	while (i < SIZE * 2)
	{
		buffer = 256;
		for (loc = 0; loc < SIZE * 2; loc++)
		{
			if (arr[loc] - buffer < 0)
			{
				buffer = arr[loc];
				arr[loc] = 0;
			}
			if (arr2[loc] - buffer < 0)
			{
				buffer = arr2[loc];
				arr2[loc] = 0;
			}
			printf("%d ", buffer);
		}
		arr3[i] = buffer;
		i++;
	}
}
