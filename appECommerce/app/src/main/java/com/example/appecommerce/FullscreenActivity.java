package com.example.appecommerce;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;

import com.example.appecommerce.databinding.ActivityFullscreenBinding;

import java.util.Timer;
import java.util.TimerTask;


public class FullscreenActivity extends AppCompatActivity {

    private static final boolean AUTO_ESCONDER = true;
    private static final int AUTO_ESCONDER_EM_ALGUNS_MILISEGUNDOS = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        inicializarTelaLogin();
    }
    private void inicializarTelaLogin(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
            finish();
                Intent telaLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(telaLogin);
            }
        },AUTO_ESCONDER_EM_ALGUNS_MILISEGUNDOS);
    }


}