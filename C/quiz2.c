/*
Andy Me
Quiz 2d
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
void fillRandInt(int* arr);
void fillRandLower(char* charr);
void changeUpper(char* charr);
void printArr(int* arr, char* charr);

int main(void)
{
    srand(time(0));
    int arr[5];
    char charr[5];
    fillRandInt(arr);
    fillRandLower(charr);
    changeUpper(charr);
    printArr(arr, charr);

    return EXIT_SUCCESS;
}

void fillRandInt(int* arr)
{
    int *ptr;
    int i;
    for (i = 0; i < 5; i++)
    {
        ptr = arr + i;
        *ptr = (rand() % 11) + 10;
    }
}

void fillRandLower(char* charr)
{
    char *ptr;
    int i;
    for (i = 0; i < 5; i++)
    {
        ptr = charr + i;
        *ptr = (rand() % 26) + 97;
    }
}

void changeUpper(char* charr)
{
    char *ptr;
    int i;
    for (i = 0; i < 5; i++)
    {
        ptr = charr + i;
        *ptr = *ptr - 32;
    }
}

void printArr(int* arr, char* charr)
{
    int i;
    int *ptr;
    for (i = 0; i < 5; i++)
    {
        ptr = arr + i;
        printf("arrayOne[%d]=%d\n", i, *ptr);
    }
    char *ptr2;
    for (i = 0; i < 5; i++)
    {
        ptr2 = charr + i;
        printf("arrayOne[%d]=%c\n", i, *ptr2);
    }
}