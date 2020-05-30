package com.example.projetoexemplobg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ControladorTelaPrincipal extends AppCompatActivity {
    ImageButton btnNavigationDrawer, btnBasicActivity, btnBottomNavigation, btnTabbedActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        inicilizarObjetos();
        inicializarTelaNavigationDrawer();
        inicializarTelaBasicActivity();
        inicializarTelaBottomNavigation();
        inicializarTelaTabbedActivity();
    }

    private void inicilizarObjetos() {
        btnNavigationDrawer = findViewById(R.id.btnNavigationDrawer);//Amarrar Codigo Java com Botão da Tela.
        btnBasicActivity = findViewById(R.id.btnBasicActivity);//Amarrar Codigo Java com Botão da Tela
        btnBottomNavigation = findViewById(R.id.btnBottomNavigation);//Amarrar Codigo Java com Botão da Tela
        btnTabbedActivity = findViewById(R.id.btnTabbedActivity);//Amarrar Codigo Java com Botão da Tela
    }

    // Metodo de inicialização da tela  Navigation Drawer
    private void inicializarTelaNavigationDrawer() {
        btnNavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent telaNavigationDrawer = new Intent(getApplicationContext(), ControladorBottomNavigation.class);
//                startActivity(telaNavigationDrawer);
            }
        });
    }

    // Metodo de inicialização da tela Basic Activity
    private void inicializarTelaBasicActivity() {
        btnBasicActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent telaBasicActivity = new Intent(getApplicationContext(), ControladorBasicActivity.class);
//                startActivity(telaBasicActivity);
            }
        });
    }

    // Metodo de inicialização da tela Bottom Navigation
    private void inicializarTelaBottomNavigation() {
        btnBottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent telaBottomNavigation = new Intent(getApplicationContext(), ControladorBottomNavigation.class);
//                startActivity(telaBottomNavigation);
            }
        });
    }
    // Metodo de inicialização da tela Tabbed Activity
    private void inicializarTelaTabbedActivity(){
        btnTabbedActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent telaTabbedActivity = new Intent(getApplicationContext(), ControladorTabbedActivity.class);
//                startActivity(telaTabbedActivity);
            }
        });
    }


}
