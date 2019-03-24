package com.projetos.mobiletechlawer.controladores.processo;

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
import com.projetos.mobiletechlawer.dominios.Processo;

import java.util.List;

public class ControladorConsultaProcesso extends AppCompatActivity {

    private RadioGroup rg_filtro_processo;
    private RadioButton rb_numero;
    private RadioButton rb_nome;
    private RadioButton rb_pasta;
    private EditText edt_filtro_processo;
    private ListView lv_filtro_processo;

    private List<Processo> listaProcesso;
    ControladorListViewProcesso adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_consulta_processo);
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
        iniciarFiltroProcesso();
    }
    public void iniciarFiltroProcesso(){
        rg_filtro_processo = (RadioGroup) findViewById(R.id.rg_filtro_processo);
        rg_filtro_processo.requestFocus();
        rb_numero = (RadioButton) findViewById(R.id.rb_numero);
        rb_nome = (RadioButton) findViewById(R.id.rb_nome);
        rb_pasta = (RadioButton) findViewById(R.id.rb_pasta);
        edt_filtro_processo = (EditText) findViewById(R.id.edt_filtro_processo);
        lv_filtro_processo = (ListView) findViewById(R.id.lv_filtro_processo);

        listaProcesso = Processo.listAll(Processo.class);

        adapter = new ControladorListViewProcesso(this, listaProcesso);
        lv_filtro_processo.setAdapter(adapter);

        rg_filtro_processo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_numero:
                        edt_filtro_processo.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.filternumero(s.toString());
                            }
                            @Override
                            public void afterTextChanged(Editable s) {
                            }
                        });
                        break;
                    case R.id.rb_pasta:
                        edt_filtro_processo.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.filterpasta(s.toString());
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
