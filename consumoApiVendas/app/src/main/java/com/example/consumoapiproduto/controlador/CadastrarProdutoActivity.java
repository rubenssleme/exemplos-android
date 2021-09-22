package com.example.consumoapiproduto.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.consumoapiproduto.ProdutoClient;
import com.example.consumoapiproduto.R;
import com.example.consumoapiproduto.configs.ApiUtils;
import com.example.consumoapiproduto.dominio.Produto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarProdutoActivity extends AppCompatActivity {
Button buttonSalvarProduto;
private ProdutoClient produtoClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);
        buttonSalvarProduto = findViewById(R.id.buttonSalvarProduto);
        produtoClient = ApiUtils.getProdutoClient();
        Produto produto = new Produto("Dell Latitude 3", "10.00","1200.00");

        buttonSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produtoClient.saveProduto("Dell Latitude 3", "10.00","1200.00").enqueue(new Callback<Produto>() {
                    @Override
                    public void onResponse(Call<Produto> call, Response<Produto> response) {
                        if(response.isSuccessful()){
                            Log.d("Responde",response.body().toString());
                            Toast.makeText(CadastrarProdutoActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Produto> call, Throwable t) {
                        Log.e("Responde error", "Unable to submit post to API.");
                    }
                });
            }
        });

    }
}