package com.example.appMobileBG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuario extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextEmail;
    EditText editTextTelefone;
    EditText editTextEndereco;
    Button buttonSalvar;
    Button buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        editTextNome = findViewById(R.id.editTextNomeContato);
        editTextEmail = findViewById(R.id.editTextEmailContato);
        editTextTelefone = findViewById(R.id.editTextTelefoneContato);
        editTextEndereco = findViewById(R.id.editTextEnderecoContato);
        buttonSalvar = findViewById(R.id.buttonSalvarContato);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UsuarioDTO dtoContato = new UsuarioDTO(editTextNome.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextTelefone.getText().toString(),
                        editTextEndereco.getText().toString());
               UsuarioDAO daoContato = new UsuarioDAO(getApplicationContext());
                try {
                    if (daoContato.inserir(dtoContato) > 0) {
                        Toast.makeText(CadastrarUsuario.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(CadastrarUsuario.this, "Erro ao Inserido: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}