package com.example.consumoapiproduto;

import com.example.consumoapiproduto.dominio.Produto;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface    ProdutoClient {

    @GET("produto/{id}")
    Call<Produto> buscarProduto(@Path("id") Long id);

    @GET("produtos")
    Call<List<Produto>> buscarProdutos();

   /* @POST("/produto")
    Call<Produto> saveProduto(@Body Produto produto);*/


    @POST("/produto")
    @FormUrlEncoded
    Call<Produto> saveProduto(@Field("nome") String nome,
                        @Field("quantidade") String quantidade,
                        @Field("valor") String valor);



}
