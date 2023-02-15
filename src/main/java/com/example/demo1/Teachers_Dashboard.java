package com.example.demo1;

import com.mysql.jdbc.PreparedStatement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private AnchorPane class_routine_pane;

    @FXML
    private Button class_routine_proceed_btn;

    @FXML
    private Button exit_Teacher;

    @FXML
    private TextField final_mark1;

    @FXML
    private TextField id1;

    @FXML
    private Button log_out_teachers;

    @FXML
    private TextField mid;

    @FXML
    private Button post_announce;

    @FXML
    private Button result_update;

    @FXML
    private AnchorPane teachers_home;

    @FXML
    private TextField test;


    private Connection connect;
    private Statement statement;
    private PreparedStatement prep;
    private ResultSet res;

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }
    public void exit(javafx.event.ActionEvent actionEvent) {
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


    public void mark_Update(javafx.event.ActionEvent actionEvent) throws SQLException {
        connect = DB.connectDb();
        String sql = "UPDATE `result` SET `id`='[value-1]',`test`='[value-2]',`mid`='[value-3]',`final`='[value-4]',`subjects_`='[value-5]' WHERE "+id1.getText();
        PreparedStatement st = (PreparedStatement) connect.prepareStatement(sql);
        st.setInt(1, Integer.parseInt(id1.getText()));
        st.setString(2,test.getText());
        st.setString(3,mid.getText());
        st.setString(4,final_mark1.getText());
        st.setString(5,"Math");
        st.executeUpdate();
    }



}
