package com.example.organ.model;

import com.example.organ.utils.IdRandomico;

import java.util.Random;

public class Categoria {

    private Long id;
    private String nomeCategoria;
    private Integer imgProdutoCategoria;



    public Categoria() {

    }

    public Categoria(String nomeCategoria, int imgProdutoCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.imgProdutoCategoria = imgProdutoCategoria;
    }

    public Long getId() {
        //instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
        return  Long.parseLong(IdRandomico.valorAleatorio(gerador).toString());
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getImgProdutoCategoria() {
        return imgProdutoCategoria;
    }

    public void setImgProdutoCategoria(Integer imgProdutoCategoria) {
        this.imgProdutoCategoria = imgProdutoCategoria;
    }
}
