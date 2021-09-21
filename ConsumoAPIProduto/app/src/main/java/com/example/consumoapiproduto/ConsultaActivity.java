package com.example.consumoapiproduto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConsultaActivity extends AppCompatActivity {
    private TextView tvData;
    Button buttonBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        tvData = findViewById(R.id.textView);
        buttonBuscar = findViewById(R.id.buttonConsultarProduto);
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Produto>> call = new RetrofitConfig().getProdutoService().buscarProdutos();
                call.enqueue(new Callback<List<Produto>>() {
                    @Override
                    public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                        List<Produto> produto = response.body();
                        tvData.setText(produto.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Produto>> call, Throwable t) {
                        Log.e("CEPService   ", "Erro ao buscar o cep:" + t.getMessage());
                    }

                });


            }
        });

    }
}