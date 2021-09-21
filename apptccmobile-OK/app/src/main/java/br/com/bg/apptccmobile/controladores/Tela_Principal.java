package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;

import android.widget.*;
import android.view.View;
import android.content.*;

import br.com.bg.apptccmobile.R;

public class Tela_Principal extends Tela_Base {
    //decalração dos campos

    private EditText txtpUsuario;
    private EditText txtpSenha;
    private Button btnpEntrar;
    private TextView lblpFazerCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__principal);

        //identificação dos campos

        txtpUsuario = (EditText) findViewById(R.id.txtpUsuario);
        txtpSenha = (EditText) findViewById(R.id.txtpSenha);
        btnpEntrar = (Button) findViewById(R.id.btnpEntrar);
        lblpFazerCadastro = (TextView) findViewById(R.id.lblpFazerCadastro);


        //fazendo o login pelo button
        btnpEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if
                        (txtpUsuario.getText().toString().equals("a") &&
                        txtpSenha.getText().toString().equals("a")) {
                    Toast.makeText(getApplicationContext(), "Bem-Vindo", Toast.LENGTH_SHORT).show();
                //setContentView(R.layout.Menu_Drawer);

                Intent it = new Intent(Tela_Principal.this, Menu_Drawer.class);
                startActivity(it);
            } else {
                Toast.makeText(getApplicationContext(), "Usuário ou Senha Errados", Toast.LENGTH_SHORT).show();

                }

        }});

        //chamando tela pela label
        lblpFazerCadastro.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent it =new Intent(Tela_Principal.this,Tela_Cadastrar_Usuario.class);
                startActivity(it);
            }
        });
    }
}
