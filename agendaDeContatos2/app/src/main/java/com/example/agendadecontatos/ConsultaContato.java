package com.example.agendadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ConsultaContato extends AppCompatActivity {
    Button buttonNovoContato;
    ListView listViewContato;
    ArrayList<DtoContato> arrayListContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_contato);
        buttonNovoContato = findViewById(R.id.buttonAdicionarNovo);
        listViewContato = findViewById(R.id.listViewContato);
        DaoContato daoContato = new DaoContato(getApplicationContext());

        arrayListContato = daoContato.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayListContato);
        listViewContato.setAdapter(adapter);
    }
}
