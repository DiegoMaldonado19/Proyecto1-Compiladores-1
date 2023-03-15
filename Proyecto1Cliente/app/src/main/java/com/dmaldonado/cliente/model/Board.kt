package com.dmaldonado.cliente.model

class Board (private var name: String, private var rows: Int, private var columns: Int) {
    /*
    var matrix : Array<Array<Box>> = Array(rows){ Box() } }

     */

    fun setName(name: String){
        this.name = name
    }

    fun getName(): String{
        return name
    }

    fun setRows(rows: Int){
        this.rows = rows
    }

    fun getRows(): Int{
        return rows
    }

    fun setColumns(columns: Int){
        this.columns = columns
    }

    fun getColumns(): Int {
        return columns
    }
}