package br.com.example.projetoModelo_A;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.example.projetoModelo_A.dominio.Login;
import br.com.example.projetoModelo_A.utilitarios.Mensagem;

public class LoginActivity1 extends AppCompatActivity {
    private Button btnEnviar; // Declaração de Um Button
    private Button btnCancelar; // Declaração de Um Button
    EditText edtUsuario;
    EditText edtSenha;
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        inicializarObjeto();
        autenticarLogin();
        abrirActivityMenu();
    }
    public void inicializarObjeto() {
        // login = new Login("rubens", "123");
        btnEnviar = (Button) findViewById(R.id.btnEnviar); // Atribuição de Valor
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }

    protected String obterTexto(EditText editText) {
        String texto = editText.getText().toString();
        return (texto != null && !texto.isEmpty() ? texto : "");
    }

    private void autenticarLogin() {
              /* if((login.getUsuario().equals(usuario))&& (login.getSenha().equals(senha))){
            abrirActivityMenu();
        }*/
    }



    private void abrirActivityMenu() {
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentActivityMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intentActivityMenu);
            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mensagem.exibirMensagem(getApplicationContext(),"Usuario: " + usuario + " Senha: " + senha);
                Log.v("EditText", edtSenha.getText().toString());
                Toast.makeText(getApplicationContext(), "Fechando " + edtUsuario.getText().toString() +" - "+ edtSenha.getText().toString() + "  !!! Aguarde", Toast.LENGTH_LONG).show();
            }
        });


    }

}
