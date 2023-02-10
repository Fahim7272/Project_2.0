package com.example.demo1;

import com.mysql.jdbc.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Admin_Dashboard implements Initializable {

    @FXML
    private Button All_Student_info;

    @FXML
    private Button Classrooms;

    @FXML
    private Button Contact_info_insert;

    @FXML
    private Button General_info_insert;

    @FXML
    private AnchorPane General_info_pane;

    @FXML
    private Button Post_announce;

    @FXML
    private AnchorPane announce_pane;

    @FXML
    private Button back_to_new_info;

    @FXML
    private DatePicker birth_date_inn;

    @FXML
    private TextField blood_grp_in;

    @FXML
    private TextField class_in;

    @FXML
    private AnchorPane class_routine_pane;

    @FXML
    private Button class_routine_proceed_btn;

    @FXML
    private AnchorPane class_routine_see_pane;

    @FXML
    private AnchorPane class_routine_selection_pane;

    @FXML
    private AnchorPane contact_info_pane;

    @FXML
    private TextField fathers_name;

    @FXML
    private TextField first_name;

    @FXML
    private ComboBox<?> gender_in;

    @FXML
    private Button home;

    @FXML
    private AnchorPane home_pane;

    @FXML
    private Button jump_to_contact;

    @FXML
    private TextField last_name;

    @FXML
    private AnchorPane left;

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
    private ComboBox<?> routine_class_picker;

    @FXML
    private ComboBox<?> routine_section_picker;

    @FXML
    private Button save_gen;

    @FXML
    private Button save_new_data;

    @FXML
    private TextField section_in;

    @FXML
    private TextField std_ID_input;

    @FXML
    private ComboBox<?> student_info_class_selector;

    @FXML
    private ScrollPane student_info_pane;

    @FXML
    private Button student_info_proceed_btn1;

    @FXML
    private ComboBox<?> student_info_section_selector;

    @FXML
    private AnchorPane student_info_selection;



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
            contact_info_pane.setVisible(false);
            student_info_pane.setVisible(false);
            student_info_selection.setVisible(false);
            class_routine_pane.setVisible(false);
        }
        else if(event.getSource() == new_student_data){
            new_student_pane.setVisible(true);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
            announce_pane.setVisible(false);
            contact_info_pane.setVisible(false);
            student_info_pane.setVisible(false);
            student_info_selection.setVisible(false);
            class_routine_pane.setVisible(false);
        }
        else if(event.getSource() == Post_announce){
            announce_pane.setVisible(true);
            new_student_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            contact_info_pane.setVisible(false);
            student_info_pane.setVisible(false);
            student_info_selection.setVisible(false);
            class_routine_pane.setVisible(false);
        }

        else if(event.getSource() == back_to_new_info || event.getSource() == General_info_insert){
            new_student_pane.setVisible(true);

            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
            student_info_pane.setVisible(false);
            student_info_selection.setVisible(false);
            class_routine_pane.setVisible(false);
        }
        else if(event.getSource() == jump_to_contact || event.getSource() == Contact_info_insert){
            contact_info_pane.setVisible(true);
            new_student_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            student_info_pane.setVisible(false);
            student_info_selection.setVisible(false);
            class_routine_pane.setVisible(false);
        }
        else if(event.getSource() == save_new_data){
            new_student_pane.setVisible(true);
            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(true);
            home_pane.setVisible(false);
            student_info_pane.setVisible(false);
            student_info_selection.setVisible(false);
            class_routine_pane.setVisible(false);
        }

        else if(event.getSource() == Classrooms){
            class_routine_pane.setVisible(true);
            new_student_pane.setVisible(false);
            student_info_pane.setVisible(false);
            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            student_info_selection.setVisible(false);
        }
        else if(event.getSource() == student_info_proceed_btn1){
            new_student_pane.setVisible(false);
            student_info_selection.setVisible(false);
            student_info_pane.setVisible(true);
            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            class_routine_pane.setVisible(false);
        }
        else if(event.getSource() == All_Student_info){
            student_info_selection.setVisible(true);
            new_student_pane.setVisible(false);
            student_info_pane.setVisible(false);
            contact_info_pane.setVisible(false);
            announce_pane.setVisible(false);
            General_info_pane.setVisible(false);
            home_pane.setVisible(false);
            class_routine_pane.setVisible(false);
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

            while(res.next()) {
                data = new new_data(
                        res.getString("ID"),
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("fathers_name"),
                        res.getString("mothers_name"),
                        res.getString("birth_date"),
                        res.getString("gender"),
                        res.getString("birth_reg"),
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

        }
        catch(Exception ex){

        }
        return data_List;
    }



    public void insertImage() {

        FileChooser op = new FileChooser();
        Stage stage = (Stage)left.getScene().getWindow();
        File file = op.showOpenDialog(stage);

        if(file != null){

            Image image;
            insertImage();
        }

    }



    private String _gender[] = {"Male", "Female"};
    public void comboBx(){
        List<String> list = new ArrayList<>();

        for(String d: _gender){
            list.add(d);
       }

        ObservableList datalist = FXCollections.observableArrayList(list);
        gender_in.setItems(datalist);
    }


    private String _class[] = {"1","2","3","4","5","6","7","8","9","10"};
    private String section[] = {"A","B"};
    public void comboBx2(){
        List<String> list = new ArrayList<>();

        for(String d: _class){
            list.add(d);
        }

        ObservableList datalist = FXCollections.observableArrayList(list);
        student_info_class_selector.setItems(datalist);
        routine_class_picker.setItems(datalist);
    }

    public void comboBx3(){
        List<String> list = new ArrayList<>();

        for(String d: section){
            list.add(d);
        }

        ObservableList datalist = FXCollections.observableArrayList(list);
        student_info_section_selector.setItems(datalist);
        routine_section_picker.setItems(datalist);
    }

    public void insert_data()
    {
        connect = DB.connectDb();

        String sql = "INSERT INTO `new_student_data`(`First_name`, `Last_name`, `ID`, `Fathers_name`, `Mothers name`, `Birth_date`, `Gender`, `Religion`, `Blood Group`) VALUES (?,?,?,?,?,?,?,?,?)";

            try{
                prep = (PreparedStatement) connect.prepareStatement(sql);

                prep.setString(1, first_name.getText());
                prep.setString(2, last_name.getText());
                prep.setString(3, std_ID_input.getText());
                prep.setString(4, fathers_name.getText());
                prep.setString(5, mothers_name.getText());
                prep.setString(6, birth_date_inn.getValue().toString());
                prep.setString(7, gender_in.getValue().toString());
                prep.setString(8, religion_in.getText());
                prep.setString(9, blood_grp_in.getText());

                prep.executeUpdate();

            }catch (Exception ex){

            }

    }


    public void showData() {
        connect = DB.connectDb();
        String sql = "SELECT * FROM new_student_data";

        try {
            prep = (PreparedStatement) connect.prepareStatement(sql);
            ResultSet result = prep.executeQuery();

            while (result.next()) {
                first_name.setText(result.getString("first_name"));
                last_name.setText(result.getString("last_name"));
                std_ID_input.setText(result.getString("student_ID"));
                fathers_name.setText(result.getString("fathers_name"));
                mothers_name.setText(result.getString("mothers_name"));
                //date_of_birth.setText(result.getString("date_of_birth"));
                //gender_in.setText(result.getString("gender"));
                religion_in.setText(result.getString("religion"));
                blood_grp_in.setText(result.getString("blood_group"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rs){
        comboBx();
        comboBx2();
        comboBx3();
    }

}
