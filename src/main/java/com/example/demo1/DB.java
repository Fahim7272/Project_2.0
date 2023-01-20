package com.example.demo1;


import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;

public class DB {

    public static Connection connectDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/project_2.0", "root", "123");

            return connect;

        }catch(Exception ex){
            System.out.println(ex);
        }

        return null;
    }
}
