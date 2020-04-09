/*
Andy Me
Lab 9
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

void printVowels(char charr);
void printLower(char charr);
void printUpper(char charr);
int getNumber(char charr);

int main(void)
{
    int num;
    char charr[20];
    printf("Enter a string less than 20 characters that includes one(1) number:\n");
    fgets(charr, 20, stdin);
    printLower(charr);
    printUpper(charr);
    num = getNumber(charr);

    printf("Number entered in string: %d, * 12 = %d", num, num*12);

}

void printVowels(char charr)
{
    int *ptr;
    for (ptr = charr; ptr < charr + 20; ptr++)
    {
        if(isVowel)
    }
}