package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Bebida;
import br.com.bg.apptccmobile.utilitario.Mensagem;


public class Tela_Alterar_Bebida extends Tela_Base {
    //Declaração dos campos

    private ListView gvabBebida;
    private EditText txtabCodigo;
    private EditText txtabNomeBebida;
    private EditText txtabQuantidade;
    private Button btnabAlterar;
    private TextView lblabVoltar;
    private TextView lblabIrParaTelaDeletar;
    private Button btnabconsultar;
    private EditText txtabdescricao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__alterar__bebida);
        inicializar();
        inicializarAlterar();
        configurarBotao();
        configurarAlterar();


        //chamando tela pela label
        lblabIrParaTelaDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Alterar_Bebida.this,Tela_Deletar_Bebida.class);
                startActivity(it);
            }
        });
        lblabVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Alterar_Bebida.this,Tela_Cadastrar_Bebida.class);
                startActivity(it);
            }
        });
        btnabconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvabBebida.setAdapter(new ArrayAdapter<Bebida>(Tela_Alterar_Bebida.this,
                        android.R.layout.simple_list_item_1, repositorioBebida.obterTodos()));
                gvabBebida = (ListView) findViewById(R.id.gvabBebida);
                btnabconsultar = (Button) findViewById(R.id.btnabconsultar);


            }
        });
    }
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtabCodigo).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um código valido");
            sucesso = false;
        } else if (obterTexto(txtabNomeBebida).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(txtabQuantidade).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um quantidade valido");
            sucesso = false;
        } else if (obterTexto(txtabdescricao).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma descrição valida");
            sucesso = false;

        }else {
            sucesso = true;
        }

        return sucesso;
    }
    private void inicializarAlterar() {
        //Identificação dos campos
        txtabCodigo = (EditText) findViewById(R.id.txtabCodigo);
        txtabNomeBebida = (EditText) findViewById(R.id.txtabNomeBebida);
        txtabQuantidade = (EditText) findViewById(R.id.txtabQuantidade);
        btnabAlterar = (Button) findViewById(R.id.btnabAlterar);
        btnabconsultar = (Button) findViewById(R.id.btnabconsultar);
        lblabVoltar = (TextView) findViewById(R.id.lblabVoltar);
        lblabIrParaTelaDeletar = (TextView) findViewById(R.id.lblabIrParaTelaDeletar);
        gvabBebida = (ListView) findViewById(R.id.gvabBebida);
        txtabdescricao = (EditText) findViewById(R.id.txtabdescricao);
    }

    private void configurarAlterar() {
        btnabAlterar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {
                    String id = obterTexto(txtabCodigo);
                    String nome = obterTexto(txtabNomeBebida);
                    String quantidade = obterTexto(txtabQuantidade);
                    String descricao = obterTexto(txtabdescricao);

                    if (repositorioBebida.atualizarBebida(new Bebida(Long.parseLong(id), nome, quantidade, descricao))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Bebida " + id + " alterado com sucesso.");

                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao alterar bebida com ID " + id);
                    }
                }
            }
        });
    }

    private void inicializar() {
        txtabCodigo = (EditText) findViewById(R.id.txtabCodigo);
        txtabNomeBebida = (EditText) findViewById(R.id.txtabNomeBebida);
        txtabQuantidade = (EditText) findViewById(R.id.txtabQuantidade);
        btnabAlterar = (Button) findViewById(R.id.btnabAlterar);
        btnabconsultar = (Button) findViewById(R.id.btnabconsultar);
        lblabVoltar = (TextView) findViewById(R.id.lblabVoltar);
        lblabIrParaTelaDeletar = (TextView) findViewById(R.id.lblabIrParaTelaDeletar);
        gvabBebida = (ListView) findViewById(R.id.gvabBebida);
        txtabdescricao = (EditText) findViewById(R.id.txtabdescricao);
    }

    private void configurarBotao() {
        btnabconsultar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                carregarBebidas();
            }
        });
    }
    private void carregarBebidas() {
        gvabBebida.setAdapter(new ArrayAdapter<Bebida>(Tela_Alterar_Bebida.this,
                android.R.layout.simple_list_item_1, repositorioBebida.obterTodos()));
    }


}
