package com.example.mavenjavafx.task1;

import com.example.mavenjavafx.CustomFxObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sender {

    private final String filename = "fxObject.ser";

    public Sender() {}

    public void saveFxObjectToFile() {
        CustomFxObject fxObject = new CustomFxObject("JavaFx message from file");
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(fxObject);
            out.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
