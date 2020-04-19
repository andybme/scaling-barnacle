#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(void)
{
    FILE *fptr, *rptr;
    int account = 0;
    char name[30];
    double balance = 0;

    // if((fptr = fopen("clients.txt", "w")) == NULL)
    // {
    //     puts("File could not be opened.");
    // }
    // else
    // {
    //     puts("Enter the account, name, and balance");
    //     puts("Enter EOF to end input");
    //     printf("%s", "? ");
    //     scanf("%d%29s%lf", &account, name, &balance);
        
    //     while(!feof(stdin))
    //     {
    //         fprintf(fptr,"%d %s %.2f \n", account, name, balance);
    //         printf("%s", "? ");
    //         scanf("%d%29s%lf", &account, name, &balance);
    //     }
    //     fclose(fptr);
    // }
    
    if ((rptr = fopen("clients.txt", "r")) == NULL)
    {
        puts("File does not exist");
    }else{
        fscanf(rptr, "%d%29s%lf", &account, name, &balance);
        while(!feof(rptr))
        {
            printf("account = %d, name = %s, balance = %f\n", account, name, balance);
            fscanf(rptr, "%d%29s%lf", &account, name, &balance);
        }
        fclose(rptr);
    }

    return EXIT_SUCCESS;
}