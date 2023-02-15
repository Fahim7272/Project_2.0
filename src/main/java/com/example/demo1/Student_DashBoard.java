package com.example.demo1;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import com.example.demo1.HelloController.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Student_DashBoard implements Initializable {
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
    public static String[] subject = {"Bangla","English","Math","ICT"};
    public ChoiceBox<String> subjects;


    public ImageView stu_image;
    public ListView<String> notices;
    public Label test_mark;
    public Label mid_mark;
    public Label final_mark;
    public ChoiceBox<String> subject1;
    public Button log_out_st;

    ObservableList<String> items = FXCollections.observableArrayList();

    private int sid;
    public String class_;
    public String section_;





    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    /*public void exit(javafx.scene.input.MouseEvent mouseEvent) {
    }*/
    public void student() throws SQLException {
        Connection connect = DB.connectDb();
        String sql = "SELECT * FROM `student_data` where id = 53";
        Statement statement = connect.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while(res.next()) {
            id.setText(res.getString("id"));
            name.setText(res.getString("first_name")+" "+res.getString("last_name"));
            father.setText(res.getString("fathers_name"));
            mother.setText(res.getString("mothers_name"));
            birth_date.setText(res.getString("birth_date"));
            religion.setText(res.getString("religion"));
            stu_image.setImage(new Image(res.getBinaryStream("image")));
            blood.setText(res.getString("blood_grp"));
            //address.setText(res.getString("present_address"));

            //store data
            sid = res.getInt("id");
            class_ = res.getString("class");
            section_ = res.getString("section");

        }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subjects.setItems(FXCollections.observableArrayList(subject));
        subject1.setItems(FXCollections.observableArrayList(subject));

        try {
            results();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);

        }
        try {
            student();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void check_notice(ActionEvent actionEvent) throws SQLException {
        notices.setItems(null);
        Connection connect = DB.connectDb();

        String sql = "SELECT * FROM `notice` where  class = '"+class_+"'and section = '"+section_+"'and subject = '"+subjects.getValue()+"'";
        Statement statement = connect.createStatement();
        ResultSet res = statement.executeQuery(sql);
        notices.setItems(items);

        while (res.next()){
            String s = res.getString("notice")+res.getString("notice");
            items.add(s);
        }
    }

    public void logOut(javafx.event.ActionEvent event) throws IOException {
        if(event.getSource() == log_out_st){
            log_out_st.getScene().getWindow().hide();
            Parent root = FXMLLoader.load((getClass().getResource("login1.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }
    }



    public void results() throws SQLException {
        Connection connect = DB.connectDb();

        String sql = "SELECT * FROM `result` WHERE id = '"+sid+"'and subjects_ = '"+subject1.getValue()+"'";
        Statement statement = connect.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()){
            test_mark.setText(res.getString("test"));
            mid_mark.setText(res.getString("mid"));
            final_mark.setText(res.getString("final"));
        }
    }


}
