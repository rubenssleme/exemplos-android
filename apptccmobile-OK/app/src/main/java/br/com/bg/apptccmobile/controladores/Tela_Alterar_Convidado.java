package br.com.bg.apptccmobile.controladores;

import android.view.View.OnClickListener;
import br.com.bg.apptccmobile.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.content.*;
import android.widget.TextView;

import br.com.bg.apptccmobile.dominio.Convidado;


import br.com.bg.apptccmobile.utilitario.Mensagem;


public class Tela_Alterar_Convidado extends Tela_Base {
    //Declaração dos campos
    private ListView gvaconviConvidado;
    private EditText txtaconvNome;
    private  EditText txtaconvEmail;
    private EditText txtaconvCodigo;
    private EditText txtaconvIdade;
    private EditText txtaconvContato;
    private Button btnaconvAlterar;
    private TextView lblaconvVoltar;
    private Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__alterar__convidado);

        inicializar();
        inicializarAlterar();
        configurarBotao();
        configurarAlterar();

        lblaconvVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Alterar_Convidado.this, Menu_Drawer.class);
                startActivity(it);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvaconviConvidado.setAdapter(new ArrayAdapter<Convidado>(Tela_Alterar_Convidado.this,
                        android.R.layout.simple_list_item_1, repositorioConvidado.obterTodos()));
                gvaconviConvidado = (ListView) findViewById(R.id.gvaconviConvidado);
                btnConsultar = (Button) findViewById(R.id.btnConsultar);
                inicializar();
                configurarBotao();


            }
        });

    }
        private boolean validarObrigatoriedadeCampos() {
            boolean sucesso = false;

            if (obterTexto(txtaconvCodigo).isEmpty()) {
                Mensagem.exibirMensagem(this, "Insira um código valido");
                sucesso = false;
            } else if (obterTexto(txtaconvNome).isEmpty()) {
                Mensagem.exibirMensagem(this, "Insira um nome valido");
                sucesso = false;
            } else if (obterTexto(txtaconvEmail).isEmpty()) {
                Mensagem.exibirMensagem(this, "Insira um email valido");
                sucesso = false;
            } else if (obterTexto(txtaconvContato).isEmpty()) {
                Mensagem.exibirMensagem(this, "Insira um telefone valido");
                sucesso = false;
            }  else if (obterTexto(txtaconvIdade).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma idade valida");
            sucesso = false;
            }else {
                sucesso = true;
            }

            return sucesso;
        }

//alterar
    private void inicializarAlterar() {
        txtaconvCodigo = (EditText) findViewById(R.id.txtdconviCodigo);
        txtaconvIdade = (EditText) findViewById(R.id.txtaconvIdade);
        txtaconvNome = (EditText) findViewById(R.id.txtaconvNome);
        txtaconvEmail = (EditText) findViewById(R.id.txtaconvEmail);
        txtaconvContato = (EditText) findViewById(R.id.txtaconvContato);
        btnaconvAlterar = (Button) findViewById(R.id.btnaconvAlterar);
        gvaconviConvidado =(ListView) findViewById(R.id.gvaconviConvidado);
    }

    private void configurarAlterar() {
        btnaconvAlterar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {
                    String id = obterTexto(txtaconvCodigo);
                    String nome = obterTexto(txtaconvNome);
                    String email = obterTexto(txtaconvEmail);
                    String telefone = obterTexto(txtaconvContato);
                    String idade = obterTexto(txtaconvIdade);


                    if (repositorioConvidado.atualizarConvidado(new Convidado(Long.parseLong(id), nome, email, telefone, idade))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Convidado " + id + " alterado com sucesso.");

                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao alterar cliente com ID " + id);
                    }
                }
            }
        });
    }







//list view
    private void inicializar() {

        gvaconviConvidado = (ListView) findViewById(R.id.gvaconviConvidado);
        txtaconvCodigo = (EditText) findViewById(R.id.txtaconvCodigo);
        txtaconvEmail = (EditText) findViewById(R.id.txtaconvEmail);
        txtaconvIdade = (EditText) findViewById(R.id.txtaconvIdade);
        txtaconvContato = (EditText) findViewById(R.id.txtaconvContato);
        btnaconvAlterar = (Button) findViewById(R.id.btnaconvAlterar);
        lblaconvVoltar = (TextView) findViewById(R.id.lblaconvVoltar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
    }

    private void configurarBotao() {
        btnConsultar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarConvidados();
            }
        });
    }
    private void carregarConvidados() {
        gvaconviConvidado.setAdapter(new ArrayAdapter<Convidado>(Tela_Alterar_Convidado.this,
                android.R.layout.simple_list_item_1, repositorioConvidado.obterTodos()));
    }
}
