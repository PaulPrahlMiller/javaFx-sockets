package com.example.mavenjavafx.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    Socket socket = null;
    ObjectInputStream in = null;
    CustomFxObject inputObject = null;

    public Client() {
    }

    public void establish() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8080);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O");
            System.exit(1);
        }
    }

    public CustomFxObject readFromNetwork() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return (CustomFxObject) in.readObject();
        } catch (IOException ioe) {
            System.out.println("Failed");
            System.exit(-1);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            System.exit(-1);
        }
        return null;
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.establish();
    }
}
