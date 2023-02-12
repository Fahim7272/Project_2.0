package com.example.demo1;


import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class Student_DashBoard {
    public AnchorPane home;
    public Label id;
    public Label name;
    public Label sclass;
    public Label section;
    public Label father;
    public Label mother;
    public Label blood;
    public Label religion;
    public Label birth_date;
    public Label address;
    public AnchorPane result;
    public AnchorPane medical;
    public AnchorPane classrooms;
    public AnchorPane payments;
    public AnchorPane help;
    public String[] subject = {"Bangla","English","Math","ICT"};
    public ChoiceBox<String> subjects;


    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }

    public void exit(javafx.scene.input.MouseEvent mouseEvent) {
    }

    public void home(ActionEvent actionEvent) {
        home.setVisible(true);
        payments.setVisible(false);
        medical.setVisible(false);
        classrooms.setVisible(false);
        result.setVisible(false);
    }

    public void payment(ActionEvent actionEvent) {
        home.setVisible(false);
        payments.setVisible(true);
        medical.setVisible(false);
        classrooms.setVisible(false);
        result.setVisible(false);
    }

    public void medi(ActionEvent actionEvent) {
        home.setVisible(false);
        payments.setVisible(false);
        medical.setVisible(true);
        classrooms.setVisible(false);
        result.setVisible(false);
    }

    public void classroom(ActionEvent actionEvent) {
        home.setVisible(false);
        payments.setVisible(false);
        medical.setVisible(false);
        classrooms.setVisible(true);
        result.setVisible(false);

        subjects.setItems(FXCollections.observableArrayList(subject));
    }

    public void result(ActionEvent actionEvent) {
        home.setVisible(false);
        payments.setVisible(false);
        medical.setVisible(false);
        classrooms.setVisible(false);
        result.setVisible(true);
    }
}
