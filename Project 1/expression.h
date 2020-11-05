/* expression.h  - header file for 
   simple arithmetic expressions */

#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
/* Global declarations */ /* Variables */
int charClass;
char lexeme [100];
char nextChar;
int lexLen;
int token;
int nextToken;
FILE *in_fp, *fopen();

/* lex Function declarations */
void addChar();
void getChar();
void getNonBlank();
int lex();

/* parser function declarations */
void expr();
void term();
void factor();
//void errorexit();

/* Character classes */
#define LETTER 0
#define DIGIT 1
#define UNKNOWN 62

/* Token codes */
#define INT_LIT 14
#define IDENT 17
#define ASSIGN_OP 20
#define ADD_OP 21
#define SUB_OP 22
#define MULT_OP 23
#define DIV_OP 24
#define LEFT_PAREN 50
#define RIGHT_PAREN 51