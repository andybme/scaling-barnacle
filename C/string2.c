#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

int main(void)
{
    char ch;
    char charray[20];
    char cjarray[20] = ("password");
    printf("Enter a string no longer than 19 characters: ");
    fgets(charray, 20, stdin);
    charray[8] = '\0';
    if(0 == strcmp(charray, cjarray))
    {
        puts("Correct");
    }else
    {
        puts("Incorrect");
    }


    return EXIT_SUCCESS;
}