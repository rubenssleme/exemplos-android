package com.example.agendadecontatos.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendadecontatos.R;
import com.example.agendadecontatos.modelo.ContatoDTO;
import com.example.agendadecontatos.modelo.Login;
import com.example.agendadecontatos.repositorio.ContatoDAO;
import com.example.agendadecontatos.repositorio.LoginRepositorio;

import java.util.ArrayList;

public class ConsultaLogin extends AppCompatActivity {
    Button buttonNovoContato;
    ListView listViewContato;
    ArrayList<Login> arrayListLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_login);
        buttonNovoContato = findViewById(R.id.buttonNovoContato);
        listViewContato = findViewById(R.id.listViewLogin);
       LoginRepositorio loginRepositorio = new LoginRepositorio(getApplicationContext());

        arrayListLogin = (ArrayList<Login>) loginRepositorio.obterTodos();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListLogin);

        listViewContato.setAdapter(adapter);
        cadastrarNovoLogin();
    }

    private void cadastrarNovoLogin() {
        buttonNovoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoLogin = new Intent(getApplicationContext(), CadastrarLogin.class);
                startActivity(novoLogin);
            }
        });
    }
}
