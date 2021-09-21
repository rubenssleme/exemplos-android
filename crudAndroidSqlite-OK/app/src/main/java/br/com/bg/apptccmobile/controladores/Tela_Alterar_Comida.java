package br.com.bg.apptccmobile.controladores;

import android.view.View.OnClickListener;
import br.com.bg.apptccmobile.R;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.com.bg.apptccmobile.dominio.Comida;
import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Alterar_Comida extends Tela_Base {
    //Declaração dos campos
    private ListView gvacComida;
    private EditText txtacNome;
    private EditText txtacCodigo;
    private EditText txtacQuantidade;
    private Button btnacAlterar;
    private TextView lblacVoltar;
    private EditText txtacdescricao;
    private Button btnacconsultar;

    private TextView lblacIrParaTelaDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__alterar__comida);
        inicializar();
        inicializarAlterar();
        configurarBotao();
        configurarAlterar();
        //Identificação dos campos


        //chamando tela pela label
        lblacVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Alterar_Comida.this,Tela_Cadastrar_Comida.class);
                startActivity(it);
            }
        });
        lblacIrParaTelaDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Alterar_Comida.this,Tela_Deletar_Comida.class);
                startActivity(it);
            }
        });
        btnacconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvacComida.setAdapter(new ArrayAdapter<Comida>(Tela_Alterar_Comida.this,
                        android.R.layout.simple_list_item_1, repositorioComida.obterTodos()));
                gvacComida = (ListView) findViewById(R.id.gvabBebida);
                btnacAlterar = (Button) findViewById(R.id.btnacAlterar);



            }
        });

    }
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtacCodigo).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um código valido");
            sucesso = false;
        } else if (obterTexto(txtacNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtacQuantidade).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um Quantidade valido");
            sucesso = false;
        } else if (obterTexto(txtacdescricao).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um Descrição valido");
            sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }

    private void inicializarAlterar() {
        gvacComida = (ListView) findViewById(R.id.gvacComida);
        txtacNome = (EditText) findViewById(R.id.txtacNome);
        txtacCodigo= (EditText) findViewById(R.id.txtacCodigo);
        txtacQuantidade = (EditText) findViewById(R.id.txtacQuantidade);
        btnacAlterar = (Button) findViewById(R.id.btnacAlterar);
        lblacVoltar = (TextView) findViewById(R.id.lblacVoltar);
        lblacIrParaTelaDeletar= (TextView) findViewById(R.id.lblacIrParaTelaDeletar);
        txtacdescricao = (EditText) findViewById(R.id.txtccDescricao);
        btnacconsultar = (Button) findViewById(R.id.btnacconsultar);
    }
    private void configurarAlterar() {
        btnacAlterar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {
                    String id = obterTexto(txtacCodigo);
                    String nome = obterTexto(txtacNome);
                    String quantidade = obterTexto(txtacQuantidade);
                    String descricao = obterTexto(txtacdescricao);

                    if (repositorioComida.atualizarComida(new Comida(Long.parseLong(id), nome, quantidade, descricao))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Comida " + id + " alterado com sucesso.");

                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao alterar comida com ID " + id);
                    }
                }
            }
        });
    }

    //listview

    private void inicializar() {
        gvacComida = (ListView) findViewById(R.id.gvacComida);
        txtacNome = (EditText) findViewById(R.id.txtacNome);
        txtacCodigo= (EditText) findViewById(R.id.txtacCodigo);
        txtacQuantidade = (EditText) findViewById(R.id.txtacQuantidade);
        btnacAlterar = (Button) findViewById(R.id.btnacAlterar);
        lblacVoltar = (TextView) findViewById(R.id.lblacVoltar);
        lblacIrParaTelaDeletar= (TextView) findViewById(R.id.lblacIrParaTelaDeletar);
        txtacdescricao = (EditText) findViewById(R.id.txtccDescricao);
        btnacconsultar = (Button) findViewById(R.id.btnacconsultar);


    }

    private void configurarBotao() {
        btnacconsultar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarComidas();
            }
        });
    }
    private void carregarComidas() {
        gvacComida.setAdapter(new ArrayAdapter<Comida>(Tela_Alterar_Comida.this,
                android.R.layout.simple_list_item_1, repositorioComida.obterTodos()));
    }

}
