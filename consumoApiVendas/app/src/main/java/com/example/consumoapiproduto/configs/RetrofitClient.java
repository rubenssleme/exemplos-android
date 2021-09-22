package com.example.consumoapiproduto.configs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    // RxJava
                    /*.addCallAdapterFactory(RxJavaCallAdapterFactory.create())*/
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

  /*  public static final String URL_BASE = "https://apirest-produto1.herokuapp.com/api/";
    private static Retrofit instance;

    private static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance;
    }

    public static <T> T getInstance(Class<T> tClass) {
        return getInstance().create(tClass);
    }*/
}
