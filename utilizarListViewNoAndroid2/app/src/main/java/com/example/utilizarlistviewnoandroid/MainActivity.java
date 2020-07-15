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
    //declaração dos componentes ou objetos
    EditText editTextNomeFilme;
    Button buttonAdcionar;
    ListView listViewListaDeFilme;
    ArrayList<String> arrayListFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Atribuição de valores.
        editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        buttonAdcionar = findViewById(R.id.buttonAdicionar);
        listViewListaDeFilme = findViewById(R.id.listViewListaDeFilme);
        buttonAdcionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Atribuição do Array
                arrayListFilmes.add(editTextNomeFilme.getText().toString());
                //Juntar Adapter com Arraylist
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListFilmes);
                listViewListaDeFilme.setAdapter(adapter);
                editTextNomeFilme.setText("");


            }
        });


    }
}