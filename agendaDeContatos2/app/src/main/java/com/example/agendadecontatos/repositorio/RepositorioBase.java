package com.example.agendadecontatos.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public abstract class RepositorioBase extends SQLiteOpenHelper {
    /**
     * declaração versão e nome do banco de dados.
     */
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DB_Contatos";
    private Context context;

    /**
     * declaração das tabelas de banco de dados.
     */
    private final String TABELA_CONTATO = "TB_CONTATO";
    private final String TABELA_LOGIN = "TB_LOGIN";


    public RepositorioBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaLogin(db);
        criarTabelaContato(db);

    }



    private void criarTabelaContato(SQLiteDatabase db){
        String sql = "CREATE TABLE " + TABELA_CONTATO + " (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";

        db.execSQL(sql);
    }

    private void criarTabelaLogin(SQLiteDatabase db){
        String sqlLogin = "CREATE TABLE " + TABELA_LOGIN + " (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "USUARIO VARCHAR(50)," +
                "SENHA VARCHAR(15))";
        db.execSQL(sqlLogin);

    }

    public   boolean inserir(String nomeTabela, ContentValues objeto) {
        boolean sucesso = false;
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.insert(nomeTabela, null, objeto);
            sucesso = true;
        } catch (Exception e) {
            sucesso = false;
            Log.e("Erro ao salvar " + objeto, e.toString());
        }

        return sucesso;
    }
}




