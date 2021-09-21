package br.com.bg.apptccmobile.controladores;

import android.content.Intent;
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

import br.com.bg.apptccmobile.R;

public class Menu_Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu__drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Convidadoadd) {
            Intent it = new Intent(Menu_Drawer.this, Tela_Cadastrar_Convidado.class);
            startActivity(it);
        }else if (id == R.id.Convidadoalt){
            Intent it = new Intent(Menu_Drawer.this, Tela_Alterar_Convidado.class);
            startActivity(it);

        } else if (id == R.id.Convidadodel){
            Intent it = new Intent(Menu_Drawer.this, Tela_Deletar_Convidado.class);
            startActivity(it);

        } else if (id == R.id.Comidaadd) {
            Intent it = new Intent(Menu_Drawer.this, Tela_Cadastrar_Comida.class);
            startActivity(it);
        } else if (id == R.id.Comidaalt){
            Intent it = new Intent(Menu_Drawer.this, Tela_Alterar_Comida.class);
            startActivity(it);
        } else if (id == R.id.Comidadel){
            Intent it = new Intent(Menu_Drawer.this, Tela_Deletar_Comida.class);
            startActivity(it);
        } else if (id == R.id.Bebidaadd) {
            Intent it = new Intent(Menu_Drawer.this, Tela_Cadastrar_Bebida.class);
            startActivity(it);
        } else if (id == R.id.Bebidaalt){
            Intent it = new Intent(Menu_Drawer.this, Tela_Alterar_Bebida.class);
            startActivity(it);
        } else if (id == R.id.Bebidadel){
            Intent it = new Intent(Menu_Drawer.this, Tela_Deletar_Bebida.class);
            startActivity(it);
        } else if (id == R.id.Gerenciall) {
            Intent it = new Intent(Menu_Drawer.this, Tela_Deletar_Convidado.class);
            startActivity(it);
        } else if (id == R.id.Teste) {
            Intent it = new Intent(Menu_Drawer.this, Tela_Teste.class);
            startActivity(it);
        } else if (id == R.id.Sobre) {
            Intent it = new Intent(Menu_Drawer.this, Tela_Sobre_wztd.class);
            startActivity(it);
        } else if (id == R.id.SairApp) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
