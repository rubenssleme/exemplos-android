package com.example.agendadecontatos.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.agendadecontatos.fabrica.FabricaLogin;
import com.example.agendadecontatos.modelo.Login;

public class LoginRepositorio extends  RepositorioBase {
    private final String TABELA_LOGIN = "TB_LOGIN";

    public LoginRepositorio(Context context) {
        super(context);
    }

    public Boolean salvarLogin(Login login){
        boolean salvo = inserir(TABELA_LOGIN, FabricaLogin.criarLoginContextValue(login));
        Log.d("Salvando Login",login.toString());
        return salvo;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
