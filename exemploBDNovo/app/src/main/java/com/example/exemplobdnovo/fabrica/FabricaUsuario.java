package com.example.exemplobdnovo.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.exemplobdnovo.dominio.Usuario;

public class FabricaUsuario {

public static ContentValues criarUsuarioCv(Usuario usuario){
ContentValues usuarioCv = new ContentValues();
    usuarioCv.put("nome",usuario.getNome());
    usuarioCv.put("login",usuario.getLogin());
    usuarioCv.put("senha",usuario.getSenha());
return usuarioCv;
}

    public static Usuario criarUsuario(Cursor cursor){
    Usuario usuario = new Usuario();

    usuario.setCodigo(Long.parseLong(cursor.getString(0)));
    usuario.setNome(cursor.getString(1));
    usuario.setLogin(cursor.getString(2));
    usuario.setSenha(cursor.getString(3));

    return usuario;
    }
}
