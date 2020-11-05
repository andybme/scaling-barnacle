/* Scanner.java
   Implements a simple lexical analyzer based on java.io.StreamTokenizer

   Compile:
   javac Scanner.java

   Execute:
   java Scanner 
*/

import java.io.*;

public class Scanner {
   public static void main(String argv[]) throws IOException {
      InputStreamReader reader;
      if (argv.length > 0)
         reader = new InputStreamReader(new FileInputStream(argv[0]));
      else
         reader = new InputStreamReader(System.in);

      // create the tokenizer:
      StreamTokenizer tokenstream = new StreamTokenizer(reader);
      // the following char have not special meaning - treat them as ordinary 
      tokenstream.ordinaryChar('.');
      tokenstream.ordinaryChar('-');
      tokenstream.ordinaryChar('/');

      // set to ignore slash-slash comments 
      tokenstream.slashSlashComments(true);

      // set to ignore slash-slash comments as recognizable
      tokenstream.slashStarComments(true);

      // keep current char ascii value  in variable "next":
      int next;

      // while more input, split input stream up into tokenstream and display:
      while ((next = tokenstream.nextToken()) != tokenstream.TT_EOF) {
         Token token = new Token();

         if (next == tokenstream.TT_NUMBER){
            token.setValue( (int) tokenstream.nval);   // nval is a double
            token.setType(Token.INT_LIT);
            System.out.println("INT_LIT:   " +  token.getValue());
         } 

         else if (next == tokenstream.TT_WORD) {
            System.out.println("WORD:   " + tokenstream.sval);
         } 

         else { 
           switch ((char)next) {
              case '"':
                 System.out.println("STRING: " + tokenstream.sval);
                 break;
              case '\'':
                 System.out.println("CHAR:   " + tokenstream.sval);
                 break;
              default:
                 System.out.println("PUNCT:  " + (char)next);
           }
        }
      }
      System.out.println("All Done");
   }
}