package com.projetos.mobiletechlawer.controladores.processo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;

public class ControladorSelecionadoProcesso extends AppCompatActivity {


    TextView txt_numero;
    TextView txt_assunto;
    TextView txt_cliente;
    TextView txt_acao;
    TextView txt_situacao;
    TextView txt_valor;
    TextView txt_pasta;
    TextView txt_condicao;
    TextView txt_parteContraria;
    TextView txt_advogadoContrario;
    TextView txt_tipoJustica;
    TextView txt_regiao;
    TextView txt_secao;
    TextView txt_subsecao;
    TextView txt_cidadeComarca;
    TextView txt_foro;
    TextView txt_vara;
    TextView txt_observacoes;


    String numero;
    String assunto;
    String cliente;
    String acao;
    String situacao;
    String valor;
    String pasta;
    String condicao;
    String parteContraria;
    String advogadoContrario;
    String tipoJustica;
    String regiao;
    String secao;
    String subsecao;
    String cidadeComarca;
    String foro;
    String vara;
    String observacoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_selecionado_processo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        numero = i.getStringExtra("numero");
        assunto = i.getStringExtra("assunto");
        cliente = i.getStringExtra("cliente");
        acao = i.getStringExtra("acao");
        situacao = i.getStringExtra("situacao");
        valor = i.getStringExtra("valor");
        pasta = i.getStringExtra("pasta");
        condicao = i.getStringExtra("condicao");
        parteContraria = i.getStringExtra("parteContraria");
        advogadoContrario = i.getStringExtra("advogadoContrario");
        tipoJustica = i.getStringExtra("tipoJustica");
        regiao = i.getStringExtra("regiao");
        secao = i.getStringExtra("secao");
        subsecao = i.getStringExtra("subsecao");
        cidadeComarca = i.getStringExtra("cidadeComarca");
        foro = i.getStringExtra("foro");
        vara = i.getStringExtra("vara");
        observacoes = i.getStringExtra("observacoes");

        txt_numero = (TextView)findViewById(R.id.txt_numero);
        txt_assunto = (TextView)findViewById(R.id.txt_assunto);
        txt_cliente = (TextView)findViewById(R.id.txt_cliente);
        txt_acao = (TextView)findViewById(R.id.txt_acao);
        txt_situacao = (TextView)findViewById(R.id.txt_situacao);
        txt_valor = (TextView)findViewById(R.id.txt_valor);
        txt_pasta = (TextView)findViewById(R.id.txt_pasta);
        txt_condicao = (TextView)findViewById(R.id.txt_condicao);
        txt_parteContraria = (TextView)findViewById(R.id.txt_parte_contraria);
        txt_advogadoContrario = (TextView)findViewById(R.id.txt_advogado_contrario);
        txt_tipoJustica = (TextView)findViewById(R.id.txt_tipo_justica);
        txt_regiao = (TextView)findViewById(R.id.txt_regiao);
        txt_secao = (TextView)findViewById(R.id.txt_secao);
        txt_subsecao = (TextView)findViewById(R.id.txt_subsecao);
        txt_cidadeComarca = (TextView)findViewById(R.id.txt_cidade_comarca);
        txt_foro = (TextView)findViewById(R.id.txt_foro);
        txt_vara = (TextView)findViewById(R.id.txt_vara);
        txt_observacoes = (TextView)findViewById(R.id.txt_observacoes);

        txt_numero.setText(numero);
        txt_assunto.setText(assunto);
        txt_cliente.setText(cliente);
        txt_acao.setText(acao);
        txt_situacao.setText(situacao);
        txt_valor.setText(valor);
        txt_pasta.setText(pasta);
        txt_condicao.setText(condicao);
        txt_parteContraria.setText(parteContraria);
        txt_advogadoContrario.setText(advogadoContrario);
        txt_tipoJustica.setText(tipoJustica);
        txt_regiao.setText(regiao);
        txt_secao.setText(secao);
        txt_subsecao.setText(subsecao);
        txt_cidadeComarca.setText(cidadeComarca);
        txt_foro.setText(foro);
        txt_vara.setText(vara);
        txt_observacoes.setText(observacoes);

    }

}
