#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(void)
{
    int i = 0;
    printf("%d\n", i);
    int *nPtr = &i;
    *nPtr = *nPtr + 7;
    printf("%d\n", i);
}
