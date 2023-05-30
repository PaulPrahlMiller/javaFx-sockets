package com.example.mavenjavafx.task2;

import com.example.mavenjavafx.CustomFxObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LocalNetworkClient {

    private final Integer PORT = 8080;
    Socket socket = null;
    ObjectInputStream in = null;
    CustomFxObject inputObject = null;

    public LocalNetworkClient() {}

    public void establish() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (UnknownHostException e) {
            System.err.println("Could not connect to host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("An error occurred when creating the socket.");
            System.exit(1);
        }
    }

    public CustomFxObject readFromNetwork() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return (CustomFxObject) in.readObject();
        } catch (IOException ioe) {
            System.out.println("Error occurred when reading the stream");
            System.exit(-1);
        } catch (ClassNotFoundException e) {
            System.out.println("No CustomFxObject could be found.");
            System.exit(-1);
        }
        return null;
    }

    public static void main(String[] args) {
        LocalNetworkClient client = new LocalNetworkClient();
        client.establish();
    }
}
