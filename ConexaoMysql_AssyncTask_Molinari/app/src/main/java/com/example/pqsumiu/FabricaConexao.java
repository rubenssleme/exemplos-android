package com.example.pqsumiu;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    static Connection connection;

    public static boolean conectar(){

        //ASSOCIA O DRIVER MYSQL
        try {
           // Class.forName("com.mysql.jdbc.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
           // connection = DriverManager.getConnection("jdbc:mysql://localhost/teste","root","root");
            connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com/HQv1ZgSXjz","HQv1ZgSXjz","9VizjrrWNS");
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

}



