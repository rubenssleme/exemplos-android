package br.com.bg.apptccmobile.repositorios;

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
    public static final String DATABASE_NAME = "TccMobile";
    private Context context;

    public RepositorioBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaUsuario(db);
        criarTabelaComida(db);
        criarTabelaConvidado(db);
//        criarTabelaBebida(db);
        criarTabelaConvidado2(db);
//        criarTabelaEvento(db);
    }

    private void criarTabelaUsuario (SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE usuario( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "org TEXT, ";
        sql += "nome TEXT, ";
        sql += "senha TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }

    private void criarTabelaBebida (SQLiteDatabase db) {


        String sql = "";
        sql += "CREATE TABLE bebida( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "quantidade TEXT, ";
        sql += "descricao TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }


    private void criarTabelaComida(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE comida( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "quantidade TEXT, ";
        sql += "descricao TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }

    private void criarTabelaConvidado (SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE convidado( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "email TEXT, ";
        sql += "telefone TEXT, ";
        sql += "idade TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }


    private void criarTabelaConvidado2 (SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE convidado2( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "email TEXT, ";
        sql += "telefone TEXT, ";
        sql += "idade TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }

    private void criarTabelaEvento (SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE nomeTabela( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "campo1 TEXT, ";
        sql += "campo2 TEXT, ";
        sql += "campo3 TEXT, ";
        sql += "campo4 TEXT ";
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
