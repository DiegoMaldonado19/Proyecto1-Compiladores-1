
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.dmaldonado.cliente.compiler;

import java.util.*;
import java_cup.runtime.*;
import com.dmaldonado.cliente.model.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class GameParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return GameParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public GameParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public GameParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public GameParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\002\003\000\002\002" +
    "\003\000\002\004\005\000\002\004\006\000\002\004\004" +
    "\000\002\005\005\000\002\003\003\000\002\003\003\000" +
    "\002\003\003\000\002\003\003\000\002\006\005\000\002" +
    "\006\004\000\002\007\005\000\002\007\005\000\002\007" +
    "\005\000\002\007\005\000\002\007\004\000\002\007\005" +
    "\000\002\007\003\000\002\007\003\000\002\007\003\000" +
    "\002\010\006\000\002\010\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\020\004\016\005\014\006\006\007\012\010" +
    "\013\012\007\026\010\001\002\000\006\014\023\026\021" +
    "\001\002\000\004\002\000\001\002\000\006\014\ufff8\026" +
    "\ufff8\001\002\000\004\025\061\001\002\000\016\004\016" +
    "\005\014\006\006\007\012\010\013\026\010\001\002\000" +
    "\004\002\uffff\001\002\000\006\014\ufff7\026\ufff7\001\002" +
    "\000\012\004\016\005\014\006\006\007\012\001\002\000" +
    "\006\014\ufff9\026\ufff9\001\002\000\004\002\017\001\002" +
    "\000\006\014\ufffa\026\ufffa\001\002\000\004\002\001\001" +
    "\002\000\006\014\023\026\021\001\002\000\006\014\023" +
    "\026\021\001\002\000\004\016\056\001\002\000\016\011" +
    "\031\013\024\014\026\017\033\020\030\023\025\001\002" +
    "\000\004\014\053\001\002\000\016\011\031\013\024\014" +
    "\026\017\033\020\030\023\025\001\002\000\016\011\031" +
    "\013\024\014\026\017\033\020\030\023\025\001\002\000" +
    "\014\015\047\021\040\022\042\023\041\024\036\001\002" +
    "\000\014\015\uffed\021\uffed\022\uffed\023\uffed\024\uffed\001" +
    "\002\000\004\014\034\001\002\000\014\015\uffec\021\uffec" +
    "\022\uffec\023\uffec\024\uffec\001\002\000\014\015\uffee\021" +
    "\uffee\022\uffee\023\uffee\024\uffee\001\002\000\016\011\031" +
    "\013\024\014\026\017\033\020\030\023\025\001\002\000" +
    "\014\015\037\021\040\022\042\023\041\024\036\001\002" +
    "\000\016\011\031\013\024\014\026\017\033\020\030\023" +
    "\025\001\002\000\014\015\uffea\021\uffea\022\uffea\023\uffea" +
    "\024\uffea\001\002\000\016\011\031\013\024\014\026\017" +
    "\033\020\030\023\025\001\002\000\016\011\031\013\024" +
    "\014\026\017\033\020\030\023\025\001\002\000\016\011" +
    "\031\013\024\014\026\017\033\020\030\023\025\001\002" +
    "\000\014\015\ufff1\021\ufff1\022\ufff1\023\ufff1\024\ufff1\001" +
    "\002\000\014\015\ufff3\021\ufff3\022\042\023\ufff3\024\036" +
    "\001\002\000\014\015\ufff4\021\ufff4\022\042\023\ufff4\024" +
    "\036\001\002\000\014\015\ufff2\021\ufff2\022\ufff2\023\ufff2" +
    "\024\ufff2\001\002\000\004\016\ufff6\001\002\000\014\015" +
    "\051\021\040\022\042\023\041\024\036\001\002\000\014" +
    "\015\uffef\021\uffef\022\uffef\023\uffef\024\uffef\001\002\000" +
    "\014\015\ufff0\021\ufff0\022\042\023\ufff0\024\036\001\002" +
    "\000\016\011\031\013\024\014\026\017\033\020\030\023" +
    "\025\001\002\000\014\015\055\021\040\022\042\023\041" +
    "\024\036\001\002\000\014\015\uffeb\021\uffeb\022\uffeb\023" +
    "\uffeb\024\uffeb\001\002\000\004\002\ufffd\001\002\000\004" +
    "\016\ufff5\001\002\000\004\002\ufffc\001\002\000\004\012" +
    "\062\001\002\000\004\002\ufffb\001\002\000\004\016\064" +
    "\001\002\000\004\002\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\012\002\014\003\003\004\004\005\010\001" +
    "\001\000\004\006\062\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\003\003\004\057\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\017" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\021\001\001\000\004" +
    "\006\056\001\001\000\002\001\001\000\006\007\026\010" +
    "\031\001\001\000\002\001\001\000\006\007\051\010\031" +
    "\001\001\000\006\007\047\010\031\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\007\034\010\031\001\001\000" +
    "\002\001\001\000\006\007\045\010\031\001\001\000\002" +
    "\001\001\000\006\007\044\010\031\001\001\000\006\007" +
    "\043\010\031\001\001\000\006\007\042\010\031\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\007\053\010\031\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$GameParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$GameParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$GameParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private ArrayList<String> errorList;
    private ArrayList<Token> tokenList;

        public GameParser(GameLexer lex){
            super(lex);
            this.errorList = new ArrayList();
            this.tokenList = new ArrayList();
        }

        @Override
        public void syntax_error(Symbol symbol){
            Token token = (Token) symbol.value;
            report_error("Se encontro un error con el token: "+token.getLexeme()+" en la linea: "+token.getLine()+" en la columna: "+token.getColumn());

            System.out.println(report_error("Se encontro un error con el token: "+token.getLexeme()+" en la linea: "+token.getLine()+" en la columna: "+token.getColumn()));

            errorList.add(String.format(report_error("Se encontro un error con el token: "+token.getLexeme()+" en la linea: "+token.getLine()+" en la columna: "+token.getColumn())));
        }

        private String report_error(String s) {
            return s;
        }

        public ArrayList<Token> getTokenList(){
            return tokenList;
        }

        public ArrayList<String> getErrorList(){
            return errorList;
        }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$GameParser$actions {
  private final GameParser parser;

  /** Constructor */
  CUP$GameParser$actions(GameParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$GameParser$do_action_part00000000(
    int                        CUP$GameParser$act_num,
    java_cup.runtime.lr_parser CUP$GameParser$parser,
    java.util.Stack            CUP$GameParser$stack,
    int                        CUP$GameParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$GameParser$result;

      /* select the action based on the action number */
      switch (CUP$GameParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= game EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).value;
		RESULT = start_val;
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$GameParser$parser.done_parsing();
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // game ::= movement 
            {
              Object RESULT =null;

              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("game",0, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // game ::= comment 
            {
              Object RESULT =null;

              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("game",0, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // movement ::= reserved_words expresion_block SEMICOLON 
            {
              Object RESULT =null;

              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("movement",2, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // movement ::= PUSH reserved_words expresion_block SEMICOLON 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-3)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-3)).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-3)).value;
		 tokenList.add( new Token(e.getLexeme(), e.getLine(), e.getColumn())); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("movement",2, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-3)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // movement ::= ERROR movement 
            {
              Object RESULT =null;
		 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("movement",2, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // comment ::= HASH STRING HASH 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).value;
		 tokenList.add( new Token(e.getLexeme(), e.getLine(), e.getColumn())); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("comment",3, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // reserved_words ::= UP 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 tokenList.add( new Token(e.getLexeme(), e.getLine(), e.getColumn())); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("reserved_words",1, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // reserved_words ::= DOWN 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 tokenList.add( new Token(e.getLexeme(), e.getLine(), e.getColumn())); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("reserved_words",1, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // reserved_words ::= LEFT 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 tokenList.add( new Token(e.getLexeme(), e.getLine(), e.getColumn())); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("reserved_words",1, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // reserved_words ::= RIGHT 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 tokenList.add( new Token(e.getLexeme(), e.getLine(), e.getColumn())); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("reserved_words",1, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expresion_block ::= LPAREN expr RPAREN 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).right;
		Double e = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).value;
		 RESULT = e.intValue(); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expresion_block",4, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expresion_block ::= ERROR expresion_block 
            {
              Integer RESULT =null;
		 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expresion_block",4, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expr ::= expr PLUS expr 
            {
              Double RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).right;
		Double e1 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Double e2 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = e1 + e2; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expr ::= expr MINUS expr 
            {
              Double RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).right;
		Double e1 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Double e2 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = e1 - e2; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expr ::= expr MULT expr 
            {
              Double RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).right;
		Double e1 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Double e2 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = e1 * e2; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expr ::= expr DIV expr 
            {
              Double RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).right;
		Double e1 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Double e2 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = e1 / e2; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expr ::= MINUS expr 
            {
              Double RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Double e1 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = -e1; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expr ::= LPAREN expr RPAREN 
            {
              Double RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).right;
		Double e1 = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).value;
		 RESULT = e1; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-2)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expr ::= DIGIT 
            {
              Double RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = Double.valueOf(e.getLexeme()); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expr ::= DECIMAL 
            {
              Double RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Token e = (Token)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = Double.valueOf(e.getLexeme()); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expr ::= op 
            {
              Double RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()).right;
		Double e = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.peek()).value;
		 RESULT = e; 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // op ::= FLOOR LPAREN expr RPAREN 
            {
              Double RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).right;
		Double e = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).value;
		 RESULT = Math.floor(e); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("op",6, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-3)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // op ::= CEIL LPAREN expr RPAREN 
            {
              Double RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).right;
		Double e = (Double)((java_cup.runtime.Symbol) CUP$GameParser$stack.elementAt(CUP$GameParser$top-1)).value;
		 RESULT = Math.ceil(e); 
              CUP$GameParser$result = parser.getSymbolFactory().newSymbol("op",6, ((java_cup.runtime.Symbol)CUP$GameParser$stack.elementAt(CUP$GameParser$top-3)), ((java_cup.runtime.Symbol)CUP$GameParser$stack.peek()), RESULT);
            }
          return CUP$GameParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$GameParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$GameParser$do_action(
    int                        CUP$GameParser$act_num,
    java_cup.runtime.lr_parser CUP$GameParser$parser,
    java.util.Stack            CUP$GameParser$stack,
    int                        CUP$GameParser$top)
    throws java.lang.Exception
    {
              return CUP$GameParser$do_action_part00000000(
                               CUP$GameParser$act_num,
                               CUP$GameParser$parser,
                               CUP$GameParser$stack,
                               CUP$GameParser$top);
    }
}

}
