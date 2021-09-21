package com.example.agendadecontatos.controlador;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.agendadecontatos.R;
import com.example.agendadecontatos.modelo.Login;
import com.example.agendadecontatos.repositorio.LoginRepositorio;

public class CadastrarLogin extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextUsuario;
    EditText editTextSenha;
    Button buttonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_login);
        editTextNome = findViewById(R.id.editTextNomeLogin);
        editTextUsuario = findViewById(R.id.editTextUsuarioLogin);
        editTextSenha = findViewById(R.id.editTextSenhaLogin);
        buttonSalvar = findViewById(R.id.buttonSalvarContato);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
        LoginRepositorio loginRepositorio = null;
            @Override
            public void onClick(View v) {
                loginRepositorio = new LoginRepositorio(getApplicationContext());
                Login login = new Login();
                login.setNome(editTextNome.getText().toString());
                login.setUsuario(editTextUsuario.getText().toString());
                login.setSenha(editTextSenha.getText().toString());
              //  Toast.makeText(getApplicationContext(), login.toString(), Toast.LENGTH_SHORT).show();
                try {
                    if (loginRepositorio.salvarLogin(login)) {
                        Toast.makeText(CadastrarLogin.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(CadastrarLogin.this, "Erro ao Inserido: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}