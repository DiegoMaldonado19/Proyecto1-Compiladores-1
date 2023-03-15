package com.dmaldonado.cliente.model

class Token (private var lexeme: String, private var row: Int, private var column: Int){

    fun setLexeme(lexeme: String){
        this.lexeme = lexeme
    }

    fun getLexeme(): String{
        return lexeme
    }

    fun setRow(row: Int){
        this.row = row
    }

    fun getRow(): Int{
        return row
    }

    fun setColumn(column: Int){
        this.column = column
    }

    fun getColumn(): Int{
        return column
    }

    override fun toString(): String {
        return "Token(lexeme='$lexeme', row=$row, column=$column)"
    }
}