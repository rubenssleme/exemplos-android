package br.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ControladorTelaLogin extends AppCompatActivity {
    private Button btnLogin; // Declaração de Um Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        abrirTelaMenu();
    }

    public void abrirTelaMenu(){
        btnLogin = (Button) findViewById(R.id.email_sign_in_button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTelaMenu = new Intent(getApplicationContext(), ControladorTelaMenu.class);
                startActivity(intentTelaMenu);
            }
        });

    }

}

