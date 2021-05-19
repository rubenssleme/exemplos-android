package com.example.exemplobdnovo.repositorio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.exemplobdnovo.dominio.Usuario;
import com.example.exemplobdnovo.fabrica.FabricaUsuario;

import java.util.LinkedList;
import java.util.List;

public class RepositorioUsuario extends RepositorioBase {
    private static final String TABELA_USUARIO = "tbUsuario";

    public RepositorioUsuario(@Nullable Context context) {
        super(context);
    }

    public boolean salvarUsuario(Usuario usuario) {
        boolean salvo = salvar(TABELA_USUARIO, FabricaUsuario.criarUsuarioCv(usuario));
        Log.d("salvarUsuario", usuario.toString());
        return salvo;
    }

    public List<Usuario> obterTodos() {
        List<Usuario> usuarios = new LinkedList<Usuario>();
        String sql = "SELECT * FROM " + TABELA_USUARIO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                usuarios.add(FabricaUsuario.criarUsuario(cursor));
            } while (cursor.moveToNext());
        }
        Log.d("obterTodos", usuarios.toString());
        return usuarios;
    }

}
