package com.example.minhacalculadora;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {




    @Test
    public void calculaSomaSucesso(){
      Calculadora calculadora =  new Calculadora();
      //calculadora.somar(10.0, 25.0);
        System.out.println("O valor da soma é "+ calculadora.somar(10.0, 25.0));

    }
    @Test
    public void calculaSubtracaoSucesso(){
        Calculadora calculadora =  new Calculadora();
        //calculadora.somar(10.0, 25.0);
        System.out.println("O valor da subtracao é "+ calculadora.subtrair(25.0, 15.0));

    }
}
