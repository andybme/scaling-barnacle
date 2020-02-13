/*
Andy Me
CSC 251
Lab #7
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int generator(void);
void outprints(int*);

int main(void)
{
	int rolls = 0;
	srand(time(0));
	printf("How many times would you like to roll the die?");
	scanf("%d", &rolls);
	int output[10];
	int i;
	for (i = 0; i < 10; i++)
	{
		output[i] = 0;
	}
	for (i = 0; i < rolls; i++)
	{
		int currentroll = generator();
		output[currentroll]++;
	}
	outprints(output);

}

int generator(void)
{
	return rand()%10;
}

void outprints(int* output)
{
	int i;
	char text[10][10] = {"ones", "twos", "threes", "fours", "fives", "sixes", "sevens", "eights", "nines", "tens"};
	for (i = 1; i <= 10; i++)
	{
		printf("%d %s\n", output[i-1], text[i-1]);
	}

}