/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmaldonado.server.model;

/**
 *
 * @author ACER
 */
public class Token {
    private String lexeme;
    private int line;
    private int column;

    public Token(String lexeme, int line, int column) {
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Token{" + "lexeme=" + lexeme + ", line=" + line + ", column=" + column + '}';
    }
}
