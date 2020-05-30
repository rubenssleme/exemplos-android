package com.aprendaefaca.appfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ControladorTelaFirebase extends AppCompatActivity {

    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_firebase);

        firebaseReferencia.child("pontos").setValue("200");
    }
}
