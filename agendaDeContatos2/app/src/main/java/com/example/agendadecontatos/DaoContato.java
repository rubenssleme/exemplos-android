package com.example.agendadecontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoContato extends SQLiteOpenHelper {
   private final  String TABELA = "TB_CONTATO";

    /**
     *
     * @param context
     */
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
        long nLinhas = getWritableDatabase().insert(TABELA, null, values);
        return nLinhas;
    }
    public ArrayList<DtoContato> consultarTodos(){
        String comando  = "SELECT * FROM " + TABELA;
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
}
