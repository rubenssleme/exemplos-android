package com.example.consumoapiproduto.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.consumoapiproduto.R;
import com.example.consumoapiproduto.utils.Mensagem;

public class LoginActivity extends AppCompatActivity {
Button buttonEnviar;
EditText editTextUsuario;
EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(camposPreenchidos()) {
                    if ((editTextUsuario.getText().toString().equals("a"))&&(editTextSenha.getText().toString().equals("a"))) {
                        Intent telaMenu = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(telaMenu);
                    }else{
                        Mensagem.exibirMensagem(getApplicationContext(),"Os valores dos campos são diferentes");
                    }
                }else{
                    Mensagem.exibirMensagem(getApplicationContext(),"Campos nao preenchidos");
                }
            }
        });
    }
    private boolean camposPreenchidos() {
        return !(editTextUsuario.getText().toString().isEmpty() || editTextSenha.getText().toString().isEmpty());
    }


}