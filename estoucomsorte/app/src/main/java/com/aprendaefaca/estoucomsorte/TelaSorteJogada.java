package com.aprendaefaca.estoucomsorte;

import android.content.Intent;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TelaSorteJogada extends AppCompatActivity {

    private ImageView imvSorteJogada;
    private ImageView imvVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_sorte_jogada);

        imvSorteJogada = (ImageView) findViewById(R.id.imvCaraId);
        imvVoltar = (ImageView) findViewById(R.id.imvVoltarId);
        Bundle extra = getIntent().getExtras();

        if(extra != null){
            String opcaoEscolhida = extra.getString("opcao");
            if(opcaoEscolhida.equals("cara")){
                imvSorteJogada.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_cara));
            }else{
                imvSorteJogada.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_coroa));
            }
        }


        imvVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });

    }
}
