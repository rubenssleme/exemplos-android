package com.example.calculadoracomlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaração dos objetos ou componentes
    EditText edtValor1, edtValor2;
    Button btnSomar, btnSubtrair, btnMultiplicar, btnDividir;
    TextView txvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarObjetos();
        calculaSoma();
        calculaSubtracao();
    }

    //Inicialização dos Objetos
    private void inicializarObjetos() {
        edtValor1 = (EditText) findViewById(R.id.edtValor1);
        edtValor2 = (EditText) findViewById(R.id.edtValor2);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSubtrair = (Button) findViewById(R.id.btnSubtrair);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        txvResultado = (TextView) findViewById(R.id.txvResultado);
    }
    //Inicio da operação de soma
    private void calculaSoma() {
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operação de soma
                int v1 = Integer.parseInt(edtValor1.getText().toString());
                int v2 = Integer.parseInt(edtValor2.getText().toString());
                String resultado = String.valueOf(v1 + v2);
                txvResultado.setText("O valor da Soma é : " + resultado);
            }
        });

    }
    //Fim da operação de soma
    //Inicio da operação de Subtracao
    private void calculaSubtracao() {
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operação de Sutracao
                int v1 = Integer.parseInt(edtValor1.getText().toString());
                int v2 = Integer.parseInt(edtValor2.getText().toString());
                String resultado = String.valueOf(v1 - v2);
                txvResultado.setText("O valor da Subtr é : " + resultado);
            }
        });

    }
    //Fim da operação de Subtracao


}
