package com.example.agendadecontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DaoContato extends SQLiteOpenHelper {
   private final  String TABELA = "TB_CONTATO";

    public DaoContato(@Nullable Context context ){

        super(context, "DB_Contato", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String commando = "CREATE TABLE "+ TABELA +" (" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";

        sqLiteDatabase.execSQL(commando);
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
        long nLinhas= getWritableDatabase().insert(TABELA, null, values);

        return nLinhas;
    }
}
