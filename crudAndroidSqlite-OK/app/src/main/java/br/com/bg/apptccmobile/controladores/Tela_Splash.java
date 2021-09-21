package br.com.bg.apptccmobile.controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.bg.apptccmobile.R;

public class Tela_Splash extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__splash);
        // Retirar apos fibalizar estrutura das tabelas.
       // ApagadorDb.getInstancia().apagarDb(this, RepositorioBase.DATABASE_NAME);
        Intent it = new Intent(Tela_Splash.this, Tela_Principal.class);
        startActivity(it);
    }
}
