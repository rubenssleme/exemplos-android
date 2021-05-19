package com.example.exemplobdnovo.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbExemploBdNovo";
    private Context context;

    //Construtor obrigatorio
    public RepositorioBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaUsuario(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void criarTabelaUsuario(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE tbUsuario( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "login TEXT, ";
        sql += "senha TEXT ";
        sql += ")";

        db.execSQL(sql);
    }

    public boolean salvar(String nomeTabela, ContentValues cv){
        boolean sucesso = false;
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.insert(nomeTabela, null, cv);
            sucesso = true;
        } catch (Exception e){
            sucesso = false;
            Log.e("Erro ao salvar " + cv, e.toString());
        }
        db.close();
        return sucesso;


    }
}
