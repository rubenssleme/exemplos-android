package br.com.bg.apptccmobile.controladores;


import br.com.bg.apptccmobile.R;

import br.com.bg.apptccmobile.dominio.Convidado2;
import br.com.bg.apptccmobile.utilitario.Mensagem;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.content.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class    Tela_Teste extends Tela_Base {

    //Declaração dos campos

    private EditText txtcconviNome2;
    private EditText txtcconviEmail2;
    private EditText txtcconviTelefone2;
    private EditText txtcconviIdade2;
    private TextView lblcconviGerenciarConvidado2;
    private Button btncconviCadastrar2;
    private Button btncconviVoltar2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastrar__convidado);
        inicializar2();
        configurarBotao2();


        //chamando tela pela label/button

        lblcconviGerenciarConvidado2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Teste.this, Tela_Alterar_Deletar_Convidado.class);
                startActivity(it);
            }
        });

        btncconviVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Teste.this, Menu_Drawer.class);
                startActivity(it);
            }
        });
    }

    public void inicializar2 () {
        txtcconviEmail2 = (EditText) findViewById(R.id.txtcconviEmail2);
        txtcconviIdade2 = (EditText) findViewById(R.id.txtcconviIdade2);
        txtcconviNome2 = (EditText) findViewById(R.id.txtcconviNome2);
        txtcconviTelefone2 = (EditText) findViewById(R.id.txtcconviTelefone2);
        //lblcconviGerenciarConvidado2 = (TextView) findViewById(R.id.lblcconviGerenciarConvidado2);
        btncconviCadastrar2 = (Button) findViewById(R.id.btncconviCadastrar2);
        btncconviVoltar2 = (Button) findViewById(R.id.btncconviVoltar2);

    }



    private void configurarBotao2() {
        btncconviCadastrar2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {

                    String nome = obterTexto(txtcconviNome2);
                    String email = obterTexto(txtcconviEmail2);
                    String telefone = obterTexto (txtcconviTelefone2);
                    String idade = obterTexto (txtcconviIdade2);

                    if (repositorioConvidado2.salvarConvidado2(new Convidado2(nome, email, telefone, idade))) {
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

        if (obterTexto(txtcconviNome2).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtcconviEmail2).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um email valido");
            sucesso = false;
        } else if (obterTexto(txtcconviTelefone2).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um telefone valido");
            sucesso = false;
        }else if (obterTexto(txtcconviIdade2).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma idade valida");
            sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }




}

