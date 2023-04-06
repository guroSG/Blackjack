module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.designanalys.main to javafx.fxml;
    exports com.designanalys.main;

}