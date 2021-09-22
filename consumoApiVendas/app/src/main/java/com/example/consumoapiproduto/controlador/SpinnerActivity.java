package com.example.consumoapiproduto.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consumoapiproduto.R;

public class SpinnerActivity extends AppCompatActivity {
Spinner spinnerSistemas;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinnerSistemas = findViewById(R.id.spinnerSistemas);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.sistemas_os, android.R.layout.simple_spinner_item);
        spinnerSistemas.setAdapter(arrayAdapter);
        textView = findViewById(R.id.textView);


        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = spinnerSistemas.getSelectedItem().toString();
                textView.setText("Sistema operacional escolhido: " + item);
                Toast.makeText(SpinnerActivity.this,"Sistema operacional escolhido: "+ item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spinnerSistemas.setOnItemSelectedListener(escolha);
    }
}