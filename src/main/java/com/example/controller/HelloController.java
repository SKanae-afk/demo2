package com.example.controller;

import com.example.entity.ArtistEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button helloBtn;

    @FXML
    private Label welcomeText1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test();
    }

    private void test() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setNume("Velea");
        artistEntity.setPrenume("Alex");

       helloBtn.setOnAction(e-> {
           try {
               entityManager.getTransaction().begin();
               entityManager.persist(artistEntity);
               entityManager.getTransaction().commit();
           } catch(RuntimeException exception) {
               entityManager.getTransaction().rollback();
           }
           finally {
               entityManager.close();
           }

       });

    }


}