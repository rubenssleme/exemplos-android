package com.example.modelo3binfocombanco;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ControladorTelaSplash extends AppCompatActivity {
    private static final int TEMPO_LIMITE = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlador_tela_splash);
        iniciarTelaSplash();
    }

    private void iniciarTelaSplash() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent splash = new Intent();
                splash.setClass(ControladorTelaSplash.this,
                        ControladorTelaLogin.class);
                startActivity(splash);
            }
        }, TEMPO_LIMITE);
    }

}
