package com.example.projetoexemplobg;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class ControladorTelaSplash extends AppCompatActivity {
private static final int TEMPO_LIMITE = 3000;//Tempo em Milesegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        iniciarProximaTela();
    }

    private void iniciarProximaTela(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
              finish();
                Intent splash = new Intent(getApplicationContext(),ControladorTelaLogin.class);
                startActivity(splash);
            }
        },TEMPO_LIMITE);
    }



}
