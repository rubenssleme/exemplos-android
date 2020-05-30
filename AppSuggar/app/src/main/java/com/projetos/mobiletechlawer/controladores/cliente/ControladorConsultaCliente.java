package com.projetos.mobiletechlawer.controladores.cliente;

import android.graphics.Rect;
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
import com.projetos.mobiletechlawer.dominios.Cliente;

import java.util.List;

public class ControladorConsultaCliente extends AppCompatActivity {

    private RadioGroup rg_filtro_cliente;
    private RadioButton rb_nome;
    private RadioButton rb_cpf;
    private RadioButton rb_cnpj;
    private EditText edt_filtro_cliente;
    private ListView lv_filtro_cliente;

    private List<Cliente> listaCliente;
    ControladorListViewCliente adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_consulta_cliente);
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
        iniciarFiltroCliente();
    }
    public void iniciarFiltroCliente(){
        rg_filtro_cliente = (RadioGroup) findViewById(R.id.rg_filtro_cliente);
        rg_filtro_cliente.requestFocus();
        rb_nome = (RadioButton) findViewById(R.id.rb_nome);
        rb_cpf = (RadioButton) findViewById(R.id.rb_cpf);
        rb_cnpj = (RadioButton) findViewById(R.id.rb_cnpj);
        edt_filtro_cliente = (EditText) findViewById(R.id.edt_filtro_cliente);
        lv_filtro_cliente = (ListView) findViewById(R.id.lv_filtro_cliente);

        listaCliente = Cliente.listAll(Cliente.class);

        adapter = new ControladorListViewCliente(this, listaCliente);
        lv_filtro_cliente.setAdapter(adapter);
        rg_filtro_cliente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_nome:
                                edt_filtro_cliente.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.filternome(s.toString());
                            }
                            @Override
                            public void afterTextChanged(Editable s) {
                            }
                        });
                        break;
                    case R.id.rb_cpf:
                        edt_filtro_cliente.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                adapter.filtercpf(s.toString());
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                            }
                            @Override
                            public void afterTextChanged(Editable s) {
                            }
                        });
                        break;
                    case R.id.rb_cnpj:
                        edt_filtro_cliente.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.filtercnpj(s.toString());
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
