module com.example.demoinfinity {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demoinfinity to javafx.fxml;
    exports com.example.demoinfinity;
}