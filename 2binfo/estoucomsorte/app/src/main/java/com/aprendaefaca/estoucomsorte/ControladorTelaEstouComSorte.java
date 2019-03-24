package com.aprendaefaca.estoucomsorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ControladorTelaEstouComSorte extends AppCompatActivity {

    private ImageView imvJogar;
    private String[] opcao = {"cara","coroa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_estou_com_sorte);

        imvJogar = (ImageView) findViewById(R.id.imvJogarId);
        imvJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Random randomico = new Random();
             int numeroAleatorio = randomico.nextInt(2);
                Intent intent = new Intent(ControladorTelaEstouComSorte.this,TelaSorteJogada.class);
                intent.putExtra("opcao",opcao[numeroAleatorio]);
                startActivity(intent);
            }
        });

    }
}
