package com.example.consumoapiproduto.configs;

import com.example.consumoapiproduto.ProdutoClient;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://apirest-produto1.herokuapp.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ProdutoClient getProdutoService() {
        return this.retrofit.create(ProdutoClient.class);
    }
}
