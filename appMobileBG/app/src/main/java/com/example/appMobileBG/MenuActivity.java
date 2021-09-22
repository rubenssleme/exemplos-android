package com.example.appMobileBG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
Button buttonCadastrar;
Button buttonConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonConsultar = findViewById(R.id.buttonConsultar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Qual tela  ou Activity vou abrir
                Intent telaCadastrar = new Intent();
                telaCadastrar.setClass(MenuActivity.this, CadastrarUsuario.class);
                startActivity(telaCadastrar);
            }
        });
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Qual tela  ou Activity vou abrir
                Intent telaConsultar = new Intent(getApplicationContext(), ConsultaUsuario.class);
                startActivity(telaConsultar);
            }
        });


    }
}