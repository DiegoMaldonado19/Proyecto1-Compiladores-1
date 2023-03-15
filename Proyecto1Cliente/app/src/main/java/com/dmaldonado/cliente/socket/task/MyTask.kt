package com.dmaldonado.cliente.socket.task
import android.os.AsyncTask
import java.io.*
import java.net.*
import com.dmaldonado.cliente.socket.message.Message

class MyTask (val ip: String, val port: Int, val message: Message) : AsyncTask<Void, Void, String>(){
    var delegate: AsyncResponse? = null

    override fun doInBackground(vararg p0: Void?): String {
        val socket = Socket(ip, port)
        val outputStream = ObjectOutputStream(socket.getOutputStream())
        val inputStream = ObjectInputStream(socket.getInputStream())

        // sending message
        outputStream.writeObject(message)

        // receiving message
        val response: Message = inputStream.readObject() as Message;
        // showing message
        return response.toString()
    }

    override fun onPostExecute(result: String?) {
        delegate?.processResponse(result)
    }
}