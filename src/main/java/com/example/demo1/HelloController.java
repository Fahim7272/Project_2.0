package com.example.demo1;

//import com.sun.jdi.connect.spi.Connection;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

        @FXML
        private TextField ID;

        @FXML
        private Button login_button;

        @FXML
        private PasswordField password;

        private Connection connect;
        private Statement statement;
        private PreparedStatement pre;
        private ResultSet resultSet;


        @FXML
        void exit(ActionEvent event) {
                System.exit(0);
        }

        public void login(){

                connect = DB.connectDb();
                String sql =" ";

                try{
                        pre = connect.prepareStatement(sql);
                        pre.setString(1, ID.getText());
                        pre.setString(2, password.getText());

                        resultSet = pre.executeQuery();

                        if(resultSet.next()){

                                Parent root = FXMLLoader.load(getClass().getResource("login1.fxml"));

                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.DECORATED.UNDECORATED);
                                //stage.setTitle("Hello!");
                                stage.setScene(scene);
                                stage.show();

                        }
                        else{
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Wrong Username or Password");
                                alert.showAndWait();
                        }

                }catch(Exception ex){

                }
        }


}

