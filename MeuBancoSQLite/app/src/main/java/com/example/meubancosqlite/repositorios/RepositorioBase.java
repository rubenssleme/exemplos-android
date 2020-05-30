package com.example.meubancosqlite.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 3binfo on 25/10/2016.
 */

public abstract class RepositorioBase extends SQLiteOpenHelper {
    private  static  final int DATABASE_VERSION =1 ;
    public static final String DATABASE_NAME = "dbMeuBanco";
    private Context context;

    public RepositorioBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaUsuario(db);

    }

    private void criarTabelaUsuario (SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE usuario( ";
        sql += "id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "login TEXT, ";
        sql += "nome TEXT, ";
        sql += "senha TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }


    protected boolean salvar(String nomeTabela, ContentValues objeto){
        boolean sucesso = false;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.insert(nomeTabela, null, objeto);
            sucesso = true;
        } catch (Exception e){
            sucesso = false;
            Log.e("Erro ao salvar " + objeto, e.toString());
        }
        db.close();
        return sucesso;
    }

    /*public ResultSet obterPor (String sql) {
        ResultSet resultado = null;
        try {

        }
    } */
}
