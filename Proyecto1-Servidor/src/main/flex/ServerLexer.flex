package dmaldonado.server.compiler;

import dmaldonado.server.compiler.*;
import java_cup.runtime.Symbol;
import java.util.*;
import dmaldonado.server.model.*;

%%

%class ServerLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup
%cupdebug

%{
    private ArrayList<String>  errorList;  

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, new Token(value.toString(), type, yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type) {
        return new Symbol(type, new Token(null, type, yyline + 1, yycolumn + 1));
    }

    private void error(String lexeme){
        errorList.add(String.format("Error lexico en el texto: , %s, linea %d, columna %d, corrige e intenta de nuevo :)", lexeme, yyline+1, yycolumn+1));
    }

    public ArrayList<String> getErrorList(){
        return errorList;
    }
%}

%init{
    errorList = new ArrayList();    
%init}

%eofval{
    return token(EOF);
%eofval}

/* Macros */
whitespace = [ \t\r\f\v\n]+
newline = [\n]

digit = [0-9]+
decimal = [0-9]+[.][0-9]+
identifier = ([_][a-zA-Z][a-zA-Z0-9]+)|([a-zA-Z][A-Za-z0-9]+)
hexadecimal = [#]?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})


/* Palabras reservadas */
name = "name"
rows = "rows"
cols = "cols"
config = "config"
box_color = "box_color"
box_on_target_color = "box_on_target_color"
target_color =  "target_color"
brick_color =   "brick_color"
hall_color =    "hall_color"
undefined_color =   "undefined_color"
player_color=   "player_color"
board = "board"
posX =  "posX"
posY =  "posY"
type =  "type"
boxes = "boxes"
targets =  "targets"
player =  "player"
floor =   "FLOOR"
ceil =  "CEIL"
brick = "BRICK"
hall = "HALL"

/* Simbolos */
lbrace = "{"
rbrace = "}"
colon = ":"
comma = ","
lbracket = "["
rbracket = "]"
lparen = "("
rparen = ")"
plus = "+"
div = "/"
minus = "-"
mult = "*"
quotation = \" 

/* Estado para analizar lexicamente los lexemas entre comillas*/
%state QUOTATION_MARK

%%

<YYINITIAL>{
    {whitespace}        {/*ignore*/}
    {quotation}                 {   yybegin(QUOTATION_MARK);
                                    return symbol(sym.QUOTATION, yytext());
                                }
    {lbrace}                    { return symbol(sym.LBRACE, yytext()); }
    {rbrace}                    { return symbol(sym.RBRACE, yytext()); }
    {colon}                     { return symbol(sym.COLON, yytext()); }
    {comma}                     { return symbol(sym.COMMA, yytext()); }
    {lbracket}                  { return symbol(sym.LBRACKET, yytext()); }
    {rbracket}                  { return symbol(sym.RBRACKET, yytext()); }
    {lparen}                    { return symbol(sym.LPAREN, yytext()); }
    {rparen}                    { return symbol(sym.RPAREN, yytext()); }
    {digit}                     { return symbol(sym.DIGIT, yytext()); } 
}

<QUOTATION_MARK>{
    {quotation}         {   yybegin(YYINITIAL);
                            return symbol(sym.QUOTATION, yytext());
                        }
    {whitespace}        {/*ignore*/}
    {name}                      { return symbol(sym.NAME, yytext()); }
    {rows}                      { return symbol(sym.ROWS, yytext()); }
    {cols}                      { return symbol(sym.COLS, yytext()); }
    {config}                    { return symbol(sym.CONFIG, yytext()); }
    {box_color}                 { return symbol(sym.BOX_COLOR, yytext()); }
    {box_on_target_color}       { return symbol(sym.BOX_ON_TARGET_COLOR, yytext()); }
    {target_color}              { return symbol(sym.TARGET_COLOR, yytext()); }
    {brick_color}               { return symbol(sym.BRICK_COLOR, yytext()); }
    {hall_color}                { return symbol(sym.HALL_COLOR, yytext()); }
    {undefined_color}           { return symbol(sym.UNDEFINED_COLOR, yytext()); }
    {player_color}              { return symbol(sym.PLAYER_COLOR, yytext()); }
    {board}                     { return symbol(sym.BOARD, yytext()); }
    {posX}                      { return symbol(sym.POSX, yytext()); }
    {posY}                      { return symbol(sym.POSY, yytext()); }
    {type}                      { return symbol(sym.TYPE, yytext()); }
    {boxes}                     { return symbol(sym.BOXES, yytext()); }
    {floor}                     { return symbol(sym.FLOOR, yytext()); }
    {ceil}                      { return symbol(sym.CEIL, yytext()); }    
    {targets}                   { return symbol(sym.TARGETS, yytext()); }
    {player}                    { return symbol(sym.PLAYER, yytext()); }
    {brick}                     { return symbol(sym.BRICK, yytext()); }
    {hall}                      { return symbol(sym.HALL, yytext()); }                
    {identifier}                { return symbol(sym.IDENTIFIER, yytext()); }
    {hexadecimal}               { return symbol(sym.HEXADECIMAL, yytext()); }
    {digit}                     { return symbol(sym.DIGIT, yytext()); }
    {decimal}                   { return symbol(sym.DECIMAL, yytext()); }
    {plus}                      { return symbol(sym.PLUS, yytext()); }
    {div}                       { return symbol(sym.DIV, yytext()); }
    {minus}                     { return symbol(sym.MINUS, yytext()); }
    {mult}                      { return symbol(sym.MULT, yytext()); }
}

[^]   { error(yytext()); return symbol(sym.ERROR, yytext());}


<<EOF>>         { return symbol(sym.EOF); }   

