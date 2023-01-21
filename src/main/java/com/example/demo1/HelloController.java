package com.example.demo1;

//import com.sun.jdi.connect.spi.Connection;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController {

        @FXML
        private TextField ID;

        @FXML
        private TextField ID1;

        @FXML
        private Hyperlink admin_login;

        @FXML
        private Button exit;

        @FXML
        private Button exit1;

        @FXML
        private BorderPane login_admin;

        @FXML
        private Button login_button;

        @FXML
        private Button login_button1;

        @FXML
        private BorderPane login_student;

        @FXML
        private PasswordField password;

        @FXML
        private PasswordField password1;

        @FXML
        private Hyperlink student_login;

        private Connection connect;
        private Statement statement;
        private PreparedStatement pre;
        private ResultSet resultSet;


        @FXML
        void exit(ActionEvent event) {
                System.exit(0);
        }

        @FXML
        void exit1(ActionEvent event) {
                System.exit(0);
        }

        public void login(){

                connect = DB.connectDb();
                String sql ="SELECT * FROM `account` WHERE userID = ? and password = ?";

                try{
                        pre = connect.prepareStatement(sql);
                        pre.setString(1, ID.getText());
                        pre.setString(2, password.getText());

                        resultSet = pre.executeQuery();

                        if(resultSet.next()){

                                login_button.getScene().getWindow().hide();
                                Parent root = FXMLLoader.load(getClass().getResource("Student_DashBoard.fxml"));

                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.DECORATED.UNDECORATED);
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


        public void changeScene(ActionEvent event){

                if(event.getSource() == student_login){
                        login_student.setVisible(true);
                        login_admin.setVisible(false);

                        ID1.setText("");
                        password1.setText("");
                }

                else if(event.getSource() == admin_login){
                        login_admin.setVisible(true);
                        login_student.setVisible(false);

                        ID.setText("");
                        password.setText("");
                }
        }




}

