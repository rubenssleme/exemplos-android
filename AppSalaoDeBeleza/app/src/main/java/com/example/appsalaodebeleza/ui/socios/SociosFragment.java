package com.example.appsalaodebeleza.ui.socios;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appsalaodebeleza.ClienteDAO;
import com.example.appsalaodebeleza.ClienteDTO;
import com.example.appsalaodebeleza.R;
import com.example.appsalaodebeleza.ui.home.HomeViewModel;

public class SociosFragment extends Fragment {


    private SociosViewModel homeViewModel;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(SociosViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_socios, container, false);
        final TextView textView = root.findViewById(R.id.textViewSocios);



        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText("Hoje é so caros Alunos!");

            }
        });
        return root;
    }
}

