package com.example.appsalaodebeleza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaLogin extends AppCompatActivity {
    Button buttonEnviar;//Declaração do objeto botão
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonEnviar = findViewById(R.id.buttonEnviar);//Atribuição do Objeto Botao da activity
        abrirTelaMenu();                                           //Classe java.
    }

    public void abrirTelaMenu(){

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMenu = new Intent(getApplicationContext(),ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });
    }
}