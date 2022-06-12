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
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private Button goToShopBtn;

    @FXML
    private Label LBL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchScene();
        goBack2();
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

