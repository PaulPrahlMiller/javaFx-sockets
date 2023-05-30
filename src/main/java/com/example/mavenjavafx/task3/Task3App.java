package com.example.mavenjavafx.task3;

import com.example.mavenjavafx.CustomFxObject;
import com.example.mavenjavafx.task2.LocalNetworkClient;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Task3App extends Application {

    public Task3App() {}

    private CustomFxObject getFxObject() {
        Client client = new Client();
        client.establish();
        return client.readFromNetwork();
    }

    @Override
    public void start(Stage stage) {
        CustomFxObject fxObject = getFxObject();
        VBox vbox = fxObject.createFxObject();
        Scene scene = new Scene(vbox, fxObject.getWidth(), fxObject.getHeight());
        stage.setTitle("JavaFx over network!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}