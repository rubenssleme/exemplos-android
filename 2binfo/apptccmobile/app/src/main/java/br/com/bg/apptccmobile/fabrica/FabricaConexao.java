package br.com.bg.apptccmobile.fabrica;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao extends AsyncTask {
Connection connection = null;
    @Override
    public Object doInBackground(Object[] objects) {
        //Burocracia
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_churas","rubens", "1234567");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
