module com.bun.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
    requires jbcrypt;


    opens com.bun.demo1 to javafx.fxml;
    exports com.bun.demo1;
}