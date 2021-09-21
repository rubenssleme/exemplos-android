package com.aprendaefaca.telaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ControladorTelaActivity extends AppCompatActivity {
 private Button botao ;
 private Button btnTelaBottonNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_activity);

        botao = (Button) findViewById(R.id.btnClicarAqui);
        btnTelaBottonNavigation = (Button) findViewById(R.id.btnBottonNavigation);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent  = new Intent(ControladorTelaActivity.this,
                        ControladorTelaScrollView.class);
                startActivity(intent);
            }
        });


        btnTelaBottonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent  = new Intent(ControladorTelaActivity.this,
                        ControladorTelaBottomNavigation.class);
                startActivity(intent);
            }
        });


    }
}
