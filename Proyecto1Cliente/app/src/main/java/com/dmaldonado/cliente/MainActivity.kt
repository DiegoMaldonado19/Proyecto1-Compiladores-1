package com.dmaldonado.cliente

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.dmaldonado.cliente.socket.message.*
import com.dmaldonado.cliente.socket.task.*
import java.net.Inet4Address
import java.net.NetworkInterface
import android.net.wifi.WifiManager
import android.content.Context
import android.text.format.Formatter
import android.widget.TextView

class MainActivity : AppCompatActivity(), AsyncResponse {
    // TODO: make the ip dynamic
    val ipServer: String = "192.168.56.1"
    val portServer: Int = 9090

    var textView: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editor: EditText = findViewById(R.id.inputText)
        val sentButton: Button = findViewById(R.id.sentToServerButton)

        sentButton.setOnClickListener(View.OnClickListener {
            val text = editor.text.toString()
            this.sendMessage(text)
        })


    }

    private fun sendMessage(message: String) {
        val simpleMessage = Message(message)
        val task = MyTask(ipServer, portServer, simpleMessage)
        task.delegate = this
        task.execute()
    }

    override fun processResponse(output: String?) {
        if (output != null) {
            textView?.text = output
        } else {
            textView?.text = "Something went wrong"
        }
    }

    private fun getIp(): String {
        NetworkInterface.getNetworkInterfaces().toList().map {
            it.inetAddresses.toList().find {
                !it.isLoopbackAddress && it is Inet4Address
            }?.let {
                return it.hostAddress
            }
        }

        return ""
    }

    private fun getWifiIp(): String {
        val context = this.applicationContext;
        val wifiManager: WifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val ip: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        return ip;
    }
}