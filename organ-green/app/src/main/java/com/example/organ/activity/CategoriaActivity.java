package com.example.organ.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.organ.R;
import com.example.organ.model.Categoria;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoriaActivity extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private Button btnGravarCategoria;
    private EditText editTextCategoria;
    private EditText editTextIMG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        rootNode = FirebaseDatabase.getInstance();//A instancia atual do banco de dados
        reference = rootNode.getReference("categoria");
        editTextCategoria = findViewById(R.id.editTextNomeCategoria);
        editTextIMG = findViewById(R.id.editTextCategoriaIMG);
        btnGravarCategoria = findViewById(R.id.buttonSalvarCategoria);
        btnGravarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravarCategoria(new Categoria());
            }
        });

        }



    private void gravarCategoria(Categoria categoria){
            categoria.setNomeCategoria(editTextCategoria.getText().toString());
            categoria.setImgProdutoCategoria(Integer.parseInt(editTextIMG.getText().toString()));
         reference.child(categoria.getId().toString()).setValue(categoria);
    }

}