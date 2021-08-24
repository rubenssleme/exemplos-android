package com.example.contactsrecycledview.category;

public class Category {

    private String nomeCategoria;
    private int imgProdutoCategoria;

    public Category() {

    }

    public Category(String nomeCategoria, int imgProdutoCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.imgProdutoCategoria = imgProdutoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getImgProdutoCategoria() {
        return imgProdutoCategoria;
    }

    public void setImgProdutoCategoria(int imgProdutoCategoria) {
        this.imgProdutoCategoria = imgProdutoCategoria;
    }
}
