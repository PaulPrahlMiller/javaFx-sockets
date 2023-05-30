package com.example.mavenjavafx.task3;

import com.example.mavenjavafx.CustomFxObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Integer PORT = 8080;
    public Server() {}
    public void establish() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080, 1, InetAddress.getLocalHost());
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        }catch (IOException e) {
            System.out.printf("An error occurred when opening the socket on port %d.", PORT);
            System.exit(-1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        }catch (IOException e) {
            System.out.printf("Accept failed on port %d.", PORT);
            System.exit(-1);
        }

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        }
        catch (IOException ioe) {
            System.out.println("Error occurred when creating output stream.");
            System.exit(-1);
        }

        try {
            out.writeObject(new CustomFxObject("JavaFX object sent over local network"));
        }
        catch (IOException ioe) {
            System.out.println("Error occurred when writing object to the stream");
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
