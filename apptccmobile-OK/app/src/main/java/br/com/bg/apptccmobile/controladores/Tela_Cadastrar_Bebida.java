package br.com.bg.apptccmobile.controladores;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Bebida;
import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Cadastrar_Bebida extends Tela_Base {
    //declaração dos campos

    private ListView gvcbBebida;
    private EditText txtcbNome;
    private EditText txtcbQuantidade;
    private RadioButton rdbcbAlcoolica;
    private RadioButton rdbcbNormal;
    private Button btncbCadastrar;
    private TextView lblcbVoltar;
    private TextView lblcbAlterar;
    private TextView lblcbDeletar;
    private Button btncbConsultar;
    private EditText txtcbDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastrar__bebida);
        inicializar();
        inicializarList();
        configurarCadastro();
        configurarBotao();



        //chamando tela pela label
        lblcbVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Cadastrar_Bebida.this,Menu_Drawer.class);
                startActivity(it);
            }
        });

        lblcbAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Cadastrar_Bebida.this,Tela_Alterar_Bebida.class);
                startActivity(it);
            }
        });

        lblcbDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Cadastrar_Bebida.this,Tela_Deletar_Bebida.class);
                startActivity(it);
            }
        });

    }

    public void inicializar () {
        gvcbBebida = (ListView) findViewById(R.id.gvcbBebida);
        btncbCadastrar = (Button) findViewById(R.id.btncbCadastrar);
        txtcbNome = (EditText) findViewById(R.id.txtcbNome);
        txtcbQuantidade = (EditText) findViewById(R.id.txtcbQuantidade);
        btncbConsultar = (Button) findViewById(R.id.btncbConsultar);
        lblcbAlterar = (TextView) findViewById(R.id.lblcbAlterar);
        lblcbVoltar = (TextView) findViewById(R.id.lblcbVoltar);
        lblcbDeletar = (TextView) findViewById(R.id.lblcbDeletar);


    }

    //cadastrar
    private void configurarCadastro() {
        btncbCadastrar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              //  if (validarObrigatoriedadeCampos()) {

                    String nome = obterTexto(txtcbNome);
                    String quantidade = obterTexto(txtcbQuantidade);
                    String descricao = obterTexto (txtcbDescricao);


                    if (repositorioBebida.salvarBebida(new Bebida(nome, quantidade, descricao))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Bebida cadastrada com sucesso");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao cadastrar bebida");
                    }
                }
            //}
        });
    }
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtcbNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtcbQuantidade).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma quantidade valido");
            sucesso = false;
        } else if (obterTexto(txtcbDescricao).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma descrição valida");
            sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }

    //list view
    private void inicializarList() {

        gvcbBebida = (ListView) findViewById(R.id.gvcbBebida);
        btncbCadastrar = (Button) findViewById(R.id.btncbCadastrar);
        txtcbNome = (EditText) findViewById(R.id.txtcbNome);
        txtcbQuantidade = (EditText) findViewById(R.id.txtcbQuantidade);
        btncbConsultar = (Button) findViewById(R.id.btncbConsultar);
        lblcbAlterar = (TextView) findViewById(R.id.lblcbAlterar);
        lblcbVoltar = (TextView) findViewById(R.id.lblcbVoltar);
        lblcbDeletar = (TextView) findViewById(R.id.lblcbDeletar);
    }

    private void configurarBotao() {
        btncbConsultar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarBebida();
            }
        });
    }
    private void carregarBebida() {
     //   gvcbBebida.setAdapter(new ArrayAdapter<Bebida>(Tela_Cadastrar_Bebida.this,
           //     android.R.layout.simple_list_item_1, repositorioBebida.obterTodos()));
    }

}
