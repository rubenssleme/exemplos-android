package com.example.appMobileBG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ConsultaUsuario extends AppCompatActivity {
    Button buttonNovoContato;
    ListView listViewContato;
    ArrayList<UsuarioDTO> arrayListContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_usuario);
        buttonNovoContato = findViewById(R.id.buttonNovoContato);
        listViewContato = findViewById(R.id.listViewContato);
        UsuarioDAO daoContato = new UsuarioDAO(getApplicationContext());

        arrayListContato = daoContato.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListContato);

        listViewContato.setAdapter(adapter);


        cadastrarNovoContato();
    }

    private void cadastrarNovoContato() {
        buttonNovoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoContato = new Intent(getApplicationContext(), CadastrarUsuario.class);
                startActivity(novoContato);
            }
        });
    }
}
