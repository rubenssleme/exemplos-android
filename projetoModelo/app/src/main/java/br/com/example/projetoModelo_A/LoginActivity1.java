package br.com.example.projetoModelo_A;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity1 extends AppCompatActivity {

    Button btnEnviar; // Declaração de Um Button
    Button btnCancelar; // Declaração de Um Button
    EditText edtUsuario;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        inicializarObjeto();
        abrirActivityMenu();

    }

    public void inicializarObjeto() {
        btnEnviar = (Button) findViewById(R.id.btnEnviar); // Atribuição de Valor
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }


    private void abrirActivityMenu() {
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentActivityMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intentActivityMenu);
            }
        });


    }
}