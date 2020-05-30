package br.com.example.projetoModelo_A;

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


public class FullscreenActivity extends AppCompatActivity {
   private  static final int TEMPO_PARA_CHAMAR_A_PROXIMA_ACTIVITY= 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

    }

    private void iniciarTelaSplash(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent splash = new Intent();
                splash.setClass(FullscreenActivity.this,
                        LoginActivity1.class);
                startActivity(splash);
            }
        },TEMPO_PARA_CHAMAR_A_PROXIMA_ACTIVITY);
    }


}
