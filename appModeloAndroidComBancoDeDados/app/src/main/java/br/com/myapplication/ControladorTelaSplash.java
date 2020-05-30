package br.com.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class ControladorTelaSplash extends AppCompatActivity {

   private static final int TEMPO = 3000;
    @Override
   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.tela_splash);
       iniciarTelaSplash();
   }

    private void iniciarTelaSplash() {
    new Timer().schedule(new TimerTask() {
        @Override
        public void run() {
        Intent splash = new Intent();
        splash.setClass(ControladorTelaSplash.this,
                ControladorTelaLogin.class);
            startActivity(splash);
                }
    },TEMPO);
   }

}
