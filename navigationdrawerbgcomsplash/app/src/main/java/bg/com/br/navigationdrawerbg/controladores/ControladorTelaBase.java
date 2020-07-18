package bg.com.br.navigationdrawerbg.controladores;
import bg.com.br.navigationdrawerbg.repositorios.RepositorioCliente;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by m8 on 25/11/16.
 */

public abstract class ControladorTelaBase extends AppCompatActivity {
    protected RepositorioCliente repositorioCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // repositorioCliente = new RepositorioCliente(this);
    }

    protected  void abrirTela(Context tela, Class<?> novaTela){
        Intent intent = new Intent(tela,novaTela);
        this.startActivity(intent);
    }
    public void finalizarAplicacao(){
        this.finish();
    }
    protected String obterTexto(EditText editText){
        String texto = editText.getText().toString();

        return texto != null && !texto.isEmpty() ? texto : "";
    }

}
