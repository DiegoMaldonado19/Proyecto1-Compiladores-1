package com.dmaldonado.cliente.socket.task

interface AsyncResponse {
    fun processResponse(output: String?)
}
