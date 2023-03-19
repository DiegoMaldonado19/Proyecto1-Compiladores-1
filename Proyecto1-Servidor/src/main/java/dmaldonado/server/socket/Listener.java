/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmaldonado.server.socket;

import com.dmaldonado.cliente.socket.message.Message;
import java.net.*;
import java.io.*;
import java.time.*;
import dmaldonado.server.view.*;
import dmaldonado.server.compiler.*;
import java.util.*;
import dmaldonado.server.model.*;

/**
 *
 * @author ACER
 */
public class Listener extends Thread{
    private int portServer;
    private ServerFrame view;
    private ArrayList<Token> tokenList;
    private ArrayList<String> errorList;

    public Listener(int portServer, ServerFrame view) {
        this.portServer = portServer;
        this.view = view;
    }

    @Override
    public void run() {
        try(ServerSocket server = new ServerSocket(this.portServer)) {
            while (true) {
                String hostAddress = InetAddress.getLocalHost().getHostAddress();
                this.view.messageTextArea.append("Listening on: "+ hostAddress+" port: "+this.portServer+"\n");
                Socket socket = server.accept();

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Message request = (Message) inputStream.readObject();

                /* read message */
                StringReader input = new StringReader(request.getMessage());
                ServerLexer lexer = new ServerLexer(input);
                ServerParser parser = new ServerParser(lexer);
                
                try{
                    parser.parse();
                    this.tokenList = parser.getTokenList();
                    this.errorList = parser.getErrorList();
                    
                } catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Error encontrado en parseo");
                }

                this.view.messageTextArea.append("Recibiendo de: "+hostAddress+"\n");
                this.view.messageTextArea.append(request+"\n");


                // TODO: write your code here
                // TODO: write another message
                Message response = new Message("Hello from server: " + LocalDateTime.now());
                System.out.println("\nSending message:");
                System.out.println(response);

                outputStream.writeObject(response);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public int getPortServer() {
        return portServer;
    }

    public void setPortServer(int portServer) {
        this.portServer = portServer;
    }
}
