grammar Lisp;

@header{
import java.util.HashMap;
import java.io.*;


}

// To include a header to lexer @lexer::header {package pkg.name;}


@members {
        
	// private int[] store = new int[26]; // implement hashmap
	// ... storage for variables 'a', ..., 'z'
        HashMap store = new HashMap(); // implementation of hashmap
}

// Programs 

prog
	:	com* (EOF | EOL)   
	;

// Commands

com
	:	'(' PUT v=sexpr ')' EOL       { LispIntRun.output.println($v.value); // PrintWriter
                                                try
                                                {
                                                PrintWriter writerout = null; 
                                                writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
                                                writerout.println($v.value); // LispIntRun.filewriter.println();
                                                writerout.close();
                                                }
                                                catch (IOException ioe)
                                                {
                                                        System.out.println("File I/O error: ");
                                                        ioe.printStackTrace(); // print out details of where exception occurred			
                                                }
                                              }
	|	'(' SETQ ID v=sexpr ')' EOL       { 
                                                    store.put($ID.text,new Integer($v.value));
                                                    //Hashmap is composed by: ID (variable name), Numeric Value 
                                                  }
	;

// Expressions

sexpr		                     returns [int value]
	:	v1=term              { $value = $v1.value; }
		|('('
                PLUS v1=sexpr v2=sexpr ')' {$value = $v1.value + $v2.value;}
                | '(' MINUS v1=sexpr v2=sexpr ')' {$value = $v1.value - $v2.value;} 
                | '(' TIMES v1=sexpr v2=sexpr ')' {$value = $v1.value * $v2.value;}
                | '(' QUOTIENT v1=sexpr v2=sexpr ')' {$value = $v1.value / $v2.value;}
                )
	;

term		                     returns [int value]
	:	NUM                  { $value = Integer.parseInt(
		                         $NUM.text); }
	|	ID                   {  
                                       Integer v3 = (Integer)store.get($ID.text);
                                       if ( v3!=null ) $value = v3.intValue();
                                       else System.err.println("undefined variable "+$ID.text);
                                      }
	|	'(' v=sexpr ')'     { $value = $v.value; }
	;

// Lexer rules

PUT	:	'put' ;
SETQ	:	'setq' ;

ASSN	:	'=' ;
PLUS	:	'+' ;
MINUS	:	'-' ;
TIMES	:	'*' ;   
QUOTIENT    :   '/' ;

LPAR	:	'(' ;
RPAR	:	')' ;

ID	:	('a'..'z'|'A'..'Z')+ ;
NUM	:	'0'..'9'+ ;

EOL	:	'\r'? '\n' ;

SPACE	:	(' ' | '\t')+        { skip(); } ;
