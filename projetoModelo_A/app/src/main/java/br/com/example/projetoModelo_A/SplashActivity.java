package br.com.example.projetoModelo_A;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends AppCompatActivity {

     private static final int TEMPO_CHAMAR_ACTIVITY_LOGIN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        iniciarTelaSplash();
    }

    private void iniciarTelaSplash() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent splash = new Intent();
                splash.setClass(SplashActivity.this,
                        LoginActivity1.class);
                startActivity(splash);
            }
        }, TEMPO_CHAMAR_ACTIVITY_LOGIN);
    }

}
