package com.bg.rubens.navidrawer;

import android.content.Context;
import android.widget.Toast;

public class Mensagem   {

    public static void exibirToast(Context tela,String msg){
        Toast.makeText(tela, msg, Toast.LENGTH_LONG).show();
    }
}
