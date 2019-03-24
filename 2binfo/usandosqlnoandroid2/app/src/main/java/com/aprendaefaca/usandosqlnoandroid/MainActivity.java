package com.aprendaefaca.usandosqlnoandroid;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            //Criando o banco de dados
            SQLiteDatabase bdAppBanco = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criando a tabela
            bdAppBanco.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR,endereco VARCHAR,idade INT(3),sexo CHAR,email VARCHAR) ");

            // Inserir dados na tabela do banco de dados.
            bdAppBanco.execSQL("INSERT INTO  pessoas (nome,endereco,idade,sexo,email) VALUES ('Rubens Leme','Rua sem fim',44,'M','rubensLeme@')");
            bdAppBanco.execSQL("INSERT INTO  pessoas (nome,endereco,idade,sexo,email) VALUES ('Zilda Leme','Rua sem fim',44,'M','zildaLeme@')");
            bdAppBanco.execSQL("INSERT INTO  pessoas (nome,endereco,idade,sexo,email) VALUES ('Cida Leme','Rua sem fim',44,'M','cidaLeme@')");
            bdAppBanco.execSQL("INSERT INTO  pessoas (nome,endereco,idade,sexo,email) VALUES ('Toco Leme','Rua sem fim',44,'M','tocoLeme@')");
            bdAppBanco.execSQL("INSERT INTO  pessoas (nome,endereco,idade,sexo,email) VALUES ('Laura Leme','Rua sem fim',44,'M','lauraLeme@')");

            // recuperar dados com cursor usado para percorrer item a item
            Cursor cursor = bdAppBanco.rawQuery("Select * from pessoas", null);

            // recuperar o indice da coluna
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaEndereco = cursor.getColumnIndex("endereco");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaSexo = cursor.getColumnIndex("sexo");
            int indiceColunaEmail = cursor.getColumnIndex("email");

            //mover o cursor para o primeiro item
            cursor.moveToFirst();

            //testar o cursor enquanto ele for diferente de nulo
            while (cursor != null) {
                // Exibir a informação no log
                Log.i("Retorno - Nome: ", cursor.getString(indiceColunaNome));
                Log.i("Retorno - Endereço: ", cursor.getString(indiceColunaEndereco));
                Log.i("Retorno - Idade: ", cursor.getString(indiceColunaIdade));
                Log.i("Retorno - Sexo: ", cursor.getString(indiceColunaSexo));
                Log.i("Retorno - EMail: ", cursor.getString(indiceColunaEmail));

                //mover para proxima pessoa.
                cursor.moveToNext();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
