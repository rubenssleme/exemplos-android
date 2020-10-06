package com.example.appsalaodebeleza.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appsalaodebeleza.ClienteDAO;
import com.example.appsalaodebeleza.ClienteDTO;
import com.example.appsalaodebeleza.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    Button buttonNovoContato;
    ListView listViewContato;
    ArrayList<ClienteDTO> arrayListContato;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        
        buttonNovoContato = root.findViewById(R.id.buttonNovoCliente);
        listViewContato = root.findViewById(R.id.listViewClient);
        ClienteDAO daoContato = new ClienteDAO(getActivity().getApplicationContext());

        arrayListContato = daoContato.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,arrayListContato);

        listViewContato.setAdapter(adapter);


        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}