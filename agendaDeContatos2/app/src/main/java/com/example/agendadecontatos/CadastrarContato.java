package com.example.agendadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarContato extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextEmail;
    EditText editTextTelefone;
    EditText editTextEndereco;
    Button buttonCadastrar;
    Button buttonCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_contato);

    }
}