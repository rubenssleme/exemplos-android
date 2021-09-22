package com.example.organ.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.organ.R;
import com.example.organ.model.Categoria;

import java.util.List;

public class ListaCategoriaAdapter extends RecyclerView.Adapter<ListaCategoriaAdapter.MyViewHolder> {

    private List<Categoria> categorias;
    private static final String TAG = "ListaRecyclerAdapter";
    // Responsavel pelo evento de onclick
    private OnCategoryListener mOnCategoryListener;

    // Adicionar <OnCategoryListener onCategoryListener>
    public ListaCategoriaAdapter(List<Categoria> listaCategoria, OnCategoryListener onCategoryListener) {
        this.categorias = listaCategoria;
        this.mOnCategoryListener = onCategoryListener; // Chamar o objeto de onclick
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemListaCategoria = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_categoria, parent, false);
        //Adionar objeto mOnCategoryListener
        return new MyViewHolder(itemListaCategoria, mOnCategoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Categoria categoria = categorias.get(position);
        holder.nomeCategoria.setText(categoria.getNomeCategoria());
        holder.fotoCategoria.setImageResource(categoria.getImgProdutoCategoria());

    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }


    // implements View.OnClickListener
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView fotoCategoria;
        TextView nomeCategoria;
        //Adicionar mOnCategoryListener
        OnCategoryListener mOnCategoryListener;

        public MyViewHolder(View itemView, OnCategoryListener onCategoryListener) {
            super(itemView);

            fotoCategoria = itemView.findViewById(R.id.imgProdutoCategoria);
            nomeCategoria = itemView.findViewById(R.id.txtNomeCategoria);
            //Adicionar mOnCategoryListener
            mOnCategoryListener = onCategoryListener;
            itemView.setOnClickListener(this);
        }

        // Criar o Evento de onClick
        @Override
        public void onClick(View v) {
            mOnCategoryListener.onCategoryClick(getAdapterPosition());
        }
    }

    public interface OnCategoryListener {
        void onCategoryClick(int position);
    }

}
