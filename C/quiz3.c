/*
Andy Me
Quiz 3
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <time.h>

void fillRandInt(int* arr);
void getString(char* charr);
void outputArr(int* arr, char* charr);

int main(void)
{
    //
    int arr[20];
    char charr[20];

    srand(time(0));

    fillRandInt(arr);
    getString(charr);
    outputArr(arr, charr);

}

void fillRandInt(int* arr)
{
    int *ptr;
    int i;
    for (i = 0; i < 20; i++)
    {
        ptr = arr + i;
        *ptr = (rand() % 13) + 5;
    }
}


void getString(char* charr)
{
    //
    FILE *fptr;
    if ((fptr = fopen("testtext.txt", "r")) == NULL)
    {
        puts("File does not exist");
    }else{
        fscanf(fptr, "%29s", charr);
        fclose(fptr);
    }
}

void outputArr(int* arr, char* charr)
{
    //
    FILE *fptr;
    int i;
    if ((fptr = fopen("output.txt", "w")) == NULL)
    {
        puts("File does not exist");
    }else{
        for(i = 0; i < 20; i++)
        {
            //
            fprintf(fptr, "%d\n", arr[i]);
        }
        fprintf(fptr, "%s\n", charr);
        fclose(fptr);
    }
}