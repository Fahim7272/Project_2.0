package com.example.demo1;

//import com.sun.jdi.connect.spi.Connection;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.example.demo1.Student_DashBoard.*;

import java.util.ResourceBundle;

public class HelloController {

        @FXML
        private TextField ID;

        @FXML
        private TextField ID1;

        @FXML
        private TextField ID11;

        @FXML
        private Hyperlink Teachers_login_from_std;

        @FXML
        private Hyperlink admin_login;

        @FXML
        private Hyperlink admin_login_from_teacher;

        @FXML
        private Button exit;

        @FXML
        private Button exit1;

        @FXML
        private Button exit11;

        @FXML
        private BorderPane login_admin;

        @FXML
        private BorderPane login_admin1;

        @FXML
        private Button login_button;

        @FXML
        private Button login_button1;

        @FXML
        private Button login_button11;

        @FXML
        private BorderPane login_student;

        @FXML
        private PasswordField password;

        @FXML
        private PasswordField password1;

        @FXML
        private PasswordField password11;

        @FXML
        private Hyperlink student_login2;

        @FXML
        private Hyperlink student_login_from_teacher;

        @FXML
        private Hyperlink teachers_login;

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
        public double x = 0;
        public double y = 0;
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

                                root.setOnMousePressed((MouseEvent event)->{
                                        x = event.getSceneX();
                                        y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) ->{
                                        stage.setX(event.getScreenX() - x);
                                        stage.setY(event.getScreenY() - y);
                                });

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
                        System.out.println(ex);
                }
        }



        public void login_admin(){

                connect = DB.connectDb();
                String sql ="SELECT * FROM `admin_login` WHERE admin_ID = ? and admin_pass = ?";

                try{
                        pre = connect.prepareStatement(sql);
                        pre.setString(1, ID1.getText());
                        pre.setString(2, password1.getText());

                        resultSet = pre.executeQuery();

                        if(resultSet.next()){

                                login_button1.getScene().getWindow().hide();
                                Parent root = FXMLLoader.load(getClass().getResource("Admin_DashBoard.fxml"));

                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                root.setOnMousePressed((MouseEvent event)->{
                                        x = event.getSceneX();
                                        y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) ->{
                                        stage.setX(event.getScreenX() - x);
                                        stage.setY(event.getScreenY() - y);
                                });
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
                        System.out.println(ex);
                }
        }


        public void Teachers_login_(){

                connect = DB.connectDb();
                String sql ="SELECT * FROM `teachers login` WHERE teachers_ID = ? and teachers_pass = ?";

                try{
                        pre = connect.prepareStatement(sql);
                        pre.setString(1, ID11.getText());
                        pre.setString(2, password11.getText());
                        resultSet = pre.executeQuery();

                        if(resultSet.next()){

                                login_button11.getScene().getWindow().hide();

                                Parent root = FXMLLoader.load(getClass().getResource("Teachers_DashBoard.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                root.setOnMousePressed((MouseEvent event)->{
                                        x = event.getSceneX();
                                        y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) ->{
                                        stage.setX(event.getScreenX() - x);
                                        stage.setY(event.getScreenY() - y);
                                });
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
                        System.out.println(ex);
                }
        }


        public void changeScene(ActionEvent event){

                if(event.getSource() == student_login2 || event.getSource() == student_login_from_teacher){
                        login_student.setVisible(true);
                        login_admin.setVisible(false);
                        login_admin1.setVisible(false);
                        ID1.setText("");
                        password1.setText("");
                }

                else if(event.getSource() == admin_login || event.getSource() == admin_login_from_teacher){
                        login_admin.setVisible(true);
                        login_admin1.setVisible(false);
                        login_student.setVisible(false);

                        ID.setText("");
                        password.setText("");
                } else if (event.getSource() == teachers_login || event.getSource() == Teachers_login_from_std) {
                        login_admin.setVisible(false);
                        login_admin1.setVisible(true);
                        login_student.setVisible(false);

                        ID.setText("");
                        password.setText("");
                }
        }




}

