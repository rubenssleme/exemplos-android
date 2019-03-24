package com.projetos.mobiletechlawer.controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.controladores.navigator.Principal;
import com.projetos.mobiletechlawer.dominios.Login;

public class ControladorTelaLogin extends AppCompatActivity{

    private EditText edt_usuario;
    private EditText edt_senha;
    private Button btn_login;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        edt_usuario = (EditText) findViewById(R.id.edt_usuario);
        edt_senha = (EditText) findViewById(R.id.edt_senha);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                   // if (verificarCampos()){
                        String usuario = edt_usuario.getText().toString();
                        String senha = edt_senha.getText().toString();
                        try {
                           // Login.find(Login.class, "usuario =?, senha =?", usuario, senha).get(0);
                            Toast.makeText(getApplicationContext(), "Usuario Logado com Sucesso!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ControladorTelaLogin.this, Principal.class));
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "Informe um Usuario ou senha Validos!", Toast.LENGTH_SHORT).show();
                        }
                    //}
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro no Login!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public Boolean verificarCampos(){
        Boolean sucesso;

        if (edt_usuario.getText().toString().isEmpty()){
            Toast.makeText(this, "Informe um Usuario!", Toast.LENGTH_SHORT).show();
            sucesso = false;
        }else if (edt_senha.getText().toString().isEmpty()){
            Toast.makeText(this, "Informe uma Senha!", Toast.LENGTH_SHORT).show();
            sucesso = false;
        }else{
            sucesso = true;
        }
        return sucesso;
    }


}
