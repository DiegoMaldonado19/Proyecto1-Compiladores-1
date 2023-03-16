package main.java.compiler.model;

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

/* Macros*/
whitespace = [ \t\r\f\v\n]+
newline = [\n]

digit = [0-9]+
decimal = [0-9]+[.][0-9]+
string = /*[a-zA-Z0-9_]*/

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
                       return symbol(sym.HASH, yytext());
                     }
    {up}             { return symbol(sym.UP, yytext()); }
    {down}           { return symbol(sym.DOWN, yytext()); }
    {left}           { return symbol(sym.LEFT, yytext()); }
    {right}          { return symbol(sym.RIGHT, yytext()); }
    {push}           { return symbol(sym.PUSH, yytext()); }
    {floor}          { return symbol(sym.FLOOR, yytext()); }
    {ceil}           { return symbol(sym.CEIL, yytext()); }    
    {lparen}         { return symbol(sym.LPAREN, yytext()); }
    {rparen}         { return symbol(sym.RPAREN, yytext()); }
    {semicolon}      { return symbol(sym.SEMICOLON, yytext()); }
    {digit}          { return symbol(sym.DIGIT, yytext()); }
    {decimal}        { return symbol(sym.DECIMAL, yytext()); }
    {plus}           { return symbol(sym.PLUS, yytext()); }
    {div}            { return symbol(sym.DIV, yytext()); }
    {minus}          { return symbol(sym.MINUS, yytext()); }
    {mult}           { return symbol(sym.MULT, yytext()); }
}

<COMMENT>{
    {hash}           {  yybegin(YYINITIAL);
                        return symbol(sym.HASH, yytext());
                     }

    {string}     { return symbol(sym.STRING, yytext()); }

    {whitespace}     {/*IGNORE*/}
}

[^]   { error(yytext()); return symbol(sym.ERROR, yytext());}


<<EOF>>         { return symbol(sym.EOF); }   