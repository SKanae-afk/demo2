module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires org.junit.jupiter.api;

    opens  com.example.controller to javafx.fxml;
    opens com.example.dao;
    opens com.example.entity;

    exports com.example.entity;
    exports com.example.dao;
    exports com.example.controller;
    exports com.example.regex_enum;
    opens com.example.regex_enum to javafx.fxml;


}