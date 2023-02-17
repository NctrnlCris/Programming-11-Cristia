module com.example.cp11project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cp11project to javafx.fxml;
    exports com.example.cp11project;
}