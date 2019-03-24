package com.example.bg.exemplobg3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ControladorTelaPrincipal extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        //Aqui inicia os botões!!!
        Button btnAzul = (Button)findViewById(R.id.btnAzul);
        btnAzul.setOnClickListener(this);

        Button btnVerde = (Button)findViewById(R.id.btnVerde);
        btnVerde.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAzul:
                Intent intent1 = new Intent(this, ControladorTelaProfessor.class);
                startActivity(intent1);
                break;
            case R.id.btnVerde:
                Intent intent2 = new Intent(this, ControladorTelaCoordenador.class);
                startActivity(intent2);
                break;
            default:
                break;

        }
    }
}
