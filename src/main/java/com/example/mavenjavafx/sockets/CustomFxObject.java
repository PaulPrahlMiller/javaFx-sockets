package com.example.mavenjavafx.sockets;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.Serializable;

public class CustomFxObject implements Serializable {
    public String customMessage = "JavaFX object sent over network";
    public Double width = 320d;
    public Double height = 320d;
    public CustomFxObject() {}

}
