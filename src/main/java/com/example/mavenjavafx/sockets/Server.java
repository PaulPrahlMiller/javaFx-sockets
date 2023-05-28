package com.example.mavenjavafx.sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {}
    public void establish() {
        ServerSocket serverSocket = null;
        try {
            serverSocket= new ServerSocket(8080, 2, InetAddress.getLocalHost());
        }catch (IOException e) {
            System.out.println("Could not listen on port: 8000");
            System.exit(-1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        }catch (IOException e) {
            System.out.println("Accept failed: 8000");
            System.exit(-1);
        }
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        }
        catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }

        try {
            out.writeObject(new CustomFxObject());
        }
        catch (IOException ioe) {
            System.out.println("Failed in reading, writing");
            System.exit(-1);
        }

        try {
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.establish();
    }

}
