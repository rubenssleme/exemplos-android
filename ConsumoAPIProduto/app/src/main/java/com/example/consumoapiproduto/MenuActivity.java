package com.example.consumoapiproduto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent telaConsulta = new Intent(getApplicationContext(),ConsultaActivity.class);
                startActivity(telaConsulta);
            }
        });
    }
}