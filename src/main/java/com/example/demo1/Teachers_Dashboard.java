package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;

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

}
