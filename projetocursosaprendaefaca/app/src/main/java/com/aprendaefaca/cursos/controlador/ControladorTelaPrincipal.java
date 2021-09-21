package com.aprendaefaca.cursos.controlador;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ControladorTelaPrincipal extends ControladorTelaBase
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.aprendaefaca.cursos.R.layout.tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(com.aprendaefaca.cursos.R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.aprendaefaca.cursos.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(com.aprendaefaca.cursos.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, com.aprendaefaca.cursos.feature.R.string.navigation_drawer_open, com.aprendaefaca.cursos.feature.R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(com.aprendaefaca.cursos.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.aprendaefaca.cursos.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.aprendaefaca.cursos.R.menu.controlador_tela_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.aprendaefaca.cursos.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == com.aprendaefaca.cursos.R.id.nav_inicio) {
           // abrirSite(UrlUtils.URL_BLOG_APF);
        } else if (id == com.aprendaefaca.cursos.R.id.nav_aulas) {
            abrirTela(this.getApplicationContext(),ControladorTelaVideoAulas.class);
        } else if (id == com.aprendaefaca.cursos.R.id.nav_artigos) {
            abrirSite(UrlUtils.URL_BLOG_APF);
        } else if (id == com.aprendaefaca.cursos.R.id.nav_cursos) {
            abrirSite(UrlUtils.URL_YOUTUBE);
        } else if (id == com.aprendaefaca.cursos.R.id.nav_share) {
            abrirSite(UrlUtils.URL_GOOGLE_PLUS);
        } else if (id == com.aprendaefaca.cursos.R.id.nav_sair) {
            finalizarAplicacao();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.aprendaefaca.cursos.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
