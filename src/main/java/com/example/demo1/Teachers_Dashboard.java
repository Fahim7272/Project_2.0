package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Teachers_Dashboard {

    @FXML
    private Button Help_chat;

    @FXML
    private ChoiceBox<?> Upd_res_class;

    @FXML
    private Button Upd_res_proceed;

    @FXML
    private ChoiceBox<?> Upd_res_section;

    @FXML
    private ChoiceBox<?> announcement_class;

    @FXML
    private Button announcement_proceed;

    @FXML
    private ChoiceBox<?> announcement_section;

    @FXML
    private Button exit_Teacher;

    @FXML
    private Button log_out_teachers;

    @FXML
    private Button post_announce;

    @FXML
    private Button result_update;

    @FXML
    private AnchorPane teachers_home;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    public void logOut(javafx.event.ActionEvent event) throws IOException {
        if(event.getSource() == log_out_teachers){
            log_out_teachers.getScene().getWindow().hide();
            Parent root = FXMLLoader.load((getClass().getResource("login1.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }
    }

}
