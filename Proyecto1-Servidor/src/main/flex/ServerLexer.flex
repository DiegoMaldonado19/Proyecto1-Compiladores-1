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
        return new Symbol(type, new Token(value.toString(), yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type) {
        return new Symbol(type, new Token(null, yyline + 1, yycolumn + 1));
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
    {quotation}                 {   yybegin(QUOTATION_MARK); }
    {lbrace}                    { return symbol(ServerParserSym.LBRACE, yytext()); }
    {rbrace}                    { return symbol(ServerParserSym.RBRACE, yytext()); }
    {colon}                     { return symbol(ServerParserSym.COLON, yytext()); }
    {comma}                     { return symbol(ServerParserSym.COMMA, yytext()); }
    {lbracket}                  { return symbol(ServerParserSym.LBRACKET, yytext()); }
    {rbracket}                  { return symbol(ServerParserSym.RBRACKET, yytext()); }
    {lparen}                    { return symbol(ServerParserSym.LPAREN, yytext()); }
    {rparen}                    { return symbol(ServerParserSym.RPAREN, yytext()); }
    {digit}                     { return symbol(ServerParserSym.DIGIT, yytext()); } 
}

<QUOTATION_MARK>{
    {quotation}         {   yybegin(YYINITIAL); }
    {whitespace}        {/*ignore*/}
    {name}                      { return symbol(ServerParserSym.NAME, yytext()); }
    {rows}                      { return symbol(ServerParserSym.ROWS, yytext()); }
    {cols}                      { return symbol(ServerParserSym.COLS, yytext()); }
    {config}                    { return symbol(ServerParserSym.CONFIG, yytext()); }
    {box_color}                 { return symbol(ServerParserSym.BOX_COLOR, yytext()); }
    {box_on_target_color}       { return symbol(ServerParserSym.BOX_ON_TARGET_COLOR, yytext()); }
    {target_color}              { return symbol(ServerParserSym.TARGET_COLOR, yytext()); }
    {brick_color}               { return symbol(ServerParserSym.BRICK_COLOR, yytext()); }
    {hall_color}                { return symbol(ServerParserSym.HALL_COLOR, yytext()); }
    {undefined_color}           { return symbol(ServerParserSym.UNDEFINED_COLOR, yytext()); }
    {player_color}              { return symbol(ServerParserSym.PLAYER_COLOR, yytext()); }
    {board}                     { return symbol(ServerParserSym.BOARD, yytext()); }
    {posX}                      { return symbol(ServerParserSym.POSX, yytext()); }
    {posY}                      { return symbol(ServerParserSym.POSY, yytext()); }
    {type}                      { return symbol(ServerParserSym.TYPE, yytext()); }
    {boxes}                     { return symbol(ServerParserSym.BOXES, yytext()); }
    {floor}                     { return symbol(ServerParserSym.FLOOR, yytext()); }
    {ceil}                      { return symbol(ServerParserSym.CEIL, yytext()); }    
    {targets}                   { return symbol(ServerParserSym.TARGETS, yytext()); }
    {player}                    { return symbol(ServerParserSym.PLAYER, yytext()); }
    {brick}                     { return symbol(ServerParserSym.BRICK, yytext()); }
    {hall}                      { return symbol(ServerParserSym.HALL, yytext()); }                
    {identifier}                { return symbol(ServerParserSym.IDENTIFIER, yytext()); }
    {hexadecimal}               { return symbol(ServerParserSym.HEXADECIMAL, yytext()); }
    {digit}                     { return symbol(ServerParserSym.DIGIT, yytext()); }
    {decimal}                   { return symbol(ServerParserSym.DECIMAL, yytext()); }
    {plus}                      { return symbol(ServerParserSym.PLUS, yytext()); }
    {div}                       { return symbol(ServerParserSym.DIV, yytext()); }
    {minus}                     { return symbol(ServerParserSym.MINUS, yytext()); }
    {mult}                      { return symbol(ServerParserSym.MULT, yytext()); }
}

[^]   { error(yytext()); return symbol(ServerParserSym.ERROR, yytext());}


<<EOF>>         { return symbol(ServerParserSym.EOF); }   

