/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmaldonado.server.socket;

import java.net.*;
import java.io.*;
import java.time.*;

/**
 *
 * @author ACER
 */
public class Listener extends Thread{
    private int portServer;

    public Listener(int portServer) {
        this.portServer = portServer;
    }

    @Override
    public void run() {
        try(ServerSocket server = new ServerSocket(this.portServer)) {
            while (true) {
                String hostAddress = InetAddress.getLocalHost().getHostAddress();
                System.out.printf("Listening on %s:%d\n", hostAddress, this.portServer);
                Socket socket = server.accept();

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Message request = (Message) inputStream.readObject();

                // TODO: read message
                System.out.println("Message received");
                System.out.println(request);


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
