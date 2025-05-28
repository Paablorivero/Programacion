module com.decroly.vetapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.decroly.vetapp to javafx.fxml;
    exports com.decroly.vetapp;
}