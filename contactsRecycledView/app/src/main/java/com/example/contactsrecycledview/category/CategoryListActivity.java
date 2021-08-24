package com.example.contactsrecycledview.category;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsrecycledview.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity  implements CategoriesAdapter.OnCategoryListener {

    private RecyclerView rcListaCategoria;
    private ArrayList<CategoryListActivity> mNotes = new ArrayList<CategoryListActivity>();
    private List<Category> listaCategoria = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Lookup the recyclerview in activity layout
        RecyclerView rcListaCategoria = (RecyclerView) findViewById(R.id.rcListaCategoria);

        //config rc
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rcListaCategoria.setLayoutManager(layoutManager);

        //configura adapter
        this.ListagemCategoria();
        CategoriesAdapter adapter = new CategoriesAdapter(listaCategoria,this);
        rcListaCategoria.setAdapter(adapter);



        //rcListaCategoria.setHasFixedSize(true);
        rcListaCategoria.setAdapter(adapter);
    }


    public void ListagemCategoria(){
        Category c = new Category("Vegetais", R.drawable.img_product_7);
        this.listaCategoria.add(c);

        c = new Category("Limpeza", R.drawable.limpeza);
        this.listaCategoria.add(c);

        c = new Category("Cereais", R.drawable.cereais);
        this.listaCategoria.add(c);

        c = new Category("Chocolate", R.drawable.chocolate);
        this.listaCategoria.add(c);
        c = new Category("Carnes",R.drawable.limpeza);
        this.listaCategoria.add(c);
    }

    @Override
    public void onCategoryClick(int position) {
       // Intent intent = new Intent(this.getApplicationContext(), DetalhesProdutoActivity.class);
       // intent.putExtra("selected_note", mNotes.get(position));
       // startActivity(intent);
        Toast.makeText(getApplicationContext(), "Teste", Toast.LENGTH_SHORT).show();
    }
}