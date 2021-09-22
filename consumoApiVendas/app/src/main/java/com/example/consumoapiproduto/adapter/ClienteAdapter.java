package com.example.consumoapiproduto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.consumoapiproduto.R;
import com.example.consumoapiproduto.dominio.Cliente;


import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.RecyclerViewHolder> {

    private Context context;
    protected RecyclerView recyclerView;
    protected List<Cliente> list;

    public ClienteAdapter(Context context, RecyclerView recyclerView, List<Cliente> list) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.list = list;
        recyclerView.setAdapter(this);
    }

    @NonNull
    @Override
    public ClienteAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.card_produto, parent, false);
        return new RecyclerViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.RecyclerViewHolder holder, int position) {
        Cliente cliente = list.get(position);
        holder.preencheValores(cliente);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<Cliente> list) {
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

        public void preencheValores(Cliente cliente) {
            textNomeProduto.setText(cliente.getNome());
        }
    }
}
