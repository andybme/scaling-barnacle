/*
Andy Me
CSC 251
1/27/2020
Lab #2
*/
#include <stdio.h>
#include<stdlib.h>

int main()
{
//ask the user for an input of 1-10
	int userNum;
	int magicNum = 6;
	printf("Please enter a number from 1 - 10: ");
	scanf("%d", &userNum);
	printf("\nYour number was: %d\n", userNum);
//do the math and output the result
	printf("%d + magic number = %d\n", userNum, userNum + magicNum);
	printf("%d * magic number = %d\n", userNum, userNum * magicNum);
	printf("%d - magic number = %d\n", userNum, userNum - magicNum);
//ask the user to guess the magic number
	printf("You have been given three clues, what is your guess of the magic number?\n");
	scanf("%d", &userNum);
	if(userNum == magicNum)
	{
		printf("Good job, you have guessed correctly!\n");
	} else{
		printf("Poor performance, try again next time.\n");
	}
	return EXIT_SUCCESS;
}
