package com.example.agendadecontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoContato extends SQLiteOpenHelper {
    private final  String TABELA_CONTATO = "TB_CONTATO";
    private final String TABELA_LOGIN = "TB_LOGIN";


    public DaoContato(@Nullable Context context ){

        super(context, "DB_Contato", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String comando = "CREATE TABLE "+ TABELA_CONTATO +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";

        sqLiteDatabase.execSQL(comando);

        String comandoLogin = "CREATE TABLE "+ TABELA_LOGIN +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "USUARIO VARCHAR(50)," +
                "SENHA VARCHAR(15))";
        sqLiteDatabase.execSQL(comandoLogin);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Long inserir(DtoContato dtoContato){
        ContentValues values = new ContentValues();

        values.put("NOME",dtoContato.getNome());
        values.put("EMAIL",dtoContato.getEmail());
        values.put("TELEFONE",dtoContato.getTelefone());
        values.put("ENDERECO",dtoContato.getEndereco());

        long nLinhas = getWritableDatabase().insert(TABELA_CONTATO, null, values);
        return nLinhas;
    }


    public ArrayList<DtoContato> consultarTodos(){
        String comando  = "SELECT * FROM " + TABELA_CONTATO;
        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ArrayList<DtoContato> listaContato = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoContato dtoContato = new DtoContato();
            dtoContato.setId(cursor.getInt(0));
            dtoContato.setNome(cursor.getString(1));
            dtoContato.setEmail(cursor.getString(2));
            dtoContato.setTelefone(cursor.getString(3));
            dtoContato.setEndereco(cursor.getString(4));
            listaContato.add(dtoContato);
        }

        return listaContato;
    }

    public ArrayList<DtoLogin> consultarPorUsuarioESenha(String usuario, String senha ){
        String comando  = "SELECT * FROM " + TABELA_LOGIN + " WHERE USUARIO= '" + usuario + "'AND SENHA= '" + senha +"'";
        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ArrayList<DtoLogin> listaLogin = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoLogin dtoLogin = new DtoLogin();
            dtoLogin.setId(cursor.getInt(0));
            dtoLogin.setNome(cursor.getString(1));
            dtoLogin.setUsuario(cursor.getString(2));
            dtoLogin.setSenha(cursor.getString(3));

            listaLogin.add(dtoLogin);
        }

        return listaLogin;
    }
}
