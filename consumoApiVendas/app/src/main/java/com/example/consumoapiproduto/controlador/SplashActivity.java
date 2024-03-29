package com.example.consumoapiproduto.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.consumoapiproduto.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final int TEMPO_TELA_ABERTA = 2000;// EM MILESEGUNDOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        inicializarTelaDeLogin();
    }
    private void inicializarTelaDeLogin() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent chamarTelaLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(chamarTelaLogin);
            }
        },TEMPO_TELA_ABERTA);
    }
}