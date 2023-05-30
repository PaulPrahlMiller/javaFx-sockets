package com.example.mavenjavafx;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.Serializable;

public class CustomFxObject implements Serializable {

    private String message;
    public String title = "LAB 1";
    public Double width = 320d;
    public Double height = 320d;

    public CustomFxObject(String message) {
        this.message = message;
    }


    public CustomFxObject() {}

    public VBox createFxObject() {
        Label fxTitle = new Label(title);
        Label fxMessage = new Label(message);
        return new VBox(fxTitle, fxMessage);
    }

}
