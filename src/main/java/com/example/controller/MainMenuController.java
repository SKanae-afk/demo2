package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MainMenuController implements Initializable {

    @FXML
    private Button goToShopBtn;

    @FXML
    private Label LBL;

    @FXML
    private Label priceBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchScene();
        goBack2();
        generatePrice();
        createButton();
    }

    private void createButton(){
        priceBtn.setText(generatePrice());
    }

    private String generatePrice() {
        HashMap<Integer, String> priceMap = new HashMap<>();
        priceMap.put(2, "PLAIN");
        priceMap.put(3, "SEEDS");
        priceMap.put(4, "CHEESE");
        priceMap.put(5, "YOGURT");

        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        Collections.sort(lista);
        lista.forEach(System.out::println);
        return priceMap.get(lista.get(lista.size()-1));

    }

    private void switchScene(){
        goToShopBtn.setOnAction(e->{
            newScene();
        });
    }

    private void newScene(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),1005,625);
            Stage stage = new Stage();
            stage.setTitle("Spotify - donuts");
            stage.setScene(scene);
            stage.show();

            //get the current Scene and close the current scene
           Stage currentStage;
           currentStage = (Stage) LBL.getScene().getWindow();
           currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button backBtn;

    public void goBack2(){
        backBtn.setOnAction(e->{
            newScene2();
        });
    }

    private void newScene2(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),924,600);
            Stage stage = new Stage();
            stage.setTitle("Spotify - donuts");
            stage.setScene(scene);
            stage.show();

            //get the current Scene and close the current scene
            Stage currentStage;
            currentStage = (Stage) LBL.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

