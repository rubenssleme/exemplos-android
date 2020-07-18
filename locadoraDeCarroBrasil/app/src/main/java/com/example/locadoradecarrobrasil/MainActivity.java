package com.example.locadoradecarrobrasil;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locadoradecarrobrasil.entidade.AluguelCarro;
import com.example.locadoradecarrobrasil.entidade.Veiculo;
import com.example.locadoradecarrobrasil.servico.AluguelCarroServico;
import com.example.locadoradecarrobrasil.servico.BrasilImpostoServico;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    //Declaração dos objetos ou componentes.
    EditText editTextModeloCarro;
    EditText editTextDataRetirada;
    EditText editTextDataEntrega;
    EditText editTextValorPorHora;
    EditText editTextValorPorDia;

    Button buttonEnviar;
    Button buttonCancelar;
    TextView textViewValorDadosFatura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribuir os valores aos objetos ou componentes.
        editTextModeloCarro = findViewById(R.id.editTextModeloCarro);
        editTextDataRetirada = findViewById(R.id.editTextDataRetirada);
        editTextDataEntrega = findViewById(R.id.editTextDataEntrega);
        editTextValorPorHora = findViewById(R.id.editTextValorHora);
        editTextValorPorDia = findViewById(R.id.editTextValorDia);

        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        textViewValorDadosFatura = findViewById(R.id.textViewValorDadosFatura);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dadosDeEntradaParaCalculoDaLocacao();

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void dadosDeEntradaParaCalculoDaLocacao() throws ParseException {
        String modeloCarro = editTextModeloCarro.getText().toString();
        String dataRetirada = editTextDataRetirada.getText().toString();
        String dataEntrega = editTextDataEntrega.getText().toString();
        // Para Aluguel do Carro
        AluguelCarro aluguelCarro = new AluguelCarro(sdf.parse(dataRetirada), sdf.parse(dataEntrega),
                new Veiculo(modeloCarro));

        String valorPorHora = editTextValorPorHora.getText().toString();
        String valorPorDia = editTextValorPorDia.getText().toString();

        //Para Calculo do Aluguel do carro.
        AluguelCarroServico aluguelCarroServico = new AluguelCarroServico(Double.parseDouble(valorPorDia),
                Double.parseDouble(valorPorHora), new BrasilImpostoServico());

        aluguelCarroServico.processamentoFatura(aluguelCarro);
        dadosDeSaidaDaFatura(aluguelCarro,modeloCarro,valorPorHora,valorPorDia);

    }

    public void dadosDeSaidaDaFatura(AluguelCarro aluguelCarro,String modeloCarro,String valorPorHora, String valorPorDia) {
        String valorSemImposto = aluguelCarro.getFatura().getValorSemImposto().toString();
        String valorDoImposto = aluguelCarro.getFatura().getImposto().toString();
        String totalAPagar = aluguelCarro.getFatura().getTotalDePagamento().toString();
         String dataRetirada = aluguelCarro.getDataRetirada().toString();
         String dataDevolucao = aluguelCarro.getDataDevolucao().toString();
        textViewValorDadosFatura.setText(
                "\nModelo do Veiculo: " + modeloCarro +
                        "\nData Locação: " + dataRetirada +
                        "\nData de Retorno: " + dataDevolucao +
                        "\nvalor por Hora: R$ " + valorPorHora +
                        "\nValor por Dia: R$ " + valorPorDia +
                        "\n-----------------------" +
                        "\nValor da Fatura:" +
                        "\nPagamento S/ imposto: R$ " + valorSemImposto +
                        "\nValor do Imposto: R$ " + valorDoImposto +
                        "\nTotal a Pagar: R$ " + totalAPagar);
    }

}