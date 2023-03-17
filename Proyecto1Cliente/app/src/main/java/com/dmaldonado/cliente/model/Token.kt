package com.dmaldonado.cliente.model

class Token (private var lexeme: String, private var line: Int, private var column: Int){

    fun setLexeme(lexeme: String){
        this.lexeme = lexeme
    }

    fun getLexeme(): String{
        return lexeme
    }

    fun setLine(line: Int){
        this.line = line
    }

    fun getLine(): Int{
        return line
    }

    fun setColumn(column: Int){
        this.column = column
    }

    fun getColumn(): Int{
        return column
    }

    override fun toString(): String {
        return "Token(lexeme='$lexeme', row=$line, column=$column)"
    }
}