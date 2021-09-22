package com.example.consumoapiproduto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class ConsultaActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProdutos;
    private ProdutoAdapter adapter;
    Button buttonBuscar;
    private ProdutoService produtoService = new ProdutoService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);
        adapter = new ProdutoAdapter(this, recyclerViewProdutos, new ArrayList<>());

        buttonBuscar = findViewById(R.id.buttonConsultarProduto);
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produtoService.buscarProdutos()
                        .subscribe(produtos -> {
                            adapter.updateData(produtos);
                        }, erro -> {
                            Log.e("CEPService   ", "Erro ao buscar o cep:" + erro.getMessage());
                        });
            }
        });

    }
}