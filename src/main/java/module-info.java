module com.example.mavenjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mavenjavafx to javafx.fxml;
    exports com.example.mavenjavafx;
}