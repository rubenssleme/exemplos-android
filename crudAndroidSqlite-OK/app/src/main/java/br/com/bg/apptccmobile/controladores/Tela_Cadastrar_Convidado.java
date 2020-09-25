package br.com.bg.apptccmobile.controladores;


import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Convidado;
import br.com.bg.apptccmobile.utilitario.Mensagem;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.content.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class    Tela_Cadastrar_Convidado extends Tela_Base {

    //Declaração dos campos

    private EditText txtcconviNome;
    private EditText txtcconviEmail;
    private EditText txtcconviTelefone;
    private EditText txtcconviIdade;
    private TextView lblcconviGerenciarConvidado;
    private Button btncconviCadastrar;
    private Button btncconviVoltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastrar__convidado);
        inicializar();
        configurarBotao();


        //chamando tela pela label/button

        lblcconviGerenciarConvidado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Cadastrar_Convidado.this, Tela_Alterar_Deletar_Convidado.class);
                startActivity(it);
            }
        });

        btncconviVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Cadastrar_Convidado.this, Menu_Drawer.class);
                startActivity(it);
            }
        });
    }

    public void inicializar () {
        txtcconviEmail = (EditText) findViewById(R.id.txtcconviEmail);
        txtcconviIdade = (EditText) findViewById(R.id.txtcconviIdade);
        txtcconviNome = (EditText) findViewById(R.id.txtcconviNome);
        txtcconviTelefone = (EditText) findViewById(R.id.txtcconviTelefone);
        lblcconviGerenciarConvidado = (TextView) findViewById(R.id.lblcconviGerenciarConvidado);
        btncconviCadastrar = (Button) findViewById(R.id.btncconviCadastrar);
        btncconviVoltar = (Button) findViewById(R.id.btncconviVoltar);

    }



        private void configurarBotao() {
            btncconviCadastrar.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (validarObrigatoriedadeCampos()) {

                        String nome = obterTexto(txtcconviNome);
                        String email = obterTexto(txtcconviEmail);
                        String telefone = obterTexto (txtcconviTelefone);
                        String idade = obterTexto (txtcconviIdade);

                        if (repositorioConvidado.salvarConvidado(new Convidado(nome, email, telefone, idade))) {
                            Mensagem.exibirMensagem(getApplicationContext(), "Convidado cadastrado com sucesso");
                        } else {
                            Mensagem.exibirMensagem(getApplicationContext(), "Falha ao cadastrar convidado");
                        }
                    }
                }
            });
        }

    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtcconviNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtcconviEmail).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um email valido");
            sucesso = false;
        } else if (obterTexto(txtcconviTelefone).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um telefone valido");
            sucesso = false;
        }else if (obterTexto(txtcconviIdade).isEmpty()) {
                Mensagem.exibirMensagem(this, "Insira uma idade valida");
                sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }




}

