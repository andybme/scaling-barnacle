/*
Andy Me
Lab 11
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

void firstCase(FILE *iptr, FILE *optr);
void secondCase(FILE *iptr, FILE *optr);
void thirdCase(FILE *iptr, FILE *optr);
void fourthCase(FILE *iptr, FILE *optr);

int main(int argc, char **argv)
{
    FILE *iptr, *optr;
    int input = 0;

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
      
    puts("Choose an option below to modify your wordlist: ");
    puts("1. Change the second letter to a capital letter.");
    puts("2. Make each word lowercase except for the last letter.");
    puts("3. Make each word uppercase except for the first letter.");
    puts("4. Duplicate each word 5 times and display the word with it's duplicate # after it.");
    printf("%s", "? ");
    scanf("%d", &input);

    switch (input)
    {
        case 1:
            firstCase(iptr, optr);
            break;
        case 2:
            secondCase(iptr, optr);
            break;
        case 3:
            thirdCase(iptr, optr);
            break;
        case 4:
            fourthCase(iptr, optr);
            break;
        default:
            puts("Invalid input.");
    }
    fclose(iptr);
    fclose(optr);
    return EXIT_SUCCESS;

}

void firstCase(FILE *iptr, FILE *optr)
{
    char word[30];
    int i = 0;

    fscanf(iptr, "%s", word);
    while(!feof(iptr))
    {
        fscanf(iptr, "%s", word);
        word[1] = toupper(word[1]);
        fprintf(optr, "%s\n", word);
    }
}

void secondCase(FILE *iptr, FILE *optr)
{
    char word[30];
    int i, last;

    fscanf(iptr, "%s", word);
    while(!feof(iptr))
    {
        fscanf(iptr, "%s", word);
        for(i = 30; i > 0; i--)
        {
            if(word[i] == '\0')
            {
                last = i - 1;
            }
        }
        for(i = 0; i < last; i++)
        {
            word[i] = tolower(word[i]);
        }
        fprintf(optr, "%s\n", word);
    }
}

void thirdCase(FILE *iptr, FILE *optr)
{
    char word[30];
    int i;

    fscanf(iptr, "%s", word);
    while(!feof(iptr))
    {
        fscanf(iptr, "%s", word);
        
        for(i = 1; i < 30; i++)
        {
            word[i] = toupper(word[i]);
        }
        fprintf(optr, "%s\n", word);
    }
}

void fourthCase(FILE *iptr, FILE *optr)
{
    char word[30];
    int i = 0;

    fscanf(iptr, "%s", word);
    while(!feof(iptr))
    {
        fscanf(iptr, "%s", word);
        for(i = 1; i <= 5; i++)
        {
            fprintf(optr, "%s%d\n", word, i);
        }
        
    }
}