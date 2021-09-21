package com.example.minhaapp;

public class Conta {
    private Double saldo;

    public Conta(Double saldo) {
        this.saldo = saldo;
    }

    public Double Debitar(Double valor){

         saldo = (saldo - valor);

        return saldo;
    }
}
