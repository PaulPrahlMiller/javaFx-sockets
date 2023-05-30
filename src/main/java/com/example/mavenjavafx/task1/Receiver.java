package com.example.mavenjavafx.task1;

import com.example.mavenjavafx.CustomFxObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver {
    String filename = "fxObject.ser";

    public CustomFxObject readObjectFromFile() {
        CustomFxObject fxObject = null;
        FileInputStream fis;
        ObjectInputStream in;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            fxObject = (CustomFxObject) in.readObject();
            in.close();
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return fxObject;
    }


}
