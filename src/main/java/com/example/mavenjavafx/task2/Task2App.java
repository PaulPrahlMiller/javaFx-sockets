package com.example.mavenjavafx.task2;

import com.example.mavenjavafx.CustomFxObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Task2App extends Application {

    public Task2App() {}

    private CustomFxObject getFxObject() {
        LocalNetworkClient client = new LocalNetworkClient();
        client.establish();
        return client.readFromNetwork();
    }

    @Override
    public void start(Stage stage) {
        CustomFxObject obj = getFxObject();
        VBox vbox = obj.createFxObject();
        Scene scene = new Scene(vbox, obj.getWidth(), obj.getHeight());
        stage.setTitle("JavaFx over network!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}