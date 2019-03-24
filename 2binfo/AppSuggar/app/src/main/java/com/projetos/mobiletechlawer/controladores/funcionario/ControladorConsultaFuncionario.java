package com.projetos.mobiletechlawer.controladores.funcionario;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.controladores.cliente.ControladorListViewCliente;
import com.projetos.mobiletechlawer.dominios.Cliente;
import com.projetos.mobiletechlawer.dominios.Funcionario;

import java.util.List;

public class ControladorConsultaFuncionario extends AppCompatActivity {

    private RadioGroup rg_filtro_funcionario;
    private RadioButton rb_nome;
    private RadioButton rb_cpf;
    private EditText edt_filtro_funcionario;
    private ListView lv_filtro_funcionario;

    List<Funcionario> listaFuncionario;
    ControladorListViewFuncionario adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_consulta_funcionario);
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
        iniciarFiltroFuncionario();
    }
    public void iniciarFiltroFuncionario(){
        rg_filtro_funcionario = (RadioGroup) findViewById(R.id.rg_filtro_funcionario);
        rg_filtro_funcionario.requestFocus();
        rb_nome = (RadioButton) findViewById(R.id.rb_nome);
        rb_cpf = (RadioButton) findViewById(R.id.rb_cpf);
        edt_filtro_funcionario = (EditText) findViewById(R.id.edt_filtro_funcionario);
        lv_filtro_funcionario = (ListView) findViewById(R.id.lv_filtro_funcionario);

        listaFuncionario = Funcionario.listAll(Funcionario.class);
        adapter = new ControladorListViewFuncionario(this, listaFuncionario);
        lv_filtro_funcionario.setAdapter(adapter);

        rg_filtro_funcionario.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_nome:
                        edt_filtro_funcionario.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.fiterNome(s.toString());
                            }
                            @Override
                            public void afterTextChanged(Editable s) {
                            }
                        });
                        break;
                    case R.id.rb_cpf:
                        edt_filtro_funcionario.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                adapter.filterCpf(s.toString());
                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                        break;
                }
            }
        });
    }

}
