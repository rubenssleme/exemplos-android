package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;
import android.view.View.OnClickListener;



import android.view.View;
import android.content.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.bg.apptccmobile.R;

import br.com.bg.apptccmobile.dominio.Usuario;
import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Cadastrar_Usuario extends Tela_Base {

    //declaração dos campos
    private EditText txtcuNome;
    private EditText txtcuUsuario;
    private EditText txtcuSenha;
    private Button btncuCadastrar;
    private TextView lblcuVoltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastrar__usuario);
        inicializarUsuario();
        configurarCadastroUsuario();




        //chamando tela pela label
        lblcuVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(Tela_Cadastrar_Usuario.this,Tela_Principal.class);
                startActivity(it);

            }
        });
    }

    public void inicializarUsuario () {
        txtcuNome = (EditText) findViewById(R.id.txtcuNome);
        txtcuSenha =(EditText) findViewById(R.id.txtcuSenha);
        txtcuUsuario = (EditText) findViewById(R.id.txtcuUsuario);
        btncuCadastrar = (Button) findViewById(R.id.btncuCadastrar);
        lblcuVoltar = (TextView) findViewById(R.id.lblcuVoltar);

    }

    private void configurarCadastroUsuario() {
        btncuCadastrar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {

                    String nome = obterTexto(txtcuNome);
                    String usuario = obterTexto(txtcuUsuario);
                    String senha = obterTexto (txtcuSenha);


                    if (repositorioUsuario.salvarUsuario(new Usuario(nome, usuario, senha))) {
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

        if (obterTexto(txtcuNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtcuUsuario).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um usuario valido");
            sucesso = false;
        } else if (obterTexto(txtcuSenha).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma senha valida");
            sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }



}
