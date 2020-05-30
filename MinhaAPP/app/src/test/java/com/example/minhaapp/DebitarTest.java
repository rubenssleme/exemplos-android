package com.example.minhaapp;

import org.junit.Assert;
import org.junit.Test;

public class DebitarTest {

    @Test
    public void debitarPoupancaSucessoTest(){
        ContaPoupanca contaPoupanca = new ContaPoupanca(500.0d);
        System.out.println(contaPoupanca.Debitar(100.0d));
        Assert.assertEquals(400.00,500.0d,contaPoupanca.Debitar(100.0d).doubleValue());

    }

    @Test
    public void debitarPoupancaErroValorNegativoTest(){
        ContaPoupanca contaPoupanca = new ContaPoupanca(500.0d);
        System.out.println(contaPoupanca.Debitar(-100.0d));
        Assert.assertEquals(600.00,500.0d,contaPoupanca.Debitar(-100.0d).doubleValue());

    }

    @Test
    public void debitarPoupancaErroSaldorNegativoTest(){
        ContaPoupanca contaPoupanca = new ContaPoupanca(-500.0d);
        System.out.println(contaPoupanca.Debitar(100.0d));
        Assert.assertEquals(500.0d,500.0d,contaPoupanca.Debitar(100.0d).doubleValue());

    }

}
