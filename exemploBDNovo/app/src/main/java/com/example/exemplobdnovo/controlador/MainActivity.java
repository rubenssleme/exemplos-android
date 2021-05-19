package com.example.exemplobdnovo.controlador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exemplobdnovo.R;
import com.example.exemplobdnovo.dominio.Usuario;
import com.example.exemplobdnovo.utils.Mensagem;

public class MainActivity extends BaseActivity {
    Button buttonSalvar;
    EditText editTextNome, editTextLogin, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        editTextNome = findViewById(R.id.editTextNome);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextSenha = findViewById(R.id.editTextSenha);

        buttonSalvar = findViewById(R.id.buttonSalvarCadastro);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarObrigatoriedadeCampos()) {
                    // Gravação no banco de dados.
                    String login = editTextLogin.getText().toString();
                    String nome = editTextNome.getText().toString();
                    String senha = editTextSenha.getText().toString();
                    if (repositorioUsuario.salvarUsuario(new Usuario(login, nome, senha))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Usuario cadastrado com sucesso");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao cadastrar usuario");
                    }
                }

            }
        });

    }

    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(editTextNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(editTextLogin).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um login valido");
            sucesso = false;
        } else if (obterTexto(editTextSenha).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma senha valida");
            sucesso = false;
        } else {
            sucesso = true;
        }

        return sucesso;
    }
}