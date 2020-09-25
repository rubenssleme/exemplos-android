package br.com.bg.apptccmobile.controladores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import br.com.bg.apptccmobile.repositorios.RepositorioBebida;
import br.com.bg.apptccmobile.repositorios.RepositorioComida;
import br.com.bg.apptccmobile.repositorios.RepositorioConvidado;
import br.com.bg.apptccmobile.repositorios.RepositorioConvidado2;
import br.com.bg.apptccmobile.repositorios.RepositorioUsuario;

/**
 * Created by m8 on 22/11/16.
 */

public class Tela_Base extends AppCompatActivity {
    protected RepositorioConvidado repositorioConvidado;
    protected RepositorioUsuario repositorioUsuario;
    protected RepositorioBebida repositorioBebida;
    protected RepositorioComida repositorioComida;
    protected RepositorioConvidado2 repositorioConvidado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repositorioComida = new RepositorioComida(this);
        repositorioConvidado = new RepositorioConvidado(this);
        repositorioUsuario = new RepositorioUsuario(this);
        repositorioBebida = new RepositorioBebida(this);
        repositorioConvidado2 = new RepositorioConvidado2(this);

    }

    protected void abrirTela(Context tela, Class<?> novaTela) {
        Intent intent = new Intent(tela, novaTela);
        this.startActivity(intent);
    }
    public void finalizarAplicacao(){
        this.finish();
    }

    protected String obterTexto(EditText editText) {
        String texto = editText.getText().toString();

        return texto != null && !texto.isEmpty() ? texto : "";
    }
}
