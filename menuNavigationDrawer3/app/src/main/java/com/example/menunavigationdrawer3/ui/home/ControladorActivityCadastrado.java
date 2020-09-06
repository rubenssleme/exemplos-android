package com.example.menunavigationdrawer3.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menunavigationdrawer3.R;

public class ControladorActivityCadastrado extends Fragment {


    public void onCreate(@NonNull LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.activity_cadastrado, container, false);
    }
}