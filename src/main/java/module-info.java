module com.example.mavenjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mavenjavafx to javafx.fxml;
    exports com.example.mavenjavafx;
    exports com.example.mavenjavafx.task1;
    exports com.example.mavenjavafx.task2;
    exports com.example.mavenjavafx.task3;
    opens com.example.mavenjavafx.task3 to javafx.fxml;
}