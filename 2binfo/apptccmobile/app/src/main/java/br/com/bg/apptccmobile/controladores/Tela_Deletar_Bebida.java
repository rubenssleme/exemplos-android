package br.com.bg.apptccmobile.controladores;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.*;

import br.com.bg.apptccmobile.R;
import br.com.bg.apptccmobile.dominio.Bebida;
import br.com.bg.apptccmobile.utilitario.Mensagem;

public class Tela_Deletar_Bebida extends Tela_Base {
    //Declaração dos campos
    private ListView gvdbBebida;
    private EditText txtdbCodigo;
    private Button btndbDeletar;
    private TextView lbldbVoltar;
    private Button btndbconsultar;

    Bebida bebida = new Bebida();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__deletar__bebida);

        inicializar();
        configurarBotao();
        configurarDelete();

        //Chamando tela pela label

        lbldbVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it = new Intent(Tela_Deletar_Bebida.this,Menu_Drawer.class);
                startActivity(it);
            }
        });

        btndbconsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
            //    gvdbBebida.setAdapter(new ArrayAdapter<Bebida>(Tela_Deletar_Bebida.this,
              //          android.R.layout.simple_list_item_1, repositorioBebida.obterTodos()));
                gvdbBebida = (ListView) findViewById(R.id.gvdcComida);
                btndbconsultar = (Button) findViewById(R.id.btndbconsultar);

            }
        });
    }
    public void  inicializar (){
        //Identificação dos campos
        gvdbBebida = (ListView) findViewById(R.id.gvdbBebida);
        txtdbCodigo = (EditText) findViewById(R.id.txtdbCodigo);
        btndbDeletar = (Button) findViewById(R.id.btndbDeletar);
        lbldbVoltar = (TextView) findViewById(R.id.lbldbVoltar);
        btndbconsultar = (Button) findViewById(R.id.btndbconsultar);


    }
    //configuraçao da list
    private void configurarBotao() {
        btndbconsultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                carregarBebidas();
            }
        });
    }
    //list final
    private void carregarBebidas() {
       // gvdbBebida.setAdapter(new ArrayAdapter<Bebida>(Tela_Deletar_Bebida.this,
         //       android.R.layout.simple_list_item_1, repositorioBebida.obterTodos()));
    }

    //botao deletar
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(txtdbCodigo).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um ID valido");
            sucesso = false;
        } else {
            sucesso = true;
        }

        return sucesso;
    }
    //configuração de deletar

    private void configurarDelete() {
        btndbDeletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (validarObrigatoriedadeCampos()) {
                 /*   if (repositorioBebida.excluirBebida(Long.parseLong(obterTexto(txtdbCodigo)))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Bebida excluida com sucesso.");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao excluir cliente.");
                    }*/
                }
            }
        });

    }
}
