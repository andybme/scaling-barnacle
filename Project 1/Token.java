public class Token {

   String lexeme = new String("");
   int type;
   int value = 0;

   
   /* Token codes */
/* Token Codes for Toy Language */
   static final int CHAR_LIT        = 10;
   static final int STRING_LIT      = 11;
   static final int FLOAT_LIT       = 12;
   static final int BOOL_LIT        = 13;
   static final int INT_LIT         = 14;
   static final int IDENT           = 17;
   static final int ASSIGN_OP       = 20;
   static final int ADD_OP          = 21;
   static final int SUB_OP          = 22;
   static final int MULT_OP         = 23;
   static final int DIV_OP          = 24;
   static final int MOD_OP          = 25;
   static final int POW_OP          = 26;
   static final int NOT             = 29;
   static final int EQUAL           = 30;
   static final int NOTEQUAL        = 31;
   static final int LESS            = 32;
   static final int MORE            = 33;
   static final int LESS_EQUAL      = 34;
   static final int MORE_EQUAL      = 35;
   static final int STRING          = 39;
   static final int INT             = 40;
   static final int FLOAT           = 41;
   static final int CHAR            = 42;
   static final int BOOL            = 43;
   static final int MAIN            = 44;
   static final int IF              = 45;
   static final int WHILE           = 46;
   static final int READ            = 47;
   static final int WRITE           = 48;
   static final int PROCEDURE       = 49; 
   static final int LEFT_PAREN      = 50; 
   static final int RIGHT_PAREN     = 51;
   static final int COMMA           = 52;
   static final int SEMICOLON       = 53; 
   static final int LEFT_BRACKET    = 54;
   static final int RIGHT_BRACKET   = 55;
   static final int LEFT_CURLY      = 56;
   static final int RIGHT_CURLY     = 57;
   static final int EOL		    = 59;
   static final int PERIOD          = 60;
   static final int EOF             = 61;
   static final int UNKNOWN         = 62;

   public static String spelling[];
   static { 
      spelling = new String[UNKNOWN+1];
      for(int i=0;i<UNKNOWN; i++)
         spelling[i] = new String("none");
      spelling[INT_LIT]    ="INT_LIT";
      spelling[FLOAT_LIT]  ="FLOAT_LIT";
      spelling[CHAR_LIT]   ="CHAR_LIT";
      spelling[BOOL_LIT]   ="BOOL_LIT";
      spelling[STRING_LIT] ="STRING_LIT";
      spelling[INT]        ="INT";
      spelling[FLOAT]      ="FLOAT";
      spelling[CHAR]       ="CHAR";
      spelling[BOOL]       ="BOOL";
      spelling[STRING]     ="STRING";
      spelling[IDENT]      ="IDENT";
      spelling[ASSIGN_OP]  ="ASSIGN_OP";
      spelling[ADD_OP]     ="ADD_OP";
      spelling[SUB_OP]     ="SUB_OP";
      spelling[MULT_OP]    ="MULT_OP";
      spelling[DIV_OP]     ="DIV_OP";
      spelling[MOD_OP]     ="MOD_OP";
      spelling[POW_OP]     ="POW_OP";
      spelling[LEFT_PAREN] ="LEFT_PAREN";
      spelling[RIGHT_PAREN]="RIGHT_PAREN";
      spelling[NOT]        ="NOT";
      spelling[EQUAL]      ="EQUAL";
      spelling[NOTEQUAL]   ="NOT_EQUAL";
      spelling[LESS]       ="LESS_THAN";
      spelling[MORE]       ="MORE_THAN";
      spelling[LESS_EQUAL] ="LESS_OR_EQUAL";
      spelling[MORE_EQUAL] ="MORE_OR_EQUAL";
      spelling[MAIN]       ="MAIN";
      spelling[IF]         ="IF";
      spelling[WHILE]      ="WHILE";
      spelling[READ]       ="READ";
      spelling[WRITE]      ="WRITE";
      spelling[PROCEDURE]  ="PROCEDURE";
      spelling[LEFT_CURLY] ="LEFT_CURLY";
      spelling[RIGHT_CURLY]="RIGHT_CURLY";
      spelling[COMMA]      ="COMMA";
      spelling[SEMICOLON]  ="SEMICOLON";
      spelling[LEFT_BRACKET]="LEFT_BRACKET";
      spelling[RIGHT_BRACKET]="RIGHT_BRACKET";
      spelling[PERIOD]       ="PERIOD";
      spelling[EOF]        ="EOF";
      spelling[UNKNOWN]    ="UNKNOWN";
   }


   public static char abbreviations [];
   static {
      abbreviations = new char [UNKNOWN+1];
      for(int i=0;i<UNKNOWN; i++)
         abbreviations[i] = '#';
      abbreviations[ASSIGN_OP]  ='=';
      abbreviations[ADD_OP]     ='+';
      abbreviations[SUB_OP]     ='-';
      abbreviations[MULT_OP]    ='*';
      abbreviations[DIV_OP]     ='/';
      abbreviations[MOD_OP]     ='%';
      abbreviations[POW_OP]     ='^';
      abbreviations[LEFT_PAREN] ='(';
      abbreviations[RIGHT_PAREN]=')'; 
      abbreviations[NOT]        ='!'; 
      abbreviations[LESS]       ='<'; 
      abbreviations[MORE]       ='>'; 
      abbreviations[COMMA]      =','; 
      abbreviations[SEMICOLON]  =';'; 
      abbreviations[LEFT_BRACKET]='['; 
      abbreviations[RIGHT_BRACKET]=']'; 
      abbreviations[LEFT_CURLY]='{'; 
      abbreviations[RIGHT_CURLY]='}'; 
      abbreviations[PERIOD]     ='.';
   }




   public Token(){
      lexeme      = new String("");
      type       = UNKNOWN;
      value       = 0;
   }

   public Token(int tokentype) {
      this();
      setValue(tokentype);
      setLexeme(tokentype);
   }

   public Token(int tokentype, String lexstring) {
      this(tokentype);
      setLexeme(lexstring);
   }

   public Token(int tokentype, String lexstring, int tokenvalue) {
      this(tokentype, lexstring);
      setValue(tokenvalue);
   }

   public Token(int tokentype, int tokenvalue) {
      this(tokentype);
      setValue(tokentype);
      setLexeme(tokentype);
   }

   public Token(Token t) {
      this(t.type, t.lexeme, t.value);
   }

   // set - get Value
   public void   setValue(int tokenvalue){ 
      value=tokenvalue; 
      if( type == INT_LIT ) lexeme = new String("");//+value);
   }
   public int    getValue(){ return value; }

   // set - get type
   public void   setType(int tokentype){ 
      type=tokentype; 
      if( type == INT_LIT ) lexeme = new String("");//+value); 
   }
   public int    getType(){ return type; }

   // other getters
   public String    getTypeName(){ return new String(spelling[type]); }
   public char getSymbol(){
      return abbreviations[type];
   } 
   

   // set - get Lexeme
   public void   setLexeme(int type){ 
      if( type == INT_LIT )
         lexeme = new String(""); //+value); 
      else
         lexeme = new String(spelling[type]); 
   }
   public void   setLexeme(String str){ 
      lexeme = new String(str); 
   }
   public String getLememe(){ return lexeme; }


   // toString - printing
   public String toString(){
         //return new String(spelling[type]+", \t\tLexeme:"+lexeme +", \tValue:"+value);
         return String.format("%-20s   %-10s (%d)", spelling[type], lexeme, value);
   }
}