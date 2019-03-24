package bg.com.br.navigationdrawerbg.controladores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bg.com.br.navigationdrawerbg.R;

public class ControladorTelaOperacoes extends AppCompatActivity {

    //Declaração das variaveis de componentes
    EditText edtValor1, edtValor2;
    TextView txvResultado;
    Button btnSomar, btnSubtrair;

    //Variaveis para calculo
    double valor1, valor2,resultado;

    protected  void abrirTela(Context tela, Class<?> novaTela){
        Intent intent = new Intent(tela,novaTela);
        this.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_operacoes);


        //Associação dos componentes e variaveis

        edtValor1 = (EditText) findViewById(R.id.edtValor1);
        edtValor2 = (EditText) findViewById(R.id.edtValor2);
        txvResultado = (TextView) findViewById(R.id.txvResultado);
        // Asociação dos botoes
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSubtrair = (Button) findViewById(R.id.btnSubtrair);


        //Adicionando a programação dos botões no evento de clique
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1 = Double.parseDouble(edtValor1.getText().toString());
                valor2 = Double.parseDouble(edtValor2.getText().toString());
                resultado =  (valor1 + valor2);
        }
        });


        //Adicionando a programação dos botões no evento de clique
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1 = Double.parseDouble(edtValor1.getText().toString());
                valor2 = Double.parseDouble(edtValor2.getText().toString());
                resultado =  (valor1 - valor2);
            }
        });

    }



}
