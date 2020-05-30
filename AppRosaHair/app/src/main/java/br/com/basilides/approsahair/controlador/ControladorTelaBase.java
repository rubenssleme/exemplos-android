package br.com.basilides.approsahair.controlador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public abstract class ControladorTelaBase  extends AppCompatActivity {
        //protected RepositorioCliente  repositorioCliente;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

    }

    protected void abrirTela(Context tela,Class<?> novaTela){
        Intent intent =  new Intent(tela,novaTela);
        this.startActivity(intent);
    }

    public void finalizarAplicacao(){
        this.finish();
    }


    protected  String obterTexto(EditText editText){
        String texto = editText.getText().toString();
        return  texto != null &&  !texto.isEmpty() ?texto : "";
    }

}
