module com.decroly.pruebaexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.decroly.pruebaexamen to javafx.fxml;
    exports com.decroly.pruebaexamen;
}