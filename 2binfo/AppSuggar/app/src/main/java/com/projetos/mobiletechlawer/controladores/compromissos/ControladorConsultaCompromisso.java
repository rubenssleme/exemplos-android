package com.projetos.mobiletechlawer.controladores.compromissos;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.dominios.Compromisso;

import java.util.List;


public class ControladorConsultaCompromisso extends AppCompatActivity {

    private RadioGroup rg_filtro;
    private RadioButton rb_titulo;
    private RadioButton rb_data;
    private EditText edt_filtro;
    private ListView lv_filtro;

    List<Compromisso> listaCompromisso;
    ControladorListViewCompromisso adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_controlador_consulta_compromisso);

        iniciarConsultaCompromissos();
    }
    public void iniciarConsultaCompromissos(){

        rg_filtro = (RadioGroup) findViewById(R.id.rg_filtro);
        rg_filtro.requestFocus();
        rb_titulo = (RadioButton) findViewById(R.id.rb_titulo);
        rb_data = (RadioButton) findViewById(R.id.rb_data);
        edt_filtro = (EditText) findViewById(R.id.edt_filtro_compromissos);
        lv_filtro = (ListView) findViewById(R.id.lv_filtro);

        listaCompromisso = Compromisso.listAll(Compromisso.class);

        adapter = new ControladorListViewCompromisso(this, listaCompromisso);
        lv_filtro.setAdapter(adapter);

        rg_filtro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_titulo:
                        rb_titulo.requestFocus();
                        edt_filtro.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.filterTitulo(s.toString());
                            }
                            @Override
                            public void afterTextChanged(Editable s) {
                            }
                        });
                        break;
                    case R.id.rb_data:
                        edt_filtro.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                adapter.filterData(s.toString());
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
