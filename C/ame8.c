/*
Andy Me
Lab 8
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void fillRand(int *arr, int size);
void printer(int *arr, int size);

int main(void)
{
    srand(time(0));
    int size = 10;
    int arr[10] = {0};
    fillRand(arr, size);
    printer(arr, size);

}

void fillRand(int *arr, int size)
{
	int *i;
	for (i = arr; i < arr + size; i++)
	{
		*i = ((rand() % 32) + 20);
	}
}

void printer(int *arr, int size)
{
	int *i;
    int j = 0;
	for (i = arr; i < arr + size; i++)
	{
		printf("array[%d]=%d\n", j++, *i);
	}
}