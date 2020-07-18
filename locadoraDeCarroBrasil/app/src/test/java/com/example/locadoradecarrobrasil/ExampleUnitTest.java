package com.example.locadoradecarrobrasil;

import com.example.locadoradecarrobrasil.entidade.AluguelCarro;
import com.example.locadoradecarrobrasil.servico.AluguelCarroServico;
import com.example.locadoradecarrobrasil.servico.BrasilImpostoServico;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
@Test
public void teste() throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    System.out.println("Dados da Locação: ");
    System.out.print("Modelo do Veiculo: ");
    String modeloVeiculo = "Corolla 2"; //Valor Digitado
    System.out.println(modeloVeiculo);
    System.out.print("Data Locação (dd/MM/yyyy HH:mm): ");
    Date start = sdf.parse("25/06/2018 10:30");//Valor Digitado
    System.out.println(start);
    System.out.print("Data de Retorno (dd/MM/yyyy HH:mm): ");
    Date finish = sdf.parse("25/06/2018 14:40");//Valor Digitado
    System.out.println(finish);

    AluguelCarro aluguelCarro = new AluguelCarro(start, finish, new Veiculo(modeloVeiculo));

    System.out.print("Entre com valor por Hora: ");
    double valorAluguelPorHora = 10.0;//Valor Digitado
    System.out.println(valorAluguelPorHora);
    System.out.print("Entre com Valor por Dia: ");
    double valorAluguelPorDia = 130.0;//Valor Digitado
    System.out.println(valorAluguelPorDia);

    AluguelCarroServico aluguelCarroServico = new AluguelCarroServico(valorAluguelPorDia, valorAluguelPorHora, new BrasilImpostoServico());

    aluguelCarroServico.processamentoFatura(aluguelCarro);

    System.out.println("Nota Fiscal:");
    System.out.println("Pagamento S/ imposto: " + String.format("%.2f", aluguelCarro.getFatura().getValorSemImposto()));
    System.out.println("Valor do Imposto: " + String.format("%.2f", aluguelCarro.getFatura().getImposto()));
    System.out.println("Total a Pagar: " + String.format("%.2f", aluguelCarro.getFatura().getTotalDePagamento()));

    sc.close();
}


}