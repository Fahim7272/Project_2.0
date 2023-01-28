package com.example.demo1;

import com.mysql.jdbc.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Admin_Dashboard {

    @FXML
    private Button Classrooms;

    @FXML
    private Button Contact_info_insert;

    @FXML
    private Button General_info_insert;

    @FXML
    private AnchorPane General_info_pane;

    @FXML
    private Button Next_page_result;

    @FXML
    private Button Post_announce;

    @FXML
    private AnchorPane announce_pane;

    @FXML
    private Button back_to_new_info;

    @FXML
    private TextField birth_date_in;

    @FXML
    private TextField blood_grp_in;

    @FXML
    private TextField class_in;

    @FXML
    private AnchorPane contact_info_pane;

    @FXML
    private TextField fathers_name;

    @FXML
    private TextField first_name;

    @FXML
    private TextField gender_in;

    @FXML
    private Button home;

    @FXML
    private AnchorPane home_pane;

    @FXML
    private Button jump_to_contact;

    @FXML
    private TextField last_name;

    @FXML
    private Button log_out;

    @FXML
    private TextField mothers_name;

    @FXML
    private Button new_student_data;

    @FXML
    private AnchorPane new_student_pane;

    @FXML
    private Button post_announce_btn;

    @FXML
    private TextField post_writer;

    @FXML
    private TextField religion_in;

    @FXML
    private Button result_update;

    @FXML
    private AnchorPane result_update_pane;

    @FXML
    private AnchorPane result_update_pane1;

    @FXML
    private AnchorPane result_update_pane2;

    @FXML
    private Button save_new_data;

    @FXML
    private TextField section_in;

    @FXML
    private TextField std_ID_input;

    @FXML
    private Button update_btn;


    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }


    private Connection connect;
    private Statement statement;
    private PreparedStatement prep;
    private ResultSet res;

    public void changeScene(ActionEvent event){
        if(event.getSource() == home){
            home_pane.setVisible(true);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            result_update_pane.setVisible(false);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(false);
            contact_info_pane.setVisible(false);
        }
        else if(event.getSource() == new_student_data){
            new_student_pane.setVisible(true);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
            announce_pane.setVisible(false);
            result_update_pane.setVisible(false);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(false);
            contact_info_pane.setVisible(false);
        }
        else if(event.getSource() == Post_announce){
            announce_pane.setVisible(true);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            result_update_pane.setVisible(false);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(false);
            contact_info_pane.setVisible(false);
        }
        else if(event.getSource() == result_update){
            result_update_pane.setVisible(true);
            result_update_pane1.setVisible(true);
            result_update_pane2.setVisible(false);
            announce_pane.setVisible(false);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            contact_info_pane.setVisible(false);
        }
        else if(event.getSource() == Next_page_result){
            result_update_pane.setVisible(true);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(true);
            announce_pane.setVisible(false);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            contact_info_pane.setVisible(false);
        }
        else if(event.getSource() == back_to_new_info || event.getSource() == General_info_insert){
            new_student_pane.setVisible(true);
            contact_info_pane.setVisible(false);
            result_update_pane.setVisible(false);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
        }
        else if(event.getSource() == jump_to_contact || event.getSource() == Contact_info_insert){
            contact_info_pane.setVisible(true);
            new_student_pane.setVisible(false);
            result_update_pane.setVisible(false);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
        }
        else if(event.getSource() == save_new_data){
            new_student_pane.setVisible(true);
            contact_info_pane.setVisible(false);
            result_update_pane.setVisible(false);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
        }
        else if(event.getSource() == result_update){
            result_update_pane.setVisible(true);
            result_update_pane1.setVisible(true);
            result_update_pane2.setVisible(false);
            new_student_pane.setVisible(false);
            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
        }
        else if(event.getSource() == Next_page_result){
            result_update_pane.setVisible(true);
            result_update_pane1.setVisible(false);
            result_update_pane2.setVisible(true);
            new_student_pane.setVisible(false);
            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
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


    public ObservableList<new_data> list_Data(){
        ObservableList<new_data> data_List = FXCollections.observableArrayList();
         connect = DB.connectDb();

        String sql = "SELECT * FROM `new_student_data`";

        try{
            statement = connect.createStatement();
            res = statement.executeQuery(sql);

            new_data data;

            while(res.next()){
                data = new new_data(res.getInt("ID"),
                        res.getString("classs"),
                        res.getString("section"),
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("fathers_name"),
                        res.getString("mothers_name"),
                        res.getString("birth_date"),
                        res.getString("gender"),
                        res.getInt("birth_reg"),
                        res.getString("religion"),
                        res.getString("image"),
                        res.getString("blood_grp"),
                        res.getInt("fathers_mobile"),
                        res.getInt("mothers_mobile"),
                        res.getString("email"),
                        res.getString("present_address"),
                        res.getString("permanent_address")
                );

                data_List.addAll(data);
            }



        }catch(Exception ex){

        }

        return data_List;

    }

}
