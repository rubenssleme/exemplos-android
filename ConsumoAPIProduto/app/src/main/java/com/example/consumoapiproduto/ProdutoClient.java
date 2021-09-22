package com.example.consumoapiproduto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProdutoClient {

    @GET("produto/{id}")
    Call<Produto> buscarProduto(@Path("id") Long id);

    @GET("produtos")
    Call<List<Produto>> buscarProdutos();
}
