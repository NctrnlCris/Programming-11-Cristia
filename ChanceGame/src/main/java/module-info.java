module com.example.chancegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chancegame to javafx.fxml;
    exports com.example.chancegame;
}