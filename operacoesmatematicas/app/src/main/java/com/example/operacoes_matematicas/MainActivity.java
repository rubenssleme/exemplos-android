package com.example.operacoes_matematicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSoma; // Declaração de Um Button para somar
    private Button btnSubtrair; // Declaração de Um Button para somar
    EditText valor1;
    EditText valor2;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.num1);
        valor2 = (EditText) findViewById(R.id.num2);
        resultado = (TextView) findViewById(R.id.resultado);
        btnSoma = (Button) findViewById(R.id.btnSomar);
        btnSubtrair = (Button)findViewById(R.id.bottom);
        somarValores(valor1, valor2);
    }

    public void somarValores(final EditText num1, final EditText num2) {
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soma = 0;
                int valor1 = Integer.parseInt(num1.getText().toString());
                int valor2 = Integer.parseInt(num2.getText().toString());
                soma = valor1 + valor2;

                //modifica o valor do elemento para exibir em tela
                resultado.setText(Integer.toString(soma));
            }
        });
    }

}
