package com.example.projetoexemplo2binfo;


        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import java.util.Timer;
        import java.util.TimerTask;


public class ControladorTelaSplash extends AppCompatActivity {
    private static final int TEMPO_LIMITE = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        inicializarProximaTela();
    }

    private void inicializarProximaTela() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent telaLogin = new Intent(getApplicationContext(), ControladorTelaLogin.class);
                startActivity(telaLogin);
            }
        }, TEMPO_LIMITE);
    }


}
