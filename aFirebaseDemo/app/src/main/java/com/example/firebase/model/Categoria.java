package com.example.firebase.model;

public class Categoria {

    private Long imgProdutoCategoria;
    private Long id;
    private String nome;
    private String nomeCategoria;


    public Categoria() {

    }


    public Categoria(String nomeCategoria, Long imgProdutoCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.imgProdutoCategoria = imgProdutoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Long getImgProdutoCategoria() {
        return imgProdutoCategoria;
    }

    public void setImgProdutoCategoria(Long imgProdutoCategoria) {
        this.imgProdutoCategoria = imgProdutoCategoria;
    }
}
