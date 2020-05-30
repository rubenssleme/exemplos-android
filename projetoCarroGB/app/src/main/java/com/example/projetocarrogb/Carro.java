package com.example.projetocarrogb;

public class Carro {
    //Atributos
    private String modelo;
    private int velocidade;
    private int marcha;

    //Como selecionar tudo: CTRL + A
    // Organizar o codigo   CTRL + ALT + L

    //Metodos
    public void acelerar() {
        for (int i = 0; i <= 22; i++) {
            velocidade = velocidade + 10;
            System.out.println("A velocidade do carro eh = " + velocidade + "KM por Hora!");
        }
    }

}
