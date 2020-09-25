package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.*;
import android.view.View;
import android.content.*;

import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Convidado;
import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Deletar_Convidado extends Tela_Base {
    //declaração dos campos
    private ListView gvdconviConvidado;
    private EditText txtdconviCodigo;
    private Button btndconviDeletar;
    private TextView lbldconviVoltar;
    private Button btndconviConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__deletar__convidado);

        inicializar();
        configurarBotao();
        configurarDelete();


        //chamando tela pela label
        lbldconviVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela_Deletar_Convidado.this,Menu_Drawer.class);
                startActivity(it);

            }
        });

        btndconviConsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                gvdconviConvidado.setAdapter(new ArrayAdapter<Convidado>(Tela_Deletar_Convidado.this,
                        android.R.layout.simple_list_item_1, repositorioConvidado.obterTodos()));
                gvdconviConvidado = (ListView) findViewById(R.id.gvaconviConvidado);
                btndconviConsultar = (Button) findViewById(R.id.btnConsultar);
                inicializar();
                configurarBotao();


            }
        });

    }
    //inicializar list
    public void  inicializar (){
        //identificação dos campos
        gvdconviConvidado =(ListView) findViewById(R.id.gvdconviConvidado);
        txtdconviCodigo = (EditText) findViewById(R.id.txtdconviCodigo);
        btndconviDeletar = (Button) findViewById(R.id.btndconviDeletar);
        lbldconviVoltar = (TextView) findViewById(R.id.lbldconviVoltar);
        btndconviConsultar = (Button) findViewById(R.id.btndconviConsultar);

    }
        //configuraçao da list
    private void configurarBotao() {
        btndconviConsultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarConvidados();
            }
        });
    }
    //list final
    private void carregarConvidados() {
        gvdconviConvidado.setAdapter(new ArrayAdapter<Convidado>(Tela_Deletar_Convidado.this,
                android.R.layout.simple_list_item_1, repositorioConvidado.obterTodos()));
    }

    //botao deletar
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtdconviCodigo).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um ID valido");
            sucesso = false;
        } else {
            sucesso = true;
        }

        return sucesso;
    }


    //configuração de deletar

    private void configurarDelete() {
        btndconviDeletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (validarObrigatoriedadeCampos()) {
                    if (repositorioConvidado.excluirConvidado(Long.parseLong(obterTexto(txtdconviCodigo)))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Cliente excluido com sucesso.");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao excluir cliente.");
                    }
                }
            }
        });

    }




}
