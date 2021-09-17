package com.example.firebase.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firebase.R;
import com.example.firebase.config.User;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {
    private Button buttonRegister;
    private Button buttonLogin;
    private Button button;
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonRegister = findViewById(R.id.register);
        buttonLogin = findViewById(R.id.login);
        button = findViewById(R.id.btnSalvarUsuario);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent telaRegister = new Intent(MenuActivity.this, RegisterActivity.class);
                startActivity(telaRegister);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* finish();
                Intent telaLogin = new Intent(MenuActivity.this,LoginActivity.class);
                startActivity(telaLogin);*/
                User user = new User();

                Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent telaLogin = new Intent(MenuActivity.this,LoginActivity.class);
                startActivity(telaLogin);

            }
        });
    }

}