package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;

import java.security.Key;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField inputText1, inputText2 ;
    @FXML


boolean flag=false;


    public void initialize()
    {
        inputText2.setOnKeyPressed(event -> {

            if (event.getCode() != KeyCode.TAB && flag){
                inputText2.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                welcomeText.setText("");

                flag=false;
        }

        });
        inputText2.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if(inputText2.getText().matches("^(.+)@(.+)$*"))
                {
                    inputText2.setEditable(false);
                    inputText2.setBorder(null);
                }
                else
                {

                    inputText2.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    inputText2.setVisible(true);
                    inputText2.requestFocus();
                    welcomeText.setText(inputText2.getText()+ " is not valid email");
                    flag=true;
                }

            }
        });
        inputText1.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if(inputText1.getText().matches("[a-zA-Z]{2,4}"))
                {
                    inputText1.setEditable(false);
                    inputText1.setBorder(null);
                }
                else
                {
                    inputText1.setText("Invalid Email");
                    inputText1.setVisible(true);

                }
            }
        });


    }




    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}