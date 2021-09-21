package com.example.contactsrecycledview.category;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsrecycledview.R;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<Category> categorias;
    private static final String TAG = "ListaRecyclerAdapter";
    private OnCategoryListener  mOnCategoryListener;

    public CategoriesAdapter(List<Category> listaCategoria,OnCategoryListener onCategoryListener) {
        this.categorias = listaCategoria;
        this.mOnCategoryListener = onCategoryListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemListaCategoria = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_category, parent, false);

        return new ViewHolder(itemListaCategoria,mOnCategoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category categoria = categorias.get(position);
        holder.nomeCategoria.setText(categoria.getNomeCategoria());
        holder.fotoCategoria.setImageResource(categoria.getImgProdutoCategoria());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fotoCategoria;
        TextView nomeCategoria;
        OnCategoryListener mOnCategoryListener;
        public ViewHolder(View itemView, OnCategoryListener onCategoryListener) {
            super(itemView);



            fotoCategoria = itemView.findViewById(R.id.imgProdutoCategoria);
            nomeCategoria = itemView.findViewById(R.id.txtNomeCategoria);
            mOnCategoryListener = onCategoryListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnCategoryListener.onCategoryClick(getAdapterPosition());
        }
    }
    public interface OnCategoryListener {
        void onCategoryClick(int position);
    }
}
