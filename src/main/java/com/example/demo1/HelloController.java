package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

        @FXML
        private TextField ID;

        @FXML
        private Button login_button;

        @FXML
        private PasswordField password;

        @FXML
        void exit(ActionEvent event) {
                System.exit(0);
        }

}

