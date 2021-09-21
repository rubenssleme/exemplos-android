package com.example.agendadecontatos.repositorio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.example.agendadecontatos.fabrica.FabricaLogin;
import com.example.agendadecontatos.modelo.Login;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<Login> obterTodos() {
        ArrayList<Login> login = new ArrayList<Login>();

        String sql ="SELECT * FROM " + TABELA_LOGIN;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                login.add(FabricaLogin.criarLogin(cursor));
            }while (cursor.moveToNext());
        }
        Log.d("obterTodos" , login.toString());
        return login;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
