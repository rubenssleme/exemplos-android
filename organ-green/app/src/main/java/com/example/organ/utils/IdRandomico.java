package com.example.organ.utils;

import java.util.Random;

public class IdRandomico {




    public static Integer valorAleatorio(Random gerador){
        //imprime sequência de 10 números inteiros aleatórios
        Integer vGerado = null ;
        for (int i = 0; i < 10; i++) {
            vGerado = gerador.nextInt();
        }
        return vGerado;
    }
}
