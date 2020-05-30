package br.com.bg.apptccmobile.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import br.com.bg.apptccmobile.dominio.Usuario;
import br.com.bg.apptccmobile.fabrica.FabricaUsuario;

/**
 * Created by 3binfo on 27/10/2016.
 */

public class RepositorioUsuario extends RepositorioBase {
    private static final String TABELA_USUARIO ="usuario";
    private static final String CHAVE_ID = "codigo";

    public  RepositorioUsuario(Context context) {super(context);}



    @Override
    public void onUpgrade (SQLiteDatabase db , int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS usuario");
        this.onCreate(db);
    }
    public boolean salvarUsuario (Usuario usuario) {
        boolean salvo = salvar(TABELA_USUARIO, FabricaUsuario.criarUsuarioCv(usuario));
        Log.d("salvarUsuario()" , usuario.toString());
        return salvo;
    }
    public List<Usuario> obterTodos() {
        List<Usuario> usuarios = new LinkedList<Usuario>();

        String sql ="SELECT * FROM " + TABELA_USUARIO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                usuarios.add(FabricaUsuario.criarUsuario(cursor));
            }while (cursor.moveToNext());
        }
        Log.d("obterTodos" , usuarios.toString());
        return usuarios;
    }
    public boolean atualizarUsuario(Usuario usuario){
        int retorno = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String conditionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { String.valueOf(usuario.getCodigo())};
        ContentValues usuariocv = FabricaUsuario.criarUsuarioCv(usuario);

        retorno = db.update(TABELA_USUARIO, usuariocv, conditionalWhere , parametroCodigo);
        db.close();
        return retorno != 0;
    }
    public boolean excluirUsuario(Long codigo) {
        int retorno = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String codigoString = String.valueOf(codigo);
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { codigoString};
        retorno = db.delete(TABELA_USUARIO, condicionalWhere, parametroCodigo);
        db.close();
        return retorno != 0;
    }


}
