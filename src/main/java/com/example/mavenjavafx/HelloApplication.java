package com.example.mavenjavafx;

import com.example.mavenjavafx.sockets.Client;
import com.example.mavenjavafx.sockets.CustomFxObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public HelloApplication() {}

    private CustomFxObject getFxObject() {
        Client client = new Client();
        client.establish();
        return client.readFromNetwork();
    }

    @Override
    public void start(Stage stage) throws IOException {
        CustomFxObject obj = getFxObject();
        Label message = new Label(obj.customMessage);
        VBox vbox = new VBox(1f, message);
        Scene scene = new Scene(vbox, obj.width, obj.height);
        stage.setTitle("JavaFx over network!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}