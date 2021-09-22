package com.example.consumoapiproduto.service;

import com.example.consumoapiproduto.Observable;
import com.example.consumoapiproduto.ProdutoClient;
import com.example.consumoapiproduto.configs.RetrofitClient;
import com.example.consumoapiproduto.dominio.Produto;

import java.util.List;

public class ProdutoService {

    private ProdutoClient produtoClient;

    public ProdutoService() {
       // this.produtoClient = RetrofitClient.getClient("https://apirest-produto1.herokuapp.com/api/");
    }

    public Observable<Produto> buscarProduto(Long id) {
        return new Observable<>(this.produtoClient.buscarProduto(id));
    }

    public Observable<List<Produto>> buscarProdutos() {
        return new Observable<>(this.produtoClient.buscarProdutos());
    }
    public Observable<Produto> salvarProduto(Produto produto) {

        return new Observable<>(this.produtoClient.saveProduto("Dell Latitude 3", "10.00","1200.00"));
    }

}
