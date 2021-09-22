package com.example.consumoapiproduto;

import java.util.List;

public class ProdutoService {

    private ProdutoClient produtoClient;

    public ProdutoService() {
        this.produtoClient = RetrofitClient.getInstance(ProdutoClient.class);
    }

    public Observable<Produto> buscarProduto(Long id) {
        return new Observable<>(this.produtoClient.buscarProduto(id));
    }

    public Observable<List<Produto>> buscarProdutos() {
        return new Observable<>(this.produtoClient.buscarProdutos());
    }
}
