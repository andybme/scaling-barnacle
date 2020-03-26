#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int *ptr;
	int array[5] = {0};
	int x = 5;
	ptr = &x;

	printf("Value in ptr is address %p\n", ptr);
	printf("Value at address pointer points to is %d\n", *ptr);

	*ptr = 7;

	printf("Value in ptr is address %p\n", ptr);
	printf("Value at address pointer points to is %d\n", *ptr);

	

	ptr = array;
	int i;
	for (i = 0; i < 5; i++)
		{
			*ptr = i;
			ptr++;
		}
	ptr = array;
	for (i = 0; i < 5; i++)
		{
			printf("Value is: %d\n", *ptr);
			ptr++;
		
		}

	return EXIT_SUCCESS;

		

}