package br.com.bg.apptccmobile.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import br.com.bg.apptccmobile.dominio.Usuario;

/**
 * Created by 3binfo on 27/10/2016.
 */

public class FabricaUsuario {

    public static Usuario criarUsuario (Cursor cursor) {
        Usuario usuario = new Usuario();

        usuario.setCodigo(Long.parseLong(cursor.getString(0)));
        usuario.setOrg(cursor.getString(2));
        usuario.setNome(cursor.getString(1));
        usuario.setSenha(cursor.getString(3));

        return usuario;

    }

    public static ContentValues criarUsuarioCv (Usuario usuario) {
        ContentValues usuarioCv = new ContentValues();

        usuarioCv.put("nome", usuario.getNome());
        usuarioCv.put("usuario", usuario.getOrg());
        usuarioCv.put("senha", usuario.getSenha());

        return usuarioCv;
    }
}
