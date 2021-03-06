package com.example.controller;

import com.example.regex_enum.Bagels;
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

public class Menu implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Label LBL;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        goBack2();
        bt2(); bt3(); bt4(); bt5();
    }

    public void bt2(){
        btn2.setOnAction(e->{
            btn2app();
        });
    }

    public void bt3(){
        btn3.setOnAction(e->{
            btn3app();
        });
    }

    public void bt4(){
        btn4.setOnAction(e->{
            btn4app();
        });
    }
    public void bt5(){
        btn5.setOnAction(e->{
            btn5app();
        });
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

    private void btn2app(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("thxForOrder!.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,176);
            Stage stage = new Stage();
            stage.setTitle("Spotify - donuts");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void btn3app(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("thxForOrder!.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,176);
            Stage stage = new Stage();
            stage.setTitle("Spotify - donuts");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void btn4app(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("thxForOrder!.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,176);
            Stage stage = new Stage();
            stage.setTitle("Spotify - donuts");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void btn5app(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("thxForOrder!.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600,176);
            Stage stage = new Stage();
            stage.setTitle("Spotify - donuts");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
