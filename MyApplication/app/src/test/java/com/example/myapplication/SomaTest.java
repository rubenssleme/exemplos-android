package com.example.myapplication;

import org.junit.Test;

public class SomaTest {

    @Test
   public  void somaSucessoTest(){
       Soma soma = new Soma();
       System.out.println("A soma do valor é : " + soma.somaValor(15,25));
   }

    @Test
    public  void somaValorNegativoTest(){
        Soma soma = new Soma();
        System.out.println("A soma do valor é : " + soma.somaValor(-15,-25));
    }

    @Test
    public  void somaValorTest(){
        Soma soma = new Soma();
        System.out.println("A soma do valor é : " + soma.somaValor(50,-25));
    }



}
