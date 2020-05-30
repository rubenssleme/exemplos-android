package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        System.out.println(2+2);
    }
    @Test
    public void testeDeSoma() {
        OperacoesMatematicas operacoesMatematicas = new OperacoesMatematicas();
        System.out.println("A soma de 5 + 7 eh = " + operacoesMatematicas.somarValores());
        System.out.println("A soma de 5 + 7 eh = " + operacoesMatematicas.somarValores()); // CTRL + / Atalho para cometario.
        System.out.println("A soma de 5 + 7 eh = " + operacoesMatematicas.somarValores());
    }

}