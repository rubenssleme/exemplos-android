package com.example.utilizarlistviewnoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Declaração dos objetos
    EditText editTextNomeFilme;
    Button buttonAdicionar;
    ListView listViewFilme;
    ArrayList<String> arrayListFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        listViewFilme = findViewById(R.id.listViewFilme);


        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListFilmes.add(editTextNomeFilme.getText().toString());
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListFilmes);
                listViewFilme.setAdapter(adapter);
                editTextNomeFilme.setText("");

            }
        });


    }
}