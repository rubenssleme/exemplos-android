package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;

import android.view.View;
import android.content.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Comida;

import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Cadastrar_Comida extends Tela_Base {
    //declaração dos campos

    private ListView gvccComida;
    private EditText txtccNome;
    private EditText txtccQuantidade;

    private Button btnccCadastrar;
    private Button btnccConsultar;
    private TextView lblccVoltar;
    private TextView lblccAlterar;
    private TextView lblccDeletar;
    private  EditText txtccDescricao;

   // Comida comida = new Comida();
    //RepositorioComida repositorioComida = new RepositorioComida(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastrar__comida);

        inicializar();
        inicializarList();
        configurarBotao();
        configurarCadastro();

        //Identificação dos campos


        //chamadas das telas pelas label
        lblccVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it =new  Intent (Tela_Cadastrar_Comida.this, Menu_Drawer.class);
                startActivity(it);
            }
        });

        lblccAlterar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it =new  Intent (Tela_Cadastrar_Comida.this, Tela_Alterar_Comida.class);
                startActivity(it);
            }
        });

        lblccDeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it =new  Intent (Tela_Cadastrar_Comida.this, Tela_Deletar_Comida.class);
                startActivity(it);
            }
        });


    }
    public void inicializar () {
        txtccNome = (EditText) findViewById(R.id.txtccNome);
        btnccConsultar = (Button) findViewById(R.id.btnccConsultar);
        txtccQuantidade = (EditText) findViewById(R.id.txtccQuantidade);
        btnccCadastrar = (Button) findViewById(R.id.btnccCadastrar);
        lblccAlterar = (TextView) findViewById(R.id.lblccAlterar);
        lblccDeletar = (TextView) findViewById(R.id.lblccDeletar);
        lblccVoltar = (TextView) findViewById(R.id.lblccVoltar);
        gvccComida = (ListView) findViewById(R.id.gvccComida);
        txtccDescricao = (EditText) findViewById(R.id.txtccDescricao);


    }


        //cadastrar
    private void configurarCadastro() {
        btnccCadastrar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {

                    String nome = obterTexto(txtccNome);
                    String quantidade = obterTexto(txtccQuantidade);
                    String descricao = obterTexto (txtccDescricao);


                    if (repositorioComida.salvarComida(new Comida(nome, quantidade, descricao))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Comida cadastrada com sucesso");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao cadastrar convidado");
                    }
                }
            }
        });
    }

    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtccNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtccQuantidade).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma quantidade valido");
            sucesso = false;
        } else if (obterTexto(txtccDescricao).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma descrição valida");
            sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }

    //list view
    private void inicializarList() {

        txtccNome = (EditText) findViewById(R.id.txtccNome);
        btnccConsultar = (Button) findViewById(R.id.btnccConsultar);
        txtccQuantidade = (EditText) findViewById(R.id.txtccQuantidade);
        btnccCadastrar = (Button) findViewById(R.id.btnccCadastrar);
        lblccAlterar = (TextView) findViewById(R.id.lblccAlterar);
        lblccDeletar = (TextView) findViewById(R.id.lblccDeletar);
        lblccVoltar = (TextView) findViewById(R.id.lblccVoltar);
        gvccComida = (ListView) findViewById(R.id.gvccComida);
        txtccDescricao = (EditText) findViewById(R.id.txtccDescricao);
    }

    private void configurarBotao() {
        btnccConsultar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarComida();
            }
        });
    }
    private void carregarComida() {
        gvccComida.setAdapter(new ArrayAdapter<Comida>(Tela_Cadastrar_Comida.this,
                android.R.layout.simple_list_item_1, repositorioComida.obterTodos()));
    }
}
