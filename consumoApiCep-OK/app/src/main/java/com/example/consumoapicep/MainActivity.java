package com.example.consumoapicep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editTextCep;
    Button buttonAcessarApi;
    TextView textViewEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCep = findViewById(R.id.editTextCep);
        buttonAcessarApi = findViewById(R.id.buttonAcessarApi);
        textViewEndereco = findViewById(R.id.textViewEndereco);

    }

    public void AcessarApi(View view) {
        String cep = editTextCep.getText().toString();
        Async async = new Async(textViewEndereco,cep);
        async.execute();


    }
}