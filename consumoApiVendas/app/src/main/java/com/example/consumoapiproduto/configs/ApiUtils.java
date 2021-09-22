package com.example.consumoapiproduto.configs;

import com.example.consumoapiproduto.ProdutoClient;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://apirest-produto1.herokuapp.com/api/";

    public static ProdutoClient getProdutoClient() {

        return RetrofitClient.getClient(BASE_URL).create(ProdutoClient.class);
    }
}
