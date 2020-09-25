package com.example.datahora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Declaração da TextView para receber o valor
    TextView tvDia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // atribuição do valor
        tvDia = findViewById(R.id.tvDia);

        Calendar c = Calendar.getInstance();

        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH) + 1;
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int hora = c.get(Calendar.HOUR_OF_DAY)-3;
        int minute = c.get(Calendar.MINUTE);

        String stDia, stMes, stHora, stMinuto,stAno;
        stDia = String.valueOf(dia);
        stMes = String.valueOf(mes);
       stHora = String.valueOf(hora);
       stMinuto = String.valueOf(minute);
        stAno = String.valueOf(ano);

        //Atribuição de data para a textview
       tvDia.setText("  " + stDia + "/" + stMes + "/" + stAno + " " + stHora+ ":" +stMinuto);


    }
}