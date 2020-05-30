package com.example.minhacalculadora;

public class Calculadora {

    private double resultado;
    private double valor1;
    private double valor2;

    public  double somar(double valor1, double valor2 ){
        resultado = (valor1 + valor2);
        return resultado;
    }

    public  double subtrair(double valor1, double valor2 ){
        resultado = (valor1 - valor2);
        return resultado;
    }

}
