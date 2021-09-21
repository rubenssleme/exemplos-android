package com.example.agendadecontatos.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.agendadecontatos.modelo.Login;

public class FabricaLogin {

    public static Login criarLogin (Cursor cursor) {
        Login login = new Login();

        login.setId(Long.parseLong(cursor.getString(0)));
        login.setUsuario(cursor.getString(2));
        login.setNome(cursor.getString(1));
        login.setSenha(cursor.getString(3));

        return login;

    }

    public static ContentValues criarLoginContextValue (Login login) {
        ContentValues loginCv = new ContentValues();

        loginCv.put("nome", login.getNome());
        loginCv.put("usuario", login.getUsuario());
        loginCv.put("senha", login.getSenha());

        return loginCv;
    }
}
