package com.example.myapplication;

public class Soma {

    private int valor;
    private int valor2;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }


    public int  somaValor(int valor , int valor2){
       return (valor + valor2);
    }
}
