/* scanner.c - 
   a lexical analyzer system for simple
                 arithmetic expressions */

#include "expression.h"

/******************************************************/
/* main driver */
int  main(int argc, char * argv[]) { /* Open the input data file and process its contents */ 
   if(argc>1){
      if ((in_fp = fopen(argv[1], "r")) == NULL) {
         printf("ERROR - cannot open front.in \n"); 
         exit(1);
      } 
   } else {
     in_fp = stdin;
   }
     
   getChar(); 
   do {
       lex();
   } while (nextToken != EOF);
}

/*****************************************************/ 
/* lookup - a function to lookup operators and parentheses 
   and return the token */ 
int lookup(char ch) {
   switch (ch) {
      case '(':
         addChar();
         nextToken = LEFT_PAREN; break;
      case ')':
         addChar();
         nextToken = RIGHT_PAREN; break;
      case '+':
         addChar(); 
         nextToken = ADD_OP; break;
      case '-':
         addChar(); 
         nextToken = SUB_OP; break;
      case '*':
         addChar(); 
         nextToken = MULT_OP; break;
      case '/':
         addChar(); 
         nextToken = DIV_OP; break;
      default: addChar(); 
         nextToken = UNKNOWN; break;
   }
   return nextToken; 
}
/*****************************************************/ 
/* addChar - a function to add nextChar to lexeme */ 
void addChar() {
   if (lexLen <= 98) { 
      lexeme[lexLen++] = nextChar; 
      lexeme[lexLen] = 0;
}
else
    printf("Error - lexeme is too long \n");
}

/*****************************************************/
/* getChar - a function to get the next character of input 
   and determine its character class */ 
void getChar() {
   if ((nextChar = getc(in_fp)) != EOF) { 
      if (isalpha(nextChar))
         charClass = LETTER;
      else if (isdigit(nextChar))
         charClass = DIGIT; else charClass = UNKNOWN;
   }
   else
     charClass = EOF;
}

/*****************************************************/
/* getNonBlank - a function to call getChar until it
   returns a non-whitespace character */ 
void getNonBlank() {
   while (isspace(nextChar)) getChar();
}

char * tokeName(int type) {
   static char *  spelling[UNKNOWN+1];
   for(int i=0;i<UNKNOWN+1; i++)
      spelling[i] = "none";
   
   spelling[INT_LIT]    ="INT_LIT";
   spelling[IDENT]      ="IDENT";
   spelling[ASSIGN_OP]  ="ASSIGN_OP";
   spelling[ADD_OP]     ="ADD_OP";
   spelling[SUB_OP]     ="SUB_OP";
   spelling[MULT_OP]    ="MULT_OP";
   spelling[DIV_OP]     ="DIV_OP";
   spelling[LEFT_PAREN] ="LEFT_PAREN";
   spelling[RIGHT_PAREN]="RIGHT_PAREN";
   spelling[UNKNOWN]    ="UNKNOWN";
   
   if( type < 0 || type > UNKNOWN)  return "EOF";

   return spelling[type];

}

/*****************************************************/
/* lex - a simple lexical analyzer for arithmetic
   expressions */ 
int lex() {
   lexLen = 0; 
   getNonBlank(); 
   switch (charClass) {
      /* Parse identifiers */ 
      case LETTER:
         addChar();
         getChar();
         while (charClass == LETTER || charClass == DIGIT) {
            addChar();
            getChar(); 
         }
         nextToken = IDENT; 
         break;
      /* Parse integer literals */ 
      case DIGIT:
         addChar();
         getChar();
         while (charClass == DIGIT) {
            addChar();
            getChar(); 
         }
         nextToken = INT_LIT; 
         break;
      /* Parentheses and operators */ 
      case UNKNOWN:
         lookup(nextChar); 
           getChar();
         break;
      /* EOF */ 
      case EOF:
         nextToken = EOF; 
         lexeme[0] = 'E'; 
         lexeme[1] = 'O'; 
         lexeme[2] = 'F'; 
         lexeme[3] = 0; 
         break;
  } /* End of switch */
   //printf("Token: %d, Next lexeme is %s\n", nextToken, lexeme);
   printf("Token: %s, Next lexeme is %s\n", tokeName(nextToken), lexeme);
   return nextToken;
} /* End of function lex */