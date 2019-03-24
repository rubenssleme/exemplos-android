package com.example.a3binfo.tccarctos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExemploConsultaChamadosActivity extends AppCompatActivity {

    ListView listViewChamados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_consulta_chamados);

        listViewChamados = (ListView) findViewById(R.id.listViewChamados);


        try {
            ArrayList<DtoChamados> listDtoChamados = new DaoChamados().consultarTudo();

            ArrayAdapter adapter =
                    new ArrayAdapter(ExemploConsultaChamadosActivity.this, android.R.layout.simple_list_item_1, listDtoChamados );

            listViewChamados.setAdapter(adapter);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
