/*
Andy Me
Lab 7
March 4th, 2020
*/
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

void printer(int arr[], int size);
void fillRand(int arr[], int size);
void sort(int arr[], int size);

int main(void)
{
	int size = 30;
	srand(time(0));
	int arr[30] = {0};
	printf("array before \n");
	printer(arr, size);
	fillRand(arr, size);
	printf("array after \n");
	printer(arr, size);
	sort(arr, size);
	printf("array sorted \n");
	printer(arr, size);
	return EXIT_SUCCESS;
}

void printer(int arr[], int size)
{
	int i;
	for (i = 0; i < size; i++)
	{
		printf("a[%d] = %d\n", i, arr[i]);
	}
	printf("\n");
}

void fillRand(int arr[], int size)
{
	int i;
	for (i = 0; i < size; i++)
	{
		arr[i] = ((rand() % 151) + 55);
	}
}

void sort(int arr[], int size)
{
	int i = 0, smallest, loc, lastLoc;
	while (i < size)
	{
		smallest = 256;
		for (loc = i; loc < size; loc++)
		{
			if (arr[loc] - smallest < 0)
			{
				smallest = arr[loc];
				lastLoc = loc;
			}
		}
		arr[lastLoc] = arr[i];
		arr[i] = smallest;
		i++;
	}
}