package br.com.bg.apptccmobile.utilitario;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Tata on 23/11/2016.
 */

public class Mensagem {
    public static void exibirMensagem(Context tela, String mensagem) {
        Toast.makeText(tela, mensagem, Toast.LENGTH_LONG).show();
    }
}
