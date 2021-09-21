package com.aprendaefaca.projetolistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;
    private String[] itens ={"São Paulo","São Carlos"
            ,"São Jose","São Augusto","São camilo","São cristovao","Juliao"
            ,"São cargo"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = (ListView) findViewById(R.id.lsvTesteId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                itens
        );
      listaItens.setAdapter(adapter);
      listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener(){
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              int idPosicao =  position;
              String valorClicado = listaItens.getItemAtPosition(idPosicao).toString();
              Toast.makeText(getApplicationContext(),"Cidades : " + valorClicado, Toast.LENGTH_SHORT).show();
          }
      });

    }
}
