package com.example.pqsumiu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.sql.SQLException;

public class InserirActivity extends AppCompatActivity {
    EditText editTextNome, editTextEmail, editTextSenha, editTextConfirmarSenha;
    RadioButton radioButtonAdm, radioButtonFunc;
    Button buttonConfirmarInclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        editTextConfirmarSenha = findViewById(R.id.editTextConfirmaSenha);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextNome = findViewById(R.id.editTextNome);
        buttonConfirmarInclusao = findViewById(R.id.buttonConfirmarInclusao);
        radioButtonAdm = findViewById(R.id.radioButtonAdm);

        buttonConfirmarInclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();
                String confSenha = editTextConfirmarSenha.getText().toString();
                int nivel = (radioButtonAdm.isChecked())?1:2;

                if(nome.length()<4){
                    editTextNome.setError("O nome deve ter pelo menos 4 caracteres.");
                    editTextNome.setFocusable(true);
                    editTextNome.requestFocus();
                }
                else if(email.length()<8){
                    editTextEmail.setError("O email deve ter pelo menos 6 caracteres.");
                    editTextEmail.setFocusable(true);
                    editTextEmail.requestFocus();
                }
                else if(senha.length()<8){
                    editTextSenha.setError("A senha deve ter pelo menos 8 caracteres.");
                    editTextSenha.setFocusable(true);
                    editTextSenha.requestFocus();
                }
                else if(!senha.equals(confSenha))
                    Toast.makeText(InserirActivity.this, "Senhas não batem.", Toast.LENGTH_SHORT).show();
                else{
                    DtoUsuario dtoUsuario = new DtoUsuario(nivel,nome,email,senha);
                    DaoUsuario daoUsuario = new DaoUsuario();
                    try {
                        daoUsuario.inserir(dtoUsuario);
                        Toast.makeText(InserirActivity.this, "Inserido", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InserirActivity.this, MainActivity.class);
                        startActivity(intent);
                    } catch (SQLException e) {
                        AlertDialog.Builder msg = new AlertDialog.Builder(InserirActivity.this);
                        msg.setMessage("Deu ruim: " + e.toString()).show();
                    }
                }


            }
        });
    }
}


