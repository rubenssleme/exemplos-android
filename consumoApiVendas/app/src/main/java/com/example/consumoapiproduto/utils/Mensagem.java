package com.example.consumoapiproduto.utils;

import android.content.Context;
import android.widget.Toast;

public class Mensagem {

    public static void exibirMensagem(Context context, String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show();
    }
}
