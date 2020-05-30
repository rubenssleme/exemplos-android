package com.example.projetoexemplo2binfo_b;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class ControladorTelaSplash extends AppCompatActivity {
private static final int TEMPO_LIMITE = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        inicilizarProximaTela();
    }
    private void inicilizarProximaTela(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent proximaTela = new Intent(getApplicationContext(),ControladorTelaLogin.class);
                startActivity(proximaTela);
            }
        },TEMPO_LIMITE);
    }

}
