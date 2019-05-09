package com.example.bg.exemplobg3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ControladorTelaSplash1 extends AppCompatActivity {
    private static final int TEMPO = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_splash1);
        inicializarTelaSplash();
    }
    private void inicializarTelaSplash(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent splash = new Intent();
                splash.setClass(ControladorTelaSplash1.this,
                        ControladorTelaPrincipal.class);
                startActivity(splash);


            }
        },TEMPO);

    }
}
