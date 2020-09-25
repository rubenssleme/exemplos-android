package com.example.appsalaodebeleza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class ClienteDAO extends SQLiteOpenHelper {
    private final  String TABELA_LOGIN = "Tab_Login";
    private final  String TABELA_CLIENTE = "Tab_Cliente";
    public ClienteDAO(@Nullable Context context) {
        super(context, "db_salao_beleza", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "CREATE TABLE "+ TABELA_LOGIN +" (" +
                "ID_LOGIN INTEGER PRIMARY KEY," +
                "ID_CLIENTE INTEGER," +
                "USUARIO VARCHAR(25)," +
                "SENHA VARCHAR(8))";

        db.execSQL(comando);

        String comandoCliente = "CREATE TABLE " + TABELA_CLIENTE + "(" +
                "ID_CLIENTE INTEGER PRIMARY KEY," +
                "NOME VACHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";
        db.execSQL(comandoCliente);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
