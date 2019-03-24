package com.aprendaefaca.toastmessage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ControladorTelaToast extends AppCompatActivity {

    private Button btnToastMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_toast);
        btnToastMessage = (Button) findViewById(R.id.btnToastMessage);
        btnToastMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getApplicationContext(), "Teste Mensagem!",Toast.LENGTH_LONG).show();
            }
        });

    }
}
