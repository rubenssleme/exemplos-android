package br.com.basilides.approsahair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControladorTelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
