package com.projetos.mobiletechlawer.controladores.funcionario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;

public class ControladorSelecionadoFuncionario extends AppCompatActivity {

    private TextView txt_nome;
    private TextView txt_nascimento;
    private TextView txt_sexo;
    private TextView txt_naturalidade;
    private TextView txt_estado;
    private TextView txt_cpf;
    private TextView txt_rg;
    private TextView txt_ctps;
    private TextView txt_serie;
    private TextView txt_digito;
    private TextView txt_registro_profissional;
    private TextView txt_orgao;
    private TextView txt_agencia;
    private TextView txt_conta;
    private TextView txt_grau_instrucao;
    private TextView txt_estado_civil;
    private TextView txt_endereco;
    private TextView txt_complemento;
    private TextView txt_bairro;
    private TextView txt_cidade;
    private TextView txt_cep;
    private TextView txt_telefone;
    private TextView txt_salario;
    private TextView txt_pagamento;
    private TextView txt_cargo;
    private TextView txt_carteira;

    private String nome;
    private String nascimento;
    private String sexo;
    private String naturalidade;
    private String estado;
    private String cpf;
    private String rg;
    private String ctps;
    private String serie;
    private String digito;
    private String registroProfissional;
    private String orgao;
    private String agencia;
    private String conta;
    private String grauInstrucao;
    private String estadoCivil;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String telefone;
    private String salario;
    private String pagamento;
    private String cargo;
    private String carteiraEstagiario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_selecionado_funcionario);
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

        Intent i =getIntent();
        nome = i.getStringExtra("nome");
        nascimento = i.getStringExtra("nascimento");
        sexo = i.getStringExtra("sexo");
        naturalidade = i.getStringExtra("naturalidade");
        estado = i.getStringExtra("estado");
        cpf = i.getStringExtra("cpf");
        rg = i.getStringExtra("rg");
        ctps = i.getStringExtra("ctps");
        serie = i.getStringExtra("serie");
        digito = i.getStringExtra("digito");
        registroProfissional = i.getStringExtra("registroProfissional");
        orgao = i.getStringExtra("orgao");
        agencia = i.getStringExtra("agencia");
        conta = i.getStringExtra("conta");
        grauInstrucao = i.getStringExtra("grauInstrucao");
        estadoCivil = i.getStringExtra("estadoCivil");
        endereco = i.getStringExtra("endereco");
        complemento = i.getStringExtra("complemento");
        bairro = i.getStringExtra("bairro");
        cidade = i.getStringExtra("cidade");
        cep = i.getStringExtra("cep");
        telefone = i.getStringExtra("telefone");
        salario = i.getStringExtra("salario");
        pagamento = i.getStringExtra("pagamento");
        cargo = i.getStringExtra("cargo");
        carteiraEstagiario = i.getStringExtra("carteiraEstagiario");


        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_nascimento = (TextView) findViewById(R.id.txt_nascimento);
        txt_sexo = (TextView) findViewById(R.id.txt_sexo);
        txt_naturalidade = (TextView) findViewById(R.id.txt_naturalidade);
        txt_estado = (TextView) findViewById(R.id.txt_estado);
        txt_cpf = (TextView) findViewById(R.id.txt_cpf);
        txt_rg = (TextView) findViewById(R.id.txt_rg);
        txt_ctps = (TextView) findViewById(R.id.txt_ctps);
        txt_serie = (TextView) findViewById(R.id.txt_serie);
        txt_digito = (TextView) findViewById(R.id.txt_digito);
        txt_registro_profissional = (TextView) findViewById(R.id.txt_registro_profissional);
        txt_orgao = (TextView) findViewById(R.id.txt_orgao);
        txt_agencia = (TextView) findViewById(R.id.txt_agencia);
        txt_conta = (TextView) findViewById(R.id.txt_conta);
        txt_grau_instrucao = (TextView) findViewById(R.id.txt_grau_instrucao);
        txt_estado_civil = (TextView) findViewById(R.id.txt_estado_civil);
        txt_endereco = (TextView) findViewById(R.id.txt_endereco);
        txt_complemento = (TextView) findViewById(R.id.txt_complemento);
        txt_bairro = (TextView) findViewById(R.id.txt_bairro);
        txt_cidade = (TextView) findViewById(R.id.txt_cidade);
        txt_cep = (TextView) findViewById(R.id.txt_cep);
        txt_telefone = (TextView) findViewById(R.id.txt_telefone);
        txt_salario = (TextView) findViewById(R.id.txt_salario);
        txt_pagamento = (TextView) findViewById(R.id.txt_pagamento);
        txt_cargo = (TextView) findViewById(R.id.txt_cargo);
        txt_carteira = (TextView) findViewById(R.id.txt_carteira);

        txt_nome.setText(nome);
        txt_nascimento.setText(nascimento);
        txt_sexo.setText(sexo);
        txt_naturalidade.setText(naturalidade);
        txt_estado.setText(estado);
        txt_cpf.setText(cpf);
        txt_rg.setText(rg);
        txt_ctps.setText(ctps);
        txt_serie.setText(serie);
        txt_digito.setText(digito);
        txt_registro_profissional.setText(registroProfissional);
        txt_orgao.setText(orgao);
        txt_agencia.setText(agencia);
        txt_conta.setText(conta);
        txt_grau_instrucao.setText(grauInstrucao);
        txt_estado_civil.setText(estadoCivil);
        txt_endereco.setText(endereco);
        txt_complemento.setText(complemento);
        txt_bairro.setText(bairro);
        txt_cidade.setText(cidade);
        txt_cep.setText(cep);
        txt_telefone.setText(telefone);
        txt_salario.setText(salario);
        txt_pagamento.setText(pagamento);
        txt_cargo.setText(cargo);
        txt_carteira.setText(carteiraEstagiario);
    }

}
