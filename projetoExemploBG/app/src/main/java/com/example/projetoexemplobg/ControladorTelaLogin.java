package com.example.projetoexemplobg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ControladorTelaLogin extends AppCompatActivity {
    Button btnEnviar, btnCancelar;
    EditText edtUsuario, edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        inicializarObjetos();
        abrirActivityMenu();
    }

    private void inicializarObjetos() {

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

    }

    private void abrirActivityMenu() {
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActivityMenu = new Intent(getApplicationContext(), ControladorTelaPrincipal.class);
                startActivity(intentActivityMenu);
            }
        });
    }


}
