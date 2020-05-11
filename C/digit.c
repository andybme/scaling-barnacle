#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main()
{
    char ch;
    int x;
    printf("Please enter a number: ");
    scanf("%c", &ch);
    x = isdigit(ch);

    if (x)
    {
        printf("This character is a number.\n");
    } else
    {
        printf("This character is not a number.\n");
    }
    EXIT_SUCCESS;
}