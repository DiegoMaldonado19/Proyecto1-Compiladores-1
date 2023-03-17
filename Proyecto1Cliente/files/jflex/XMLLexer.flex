package main.java.compiler.model;

import java_cup.runtime.Symbol;
import java.util.*;
import dmaldonado.server.model.*;

%%

%class XMLLexer
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

/* Macros*/
whitespace = [ \t\r\f\v\n]+
newline = [\n]

digit = [0-9]+
string = ([a-zA-Z0-9_]|{whitespace})+
hexadecimal = [#]?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})
prolog = ([a-zA-Z0-9_]|[ \t\r\f\v\n]|[?]|[\"]|[=]|[.]|[-])+

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
brick = "BRICK"
hall = "HALL"

greater_than = ">"
less_than = "<"
slash = "/"
question = "?"

%state PROLOG

%%

<YYINITIAL>{
    {name}                              { return symbol(XLMParserSym.NAME, yytext()); }
    {rows}                              { return symbol(XLMParserSym.ROWS, yytext()); }
    {cols}                              { return symbol(XLMParserSym.COLS, yytext()); }
    {config}                            { return symbol(XLMParserSym.CONFIG, yytext()); }
    {box_color}                         { return symbol(XLMParserSym.BOX_COLOR, yytext()); }
    {box_on_target_color}               { return symbol(XLMParserSym.BOX_ON_TARGET_COLOR, yytext()); }
    {target_color}                      { return symbol(XLMParserSym.TARGET_COLOR, yytext()); }
    {brick_color}                       { return symbol(XLMParserSym.BRICK_COLOR, yytext()); }
    {hall_color}                        { return symbol(XLMParserSym.HALL, yytext()); }
    {undefined_color}                   { return symbol(XLMParserSym.UNDEFINED_COLOR, yytext()); }
    {player_color}                      { return symbol(XLMParserSym.PLAYER_COLOR, yytext()); }
    {board}                             { return symbol(XLMParserSym.BOARD, yytext()); }
    {posX}                              { return symbol(XLMParserSym.POSX, yytext()); }
    {posY}                              { return symbol(XLMParserSym.POSY, yytext()); }
    {type}                              { return symbol(XLMParserSym.TYPE, yytext()); }
    {boxes}                             { return symbol(XLMParserSym.BOXES, yytext()); }
    {targets}                           { return symbol(XLMParserSym.TARGETS, yytext()); }
    {player}                            { return symbol(XLMParserSym.PLAYER, yytext()); }
    {brick}                             { return symbol(XLMParserSym.BRICK, yytext()); }
    {hall}                              { return symbol(XLMParserSym.HALL, yytext()); }

    {greater_than}                      { return symbol(XLMParserSym.GREATER_THAN, yytext()); }
    {less_than}                         { return symbol(XLMParserSym.LESS_THAN, yytext()); }
    {slash}                             { return symbol(XLMParserSym.SLASH, yytext()); }

    {digit}                             { return symbol(XLMParserSym.DIGIT, yytext()); }
    {string}                            { return symbol(XLMParserSym.STRING, yytext()); }
    {hexadecimal}                       { return symbol(XLMParserSym.HEXADECIMAL, yytext()); }
    {question}                          { yybegin(TAG); }

}

<PROLOG>{
    {question}                          { yybegin(YYINITIAL); }
    {prolog}                            { return symbol(XLMParserSym.PROLOG, yytext()); }
}


[^]   { error(yytext()); return symbol(GameParserSym.ERROR, yytext());}

<<EOF>>         { return symbol(GameParserSym.EOF); }   