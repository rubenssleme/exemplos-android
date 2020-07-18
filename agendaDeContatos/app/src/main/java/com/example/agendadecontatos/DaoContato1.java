package com.example.agendadecontatos;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DaoContato1 extends SQLiteOpenHelper {
private final  String TABELA = "TB_CLINICA";
private final  String TABELA2 = "TB_CLINICA2";

//Construtor  sistema clinica
    public DaoContato1(@Nullable Context context) {
        super(context, "DB_CLINICA", null, 1);
    }

   /* String commando = "CREATE TABLE "+ TABELA +" (" +
            "ID INTEGER PRIMARY KEY," +
            "NOME VARCHAR(100)," +
            "EMAIL VARCHAR(50)," +
            "TELEFONE VARCHAR(15)," +
            "ENDERECO VARCHAR(50))";

        sqLiteDatabase.execSQL(commando);*/


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     String comando = "CREATE TABLE " + TABELA + " ( " +
             "ID INTEGER PRIMARY KEY," +
             "NOME VARCHAR(100)," +
             "EMAIL VARCHAR(60)," +
             "TELEFONE VARCHAR(20)," +
             "ENDERECO VARCHAR(50))";

        sqLiteDatabase.execSQL(comando);

        String comando2 = "CREATE TABLE " + TABELA2 + " ( " +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(60)," +
                "TELEFONE VARCHAR(20)," +
                "ENDERECO VARCHAR(50))";

        sqLiteDatabase.execSQL(comando2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
