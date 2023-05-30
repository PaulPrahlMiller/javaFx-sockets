package com.example.mavenjavafx.task1;

import com.example.mavenjavafx.CustomFxObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Task1App extends Application {

    public Task1App() {}
    @Override
    public void start(Stage stage) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        sender.saveFxObjectToFile();
        CustomFxObject fxObject = receiver.readObjectFromFile();

        VBox vbox = fxObject.createFxObject();
        Scene scene = new Scene(vbox, fxObject.width, fxObject.height);
        stage.setTitle("JavaFx - Task 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
