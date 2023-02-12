package com.example.demo1;


import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection connectDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/2.0", "root", "Br6jlJFJ7XUgAUrC");

            return connect;

        }catch(Exception ex){
            System.out.println(ex);
        }

        return null;
    }
}
