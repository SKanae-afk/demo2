package com.example.controller;

import com.example.dao.UserService;
import com.example.entity.UsersEntity;
import com.example.regex_enum.RegeX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private Button goToMainMenuBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label LBL;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfUser;

    @FXML
    private PasswordField pfPass;

    @FXML
    private PasswordField pfConfirm;

    @FXML
    private Label idWrong;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        goBack();
    }

    private void switchScene1(){
        goToMainMenuBtn.setOnAction(e->{
            newScene1();
        });
    }

    public void goBack(){
        backBtn.setOnAction(e->{
            newScene2();
        });
    }

    private void newScene1(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("mainMenu.fxml"));
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

    public void userSignup (ActionEvent event) {
        checkSignUp();
    }

    private void checkSignUp() {
        String username = tfUser.getText();
        String password = String.valueOf(pfPass.getText());
        String confirmPassword = String.valueOf(pfConfirm.getText());

        if (tfUser.getText().isEmpty() || tfEmail.getText().isEmpty() || pfPass.getText().isEmpty() || pfConfirm.getText().isEmpty()) {
            idWrong.setText("One or more of the fields is empty!");
        }
        if (!password.equals(confirmPassword)) {
            idWrong.setText("Password doesn't match!");
        }
        if(checkUsernameExistsInDb(tfUser.getText())) {
            idWrong.setText("Username already exists");
        }
        if(!RegeX.checkbox(tfUser.getText())){
            idWrong.setText("Invalid username");
        }
        else {
            idWrong.setText("Congratulations! Account successfully created. You may log in now.");
            createUser();
        }
    }

    private void createUser() {
        UserService userService = new UserService();
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setEmail(tfEmail.getText());
        usersEntity.setUsername(tfUser.getText());
        usersEntity.setPassword(pfPass.getText());
        userService.addUser(usersEntity);
    }
    private boolean checkUsernameExistsInDb(String username) {
        UserService userService = new UserService();
        for(UsersEntity usersEntity : userService.getAllUsers()) {
            if(usersEntity.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}