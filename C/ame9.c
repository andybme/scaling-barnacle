/*
Andy Me
Lab 9
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

void printVowels(int *charr);
void printLower(int *charr);
void printUpper(int *charr);
int getNumber(int *charr);

int main(void)
{
    int num;
    char charr[20];
    printf("Enter a string less than 20 characters that includes one(1) number:\n");
    fgets(charr, 20, stdin);
    printVowels(charr);
    // printLower(charr);
    // printUpper(charr);
    // num = getNumber(charr);

    // printf("Number entered in string: %d, * 12 = %d", num, num*12);

}

void printVowels(int *charr)
{
    int *ptr, *i;
    int j, counter;
    int vowelAscii[12] = {65, 69, 73, 79, 85, 89, 97, 101, 105, 111, 117, 121};
    for (ptr = charr; ptr < charr + 20; ptr++)
    {
        for(i = vowelAscii; i < vowelAscii + 12; i++)
        {
            if(*ptr = *i)
            {
                counter++;
            }
        }
    }
    printf("Number of Vowels:\n%d\n", counter);
}