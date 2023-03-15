package com.dmaldonado.cliente.model

class Box (private var color: String, private var posX: Int, private var posY: Int, private var type: Type) {

    fun setColor(color: String){
        this.color = color
    }

    fun getColor(): String{
        return color
    }

    fun setPosX(posX: Int){
        this.posX = posX
    }

    fun getPosX(): Int{
        return posX
    }

    fun setPosY(posY: Int){
        this.posY = posY
    }

    fun getPosY(): Int{
        return posY
    }

    fun setType(type: Type){
        this.type = type
    }

    fun getType(): Type{
        return type
    }

    override fun toString(): String {
        return "Box(color='$color', posX=$posX, posY=$posY, type=$type)"
    }
}