package com.example.consumoapiproduto;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://apirest-produto1.herokuapp.com/api/produtos")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ProdutoService getProdutoService() {
        return this.retrofit.create(ProdutoService.class);
    }
}
