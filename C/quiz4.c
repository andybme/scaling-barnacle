/*
Andy Me
Quiz 4
*/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char **argv)
{
    FILE *iptr, *optr;
    char x;
    if((iptr = fopen(argv[1], "r")) == NULL)
    {
        puts("Input file could not be opened.");
        return EXIT_FAILURE;
    }
    if((optr = fopen(argv[2], "w")) == NULL)
    {
        puts("Output file could not be created.");
        return EXIT_FAILURE;
    }

    while((x = getc(iptr)) != EOF)
    {        
        fprintf(optr, "%c", x);
        x = getc(iptr);
        x = '0';
    }
    fclose(iptr);
    fclose(optr);
    return EXIT_SUCCESS;
}