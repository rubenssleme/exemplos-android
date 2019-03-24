package com.projetos.mobiletechlawer.controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projetos.mobiletechlawer.R;

import java.util.Timer;
import java.util.TimerTask;

public class ControladorTelaSplash extends AppCompatActivity {

    public static final int TEMPO=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(ControladorTelaSplash.this, ControladorTelaLogin.class));
            }
        }, TEMPO);
    }
    }
