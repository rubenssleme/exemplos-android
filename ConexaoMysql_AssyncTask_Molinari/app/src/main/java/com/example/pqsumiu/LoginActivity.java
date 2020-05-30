package com.example.pqsumiu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsuario, editTextSenha;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //FAZ COM QUE SEJA PERMITIDO ACESSO À INTERNET NA THREAD PRINCIPAL
        //ISSO DEVE SER CONFIGURADO EM QUALQUER CLASSE, PORÉM DEVE SER ANTES DOS ACESSOS A INTERNET
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        buttonLogin = findViewById(R.id.buttonLogin);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextUsuario = findViewById(R.id.editTextUsuario);

        //conectar task
        ConnectionTask connectionTask = new ConnectionTask();
        connectionTask.execute();


        habilitaDesabilitaBotao();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoUsuario daoUsuario = new DaoUsuario();
                String usuario = editTextUsuario.getText().toString();
                String senha = editTextSenha.getText().toString();
                try {
                    boolean sucesso = daoUsuario.login(usuario,senha);
                    if(sucesso){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "incorreto", Toast.LENGTH_SHORT).show();
                    }

                } catch (SQLException e) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(LoginActivity.this);
                    msg.setMessage("Erro: " + e.toString()).show();
                }
            }
        });

    }

    private void guardaConexao(Connection connection) {
        FabricaConexao.connection = connection;
    }

    private Connection conectar() {
        FabricaConexao.conectar();
        return FabricaConexao.connection;
    }

    private void habilitaDesabilitaBotao() {
        editTextSenha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                verificaVazios();
            }
        });

        editTextUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                verificaVazios();
            }
        });
    }

    private void verificaVazios() {
        String senha = editTextSenha.getText().toString();
        String usuario = editTextUsuario.getText().toString();

        if(senha.equals("")|| usuario.equals("")){
            buttonLogin.setEnabled(false);
        }
        else{
            buttonLogin.setEnabled(true);
        }
    }

    private class ConnectionTask extends AsyncTask<String, Integer, Connection> {
        private final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
        Connection connection;

        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Conectando ao servidor...");
            this.dialog.setIndeterminate(true) ;
            this.dialog.setCancelable(false);
            this.dialog.show();
        }


        @Override
        protected Connection doInBackground(String... params) {
            return conectar();
        }


        @Override
        protected void onPostExecute(Connection connection) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();

            }
            guardaConexao(connection);
        }

    }
}




