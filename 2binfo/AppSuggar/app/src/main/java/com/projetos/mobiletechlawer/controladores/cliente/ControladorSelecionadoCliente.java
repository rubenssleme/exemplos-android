package com.projetos.mobiletechlawer.controladores.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;

public class ControladorSelecionadoCliente extends AppCompatActivity {

    private TextView txt_nome;
    private TextView txt_cpf;
    private TextView txt_cnpj;
    private TextView txt_rg;
    private TextView txt_endereco;
    private TextView txt_numero;
    private TextView txt_complemento;
    private TextView txt_cep;
    private TextView txt_bairro;
    private TextView txt_cidade;
    private TextView txt_estado;
    private TextView txt_email;
    private TextView txt_celular;
    private TextView txt_telefone;

    private String nome;
    private String cpf;
    private String cnpj;
    private String rg;
    private String endereco;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String celular;
    private String telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_selecionado_cliente);
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
        cpf = i.getStringExtra("cpf");
        cnpj = i.getStringExtra("cnpj");
        rg = i.getStringExtra("rg");
        endereco = i.getStringExtra("endereco");
        numero = i.getStringExtra("numero");
        complemento = i.getStringExtra("complemento");
        cep = i.getStringExtra("cep");
        bairro = i.getStringExtra("bairro");
        cidade = i.getStringExtra("cidade");
        estado = i.getStringExtra("estado");
        email = i.getStringExtra("email");
        celular = i.getStringExtra("celular");
        telefone = i.getStringExtra("telefone");

        txt_nome = (TextView)findViewById(R.id.txt_nome);
        txt_cpf = (TextView)findViewById(R.id.txt_cpf);
        txt_cnpj = (TextView)findViewById(R.id.txt_cnpj);
        txt_rg = (TextView)findViewById(R.id.txt_rg);
        txt_endereco = (TextView)findViewById(R.id.txt_endereco);
        txt_numero = (TextView)findViewById(R.id.txt_numero);
        txt_complemento = (TextView)findViewById(R.id.txt_complemento);
        txt_cep = (TextView)findViewById(R.id.txt_cep);
        txt_bairro = (TextView)findViewById(R.id.txt_bairro);
        txt_cidade = (TextView)findViewById(R.id.txt_cidade);
        txt_estado = (TextView)findViewById(R.id.txt_estado);
        txt_email = (TextView)findViewById(R.id.txt_email);
        txt_celular = (TextView)findViewById(R.id.txt_celular);
        txt_telefone = (TextView)findViewById(R.id.txt_telefone);

        txt_nome.setText(nome);
        txt_cpf.setText(cpf);
        txt_cnpj.setText(cnpj);
        txt_rg.setText(rg);
        txt_endereco.setText(endereco);
        txt_numero.setText(numero);
        txt_complemento.setText(complemento);
        txt_cep.setText(cep);
        txt_bairro.setText(bairro);
        txt_cidade.setText(cidade);
        txt_estado.setText(estado);
        txt_email.setText(email);
        txt_celular.setText(celular);
        txt_telefone.setText(telefone);

    }


}
