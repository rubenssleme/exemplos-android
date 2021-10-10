package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase.config.User;
import com.example.firebase.model.Categoria;
import com.example.firebase.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    private Button btnGravarUsuario;

    private EditText editTextCPF;
    private EditText editTextAniversario;
        private EditText editTextNome;
        private EditText editTextSobrenome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnGravarUsuario = findViewById(R.id.buttonGravarUsuario);
        editTextCPF = findViewById(R.id.editTextCPF);
        editTextAniversario = findViewById(R.id.editTextAniversario);
        editTextNome = findViewById(R.id.editTextNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);

        rootNode = FirebaseDatabase.getInstance();//A instancia atual do banco de dados
        reference = rootNode.getReference("Usuarios");

        btnGravarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(editTextCPF.getText().toString(), editTextAniversario.getText().toString(),
                        editTextNome.getText().toString(),editTextSobrenome.getText().toString() );
                reference.child(user.cpf).setValue(user);
                cadastrarCategoria();
            }
        });


    }
    public void cadastrarCategoria(){
        reference = rootNode.getReference("categoria");
        Categoria categoria = new Categoria("Verduras",1L);
        Categoria categoria2 = new Categoria("Frutas",2L);
        reference.child(categoria.getImgProdutoCategoria().toString()).setValue(categoria2);

    }

}