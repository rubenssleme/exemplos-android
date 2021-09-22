package com.example.consumoapiproduto;

import com.example.consumoapiproduto.dominio.Cliente;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClienteClient {
    @GET("cliente/{id}")
    Call<Cliente> buscarProduto(@Path("id") Long id);

    @GET("clientes")
    Call<List<Cliente>> buscarProdutos();
}

