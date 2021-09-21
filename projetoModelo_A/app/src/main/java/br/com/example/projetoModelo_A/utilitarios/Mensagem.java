package br.com.example.projetoModelo_A.utilitarios;

import android.content.Context;
import android.widget.Toast;
/**
 * Created by rubens leme on 23/11/2016.
 */

public class Mensagem {
    public static void exibirMensagem(Context tela, String mensagem) {
        Toast.makeText(tela, mensagem, Toast.LENGTH_LONG).show();
    }
}
