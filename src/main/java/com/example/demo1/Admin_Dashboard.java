package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Admin_Dashboard {

    @FXML
    private Button Classrooms;

    @FXML
    private Button Contact_info_insert;

    @FXML
    private Button General_info_insert;

    @FXML
    private Button Post_announce;

    @FXML
    private Button help_chat;

    @FXML
    private Button home;

    @FXML
    private AnchorPane home_pane;

    @FXML
    private AnchorPane General_info_pane;

    @FXML
    private Button log_out;

    @FXML
    private Button new_student_data;

    @FXML
    private AnchorPane new_student_pane;

    @FXML
    private AnchorPane announce_pane;

    @FXML
    private Button result_update;

    @FXML
    private Button post_announce_btn;

    @FXML
    private TextField post_writer;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }


    public void changeScene(ActionEvent event){
        if(event.getSource() == home){
            home_pane.setVisible(true);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            announce_pane.setVisible(false);
        }
        else if(event.getSource() == new_student_data){
            new_student_pane.setVisible(true);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
            announce_pane.setVisible(false);
        }
        else if(event.getSource() == Post_announce){
            announce_pane.setVisible(true);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
        }

    }

    public void logOut(ActionEvent event) throws IOException {
        if(event.getSource() == log_out){
            log_out.getScene().getWindow().hide();
            Parent root = FXMLLoader.load((getClass().getResource("login1.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }
    }

}
