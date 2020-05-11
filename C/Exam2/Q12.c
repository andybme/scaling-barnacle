/*
Andy Me
Exam 2 Question 12
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char **argv)
{
    FILE *iptr, *optr;
    int input = 0;
    char text;

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

    fscanf(iptr, "%c", &text);
    while(!feof(iptr))
    {
        if(islower(text))
        {
            fprintf(optr, "%c", toupper(text));
        } else if(isupper(text))
        {
            fprintf(optr, "%c", tolower(text));
        } else
        {
            fprintf(optr, "%c", text);
        }
        fscanf(iptr, "%c", &text);
    }

    fclose(iptr);
    fclose(optr);
    return EXIT_SUCCESS;

}