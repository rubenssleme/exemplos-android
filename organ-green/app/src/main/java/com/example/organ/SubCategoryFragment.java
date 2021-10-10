package com.example.organ;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.organ.activity.DetalhesCenouraActivity;
import com.example.organ.activity.DetalhesChocolateActivity;
import com.example.organ.adapter.ListaCategoriaAdapter;
import com.example.organ.model.Categoria;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubCategoryFragment extends Fragment implements ListaCategoriaAdapter.OnCategoryListener {


    public SubCategoryFragment() {
        // Required empty public constructor
    }

    private RecyclerView rcListaCategoria;
    private ArrayList<SubCategoryFragment> mNotes = new ArrayList<SubCategoryFragment>();
    private List<Categoria> listaCategoria = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);

        //Config iniciais da listagem de categoria
        rcListaCategoria = view.findViewById(R.id.rcSubCategoria);

        //config rc
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcListaCategoria.setLayoutManager(layoutManager);

        //configura adapter
        this.ListagemCategoria();
        ListaCategoriaAdapter adapter = new ListaCategoriaAdapter(listaCategoria,this);
        rcListaCategoria.setAdapter(adapter);



        //rcListaCategoria.setHasFixedSize(true);
        rcListaCategoria.setAdapter(adapter);


            return view;
    }

    public void ListagemCategoria(){
        Categoria c =  new Categoria("Gatos",R.drawable.img_cat_gatos);
        this.listaCategoria.add(c);
        c = new Categoria("Cães",R.drawable.img_cat_cao);
        this.listaCategoria.add(c);

    }

    @Override
    public void onCategoryClick(int position) {
        int posicaoCategoria = position;

        switch (posicaoCategoria){
            case 0:
            Intent intent0 = new Intent(getActivity().getApplicationContext(), DetalhesCenouraActivity.class);
            startActivity(intent0);
            break;
            case 1:
                Intent intent1 = new Intent(getActivity().getApplicationContext(), DetalhesCenouraActivity.class);
            startActivity(intent1);
            break;
            case 2:
                Intent intent2 = new Intent(getActivity().getApplicationContext(), DetalhesCenouraActivity.class);
            startActivity(intent2);
            break;
            case 3:
                Intent intent3 = new Intent(getActivity().getApplicationContext(), DetalhesChocolateActivity.class);
            startActivity(intent3);
            break;
            case 4:
                Intent intent4 = new Intent(getActivity().getApplicationContext(), DetalhesCenouraActivity.class);
            startActivity(intent4);
            break;
            case 5:
                Intent intent5 = new Intent(getActivity().getApplicationContext(), DetalhesCenouraActivity.class);
                startActivity(intent5);
                break;
            default:
                Toast.makeText(getContext(), "Valor da categoria não encontrado"  , Toast.LENGTH_SHORT).show();
        }

    }
}
