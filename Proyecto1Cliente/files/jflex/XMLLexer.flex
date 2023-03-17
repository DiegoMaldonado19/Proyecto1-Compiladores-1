package com.dmaldonado.cliente.compiler;

import java_cup.runtime.Symbol;
import java.util.*;
import com.dmaldonado.cliente.model.*;

%%

%public
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
    {name}                              { return symbol(XMLParserSym.NAME, yytext()); }
    {rows}                              { return symbol(XMLParserSym.ROWS, yytext()); }
    {cols}                              { return symbol(XMLParserSym.COLS, yytext()); }
    {config}                            { return symbol(XMLParserSym.CONFIG, yytext()); }
    {box_color}                         { return symbol(XMLParserSym.BOX_COLOR, yytext()); }
    {box_on_target_color}               { return symbol(XMLParserSym.BOX_ON_TARGET_COLOR, yytext()); }
    {target_color}                      { return symbol(XMLParserSym.TARGET_COLOR, yytext()); }
    {brick_color}                       { return symbol(XMLParserSym.BRICK_COLOR, yytext()); }
    {hall_color}                        { return symbol(XMLParserSym.HALL, yytext()); }
    {undefined_color}                   { return symbol(XMLParserSym.UNDEFINED_COLOR, yytext()); }
    {player_color}                      { return symbol(XMLParserSym.PLAYER_COLOR, yytext()); }
    {board}                             { return symbol(XMLParserSym.BOARD, yytext()); }
    {posX}                              { return symbol(XMLParserSym.POSX, yytext()); }
    {posY}                              { return symbol(XMLParserSym.POSY, yytext()); }
    {type}                              { return symbol(XMLParserSym.TYPE, yytext()); }
    {boxes}                             { return symbol(XMLParserSym.BOXES, yytext()); }
    {targets}                           { return symbol(XMLParserSym.TARGETS, yytext()); }
    {player}                            { return symbol(XMLParserSym.PLAYER, yytext()); }
    {brick}                             { return symbol(XMLParserSym.BRICK, yytext()); }
    {hall}                              { return symbol(XMLParserSym.HALL, yytext()); }

    {greater_than}                      { return symbol(XMLParserSym.GREATER_THAN, yytext()); }
    {less_than}                         { return symbol(XMLParserSym.LESS_THAN, yytext()); }
    {slash}                             { return symbol(XMLParserSym.SLASH, yytext()); }

    {digit}                             { return symbol(XMLParserSym.DIGIT, yytext()); }
    {string}                            { return symbol(XMLParserSym.STRING, yytext()); }
    {hexadecimal}                       { return symbol(XMLParserSym.HEXADECIMAL, yytext()); }
    {question}                          { yybegin(PROLOG); }

}

<PROLOG>{
    {question}                          { yybegin(YYINITIAL); }
    {prolog}                            { return symbol(XMLParserSym.PROLOG, yytext()); }
}


[^]   { error(yytext()); return symbol(XMLParserSym.ERROR, yytext());}

<<EOF>>         { return symbol(XMLParserSym.EOF); }   