package bg.com.br.navigationdrawerbg.controladores;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import bg.com.br.navigationdrawerbg.R;

/**
 * Created by Rubens Leme on 29/11/16.
 */

public class ControladorTelaSplash extends AppCompatActivity {

    private static final int TEMPO = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        iniciarTelaSplash();
    }

    private void iniciarTelaSplash() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent splash = new Intent();
                splash.setClass(ControladorTelaSplash.this,
                        ControladorTelaPrincipal.class);
                startActivity(splash);
            }
        }, TEMPO);
    }
}

