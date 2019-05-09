package com.example.a3binfo.tccarctos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentAbertos extends Fragment {

    ListView listViewChamados;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //listViewChamados = (ListView)fin



        return inflater.inflate(R.layout.fragment_abertos,container,false);
    }
}
