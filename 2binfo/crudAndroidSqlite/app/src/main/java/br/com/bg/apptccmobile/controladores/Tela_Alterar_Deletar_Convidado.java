package br.com.bg.apptccmobile.controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.*;

import br.com.bg.apptccmobile.R;

public class Tela_Alterar_Deletar_Convidado extends AppCompatActivity {

    //declaração dos cmapos

    private Button btnadconvAlterar;
    private Button btnadDeletar;
    private TextView lbladconvVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__alterar__deletar__convidado);

        //identificação dos campos

        btnadconvAlterar = (Button) findViewById(R.id.btnadconvAlterar);
        btnadDeletar = (Button) findViewById(R.id.btnadDeletar);
        lbladconvVoltar = (TextView) findViewById(R.id.lbladconvVoltar);

        //chamando tela pela label

        lbladconvVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela_Alterar_Deletar_Convidado.this, Menu_Drawer.class);
                startActivity(it);
            }
        });

        //chamando tela pelos buttons

        btnadconvAlterar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it = new Intent(Tela_Alterar_Deletar_Convidado.this, Tela_Alterar_Convidado.class);
                startActivity(it);
            }
        });
        btnadDeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent it = new Intent(Tela_Alterar_Deletar_Convidado.this, Tela_Deletar_Convidado.class);
                startActivity(it);
            }
        });
    }
}
