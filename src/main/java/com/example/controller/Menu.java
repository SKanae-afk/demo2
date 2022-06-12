package com.example.controller;

import com.example.dao.UserService;
import com.example.entity.UsersEntity;
import javafx.event.ActionEvent;
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

public class Menu implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private Label LBL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        goBack2();
    }

    public void goBack2(){
        backBtn.setOnAction(e->{
            newScene2();
        });
    }

    private void newScene2(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),900,535);
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
