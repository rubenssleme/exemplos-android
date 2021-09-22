package com.example.consumoapiproduto.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.consumoapiproduto.R;
import com.example.consumoapiproduto.controlador.ConsultaProdutoActivity;

public class MenuActivity extends AppCompatActivity {
Button buttonConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonConsultar = findViewById(R.id.buttonConsultar);
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaConsulta = new Intent(getApplicationContext(), ConsultaProdutoActivity.class);
                startActivity(telaConsulta);
            }
        });
    }
}