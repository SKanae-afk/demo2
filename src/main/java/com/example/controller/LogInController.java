package com.example.controller;

import com.example.dao.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

        @FXML
        private Button goToSignUpBtn1;

        @FXML
        private Button goToSignUpBtn;

        @FXML
        private Label LBL;

    @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            switchScene2();
            checkLogin();
        }

        private void switchScene11(){
            goToSignUpBtn1.setOnAction(e->{
                checkLogin();
            });
        }
        private void switchScene2(){
            goToSignUpBtn.setOnAction(e->{
                newScene2();
            });
        }


    private void newScene11(){
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

    private void newScene2(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("signUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),700,440);
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
    private TextField tfUser;
    @FXML
    private PasswordField pfPass;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private void checkLogin() {

        if(tfUser.getText().isEmpty() && pfPass.getText().isEmpty() ){
            loginMessageLabel.setText("Please enter a correct username and password");
        }
        else{
            checkDb();

        }
    }

    private Stage stage;
    private Scene scene;

    public void changeSceneToSignUp(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("signUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void checkDb() {
        UserService userService =new UserService();
        try{
            if((userService.findUser(tfUser.getText(), pfPass.getText()).getUsername() +
                    userService.findUser(tfUser.getText(), pfPass.getText()).getPassword())
                    .equals(tfUser.getText() + pfPass.getText())) {
                System.out.println("Success");
                newScene11();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}