#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(void)
{
    int i, x, y, z;
    char ch, cj;
    char charray[20];
    printf("Enter a string no longer than 19 characters: ");
    fgets(charray, 19, stdin);

    printf("Your string is: %si \n", charray);

    printf(" Enter a char: ");
    ch = getchar();

    printf("Your char is %c \n", ch);

    return EXIT_SUCCESS;
}