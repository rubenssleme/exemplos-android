package com.example.consumoapiproduto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.RecyclerViewHolder> {

    private Context context;
    protected RecyclerView recyclerView;
    protected List<Produto> list;

    public ProdutoAdapter(Context context, RecyclerView recyclerView, List<Produto> list) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.list = list;
        recyclerView.setAdapter(this);
    }

    @NonNull
    @Override
    public ProdutoAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.card_produto, parent, false);
        return new RecyclerViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoAdapter.RecyclerViewHolder holder, int position) {
        Produto produto = list.get(position);
        holder.preencheValores(produto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<Produto> list) {
        this.list.clear();
        if (list != null) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends ViewHolder {

        private TextView textNomeProduto;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
        }

        public void preencheValores(Produto produto) {
            textNomeProduto.setText(produto.getNome());
        }
    }
}
