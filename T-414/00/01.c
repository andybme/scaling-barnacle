#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char **argv)
{
    FILE *iptr, *optr;
    int input1, input2, output;

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

    fscanf(iptr, "%d%d", &input1, &input2);

    while(!feof(iptr))
    {
        
        output = input1 - input2;
        if(output < 0)
        {
            output = input2 - input1;
        }
        fprintf(optr, "%d\n", output);
        fscanf(iptr, "%d%d", &input1, &input2);
    }
}