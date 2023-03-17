package main.java.compiler.model;

import java_cup.runtime.Symbol;
import java.util.*;
import dmaldonado.server.model.*;

%%

%class GameLexer
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
decimal = [0-9]+[.][0-9]+
string = ([a-zA-Z0-9_]|{whitespace})+

/* Palabras reservadas */

up = "up"
down = "down"
left = "left"
right = "right"
push = "push"
floor =   "FLOOR"
ceil =  "CEIL"

/* Simbolos */

lparen = "("
rparen = ")"
plus = "+"
div = "/"
minus = "-"
mult = "*"
semicolon = ";"
hash = "#"

%state COMMENT

%%

<YYINITIAL>{
    {whitespace}     {/*IGNORE*/}
    {hash}           { yybegin(COMMENT);
                       return symbol(GameParserSym.HASH, yytext());
                     }
    {up}             { return symbol(GameParserSym.UP, yytext()); }
    {down}           { return symbol(GameParserSym.DOWN, yytext()); }
    {left}           { return symbol(GameParserSym.LEFT, yytext()); }
    {right}          { return symbol(GameParserSym.RIGHT, yytext()); }
    {push}           { return symbol(GameParserSym.PUSH, yytext()); }
    {floor}          { return symbol(GameParserSym.FLOOR, yytext()); }
    {ceil}           { return symbol(GameParserSym.CEIL, yytext()); }    
    {lparen}         { return symbol(GameParserSym.LPAREN, yytext()); }
    {rparen}         { return symbol(GameParserSym.RPAREN, yytext()); }
    {semicolon}      { return symbol(GameParserSym.SEMICOLON, yytext()); }
    {digit}          { return symbol(GameParserSym.DIGIT, yytext()); }
    {decimal}        { return symbol(GameParserSym.DECIMAL, yytext()); }
    {plus}           { return symbol(GameParserSym.PLUS, yytext()); }
    {div}            { return symbol(GameParserSym.DIV, yytext()); }
    {minus}          { return symbol(GameParserSym.MINUS, yytext()); }
    {mult}           { return symbol(GameParserSym.MULT, yytext()); }
}

<COMMENT>{
    {hash}           {  yybegin(YYINITIAL);
                        return symbol(GameParserSym.HASH, yytext());
                     }

    {string}     { return symbol(GameParserSym.STRING, yytext()); }

    {whitespace}     {/*IGNORE*/}
}

[^]   { error(yytext()); return symbol(GameParserSym.ERROR, yytext());}


<<EOF>>         { return symbol(GameParserSym.EOF); }   