package com.example.projetocarro;

public class Carro {
    //Atributos
    private String Modelo;
    private int marcha;
    private int velocidade;


    //Metodos

    public void acelerar(){
        for (int i = 0; i <= 9; i++){
            velocidade = velocidade + 10;
            System.out.println("A velocidade eh = " + velocidade);
        }
    }

}
