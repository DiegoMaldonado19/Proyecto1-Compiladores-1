/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package dmaldonado.server;

import dmaldonado.server.view.*;
import dmaldonado.server.socket.*;

/**
 *
 * @author ACER
 */
public class Proyecto1Servidor{

    public static void main(String[] args) {
        ServerFrame view = new ServerFrame();
        Listener listener = new Listener(9090, view);
        listener.start();
    }
}
