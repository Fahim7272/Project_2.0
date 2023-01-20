package com.example.demo1;

import com.sun.jdi.connect.spi.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController {

        @FXML
        private TextField ID;

        @FXML
        private Button login_button;

        @FXML
        private PasswordField password;

        private Connection connect;
        private Statement statement;
        private PreparedStatement preparedStatement;
        private ResultSet resultSet;


        @FXML
        void exit(ActionEvent event) {
                System.exit(0);
        }

        public void login(){
                connect = DB.connectDb();

                String sql;
        }


}

