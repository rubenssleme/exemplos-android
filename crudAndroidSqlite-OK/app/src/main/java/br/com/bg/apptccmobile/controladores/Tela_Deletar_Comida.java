package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.*;

import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Comida;
import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Deletar_Comida extends Tela_Base {
    //declaração dos campos

    private EditText txtdcCodigo;
    private TextView lbldcVoltar;
    private Button btndcDeletar;
    private ListView gvdcComida;
    private Button btndcconsultar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__deletar__comida);

        inicializar();
        configurarBotao();
        configurarDelete();


        //chamando tela pela label

        lbldcVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it = new Intent(Tela_Deletar_Comida.this, Menu_Drawer.class);
                startActivity(it);
            }
        });

        btndcconsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                gvdcComida.setAdapter(new ArrayAdapter<Comida>(Tela_Deletar_Comida.this,
                        android.R.layout.simple_list_item_1, repositorioComida.obterTodos()));
                gvdcComida = (ListView) findViewById(R.id.gvdcComida);
                btndcconsultar = (Button) findViewById(R.id.btndcconsultar);


            }
        });
    }
    public void  inicializar (){
        //identificação dos campos

        txtdcCodigo = (EditText) findViewById(R.id.txtdcCodigo);
        lbldcVoltar = (TextView) findViewById(R.id.lbldcVoltar);
        btndcDeletar = (Button) findViewById(R.id.btndcDeletar);
        gvdcComida = (ListView) findViewById(R.id.gvdcComida);
        btndcconsultar = (Button) findViewById(R.id.btndcconsultar);

    }
    //configuraçao da list
    private void configurarBotao() {
        btndcconsultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarComidas();
            }
        });
    }
    //list final
    private void carregarComidas() {
        gvdcComida.setAdapter(new ArrayAdapter<Comida>(Tela_Deletar_Comida.this,
                android.R.layout.simple_list_item_1, repositorioComida.obterTodos()));
    }

    //botao deletar
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtdcCodigo).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um ID valido");
            sucesso = false;
        } else {
            sucesso = true;
        }

        return sucesso;
    }

    //configuração de deletar

    private void configurarDelete() {
        btndcDeletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (validarObrigatoriedadeCampos()) {
                    if (repositorioComida.excluirComida(Long.parseLong(obterTexto(txtdcCodigo)))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Cliente excluido com sucesso.");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao excluir cliente.");
                    }
                }
            }
        });

    }
}
