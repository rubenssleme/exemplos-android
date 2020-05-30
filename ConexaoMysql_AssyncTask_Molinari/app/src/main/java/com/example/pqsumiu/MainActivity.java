package com.example.pqsumiu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonNovo;
    ListView listViewUsuario;
    ArrayList<DtoUsuario> listUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNovo = findViewById(R.id.buttonNovo);
        listViewUsuario = findViewById(R.id.listViewUsuario);

        buttonNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InserirActivity.class);
                startActivity(intent);

            }
        });

        try {
            listUsuario = new DaoUsuario().consultar();
        } catch (SQLException e) {
            AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
            msg.setMessage("Erro: " + e.toString());
        }

        ArrayAdapter adapter =
                new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listUsuario);

        listViewUsuario.setAdapter(adapter);
    }
}
