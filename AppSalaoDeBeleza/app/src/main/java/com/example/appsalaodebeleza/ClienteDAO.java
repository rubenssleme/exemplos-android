package com.example.appsalaodebeleza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ClienteDAO extends SQLiteOpenHelper {
    private final String TABELA_LOGIN = "Tab_Login";
    private final String TABELA_CLIENTE = "Tab_Cliente";
    private final String TABELA_SERVICO = "Tab_Servico";

    public ClienteDAO(@Nullable Context context) {
        super(context, "db_salao_beleza", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da entidade tab_login
        String comando = "CREATE TABLE " + TABELA_LOGIN + " (" +
                "ID_LOGIN INTEGER PRIMARY KEY," +
                "ID_CLIENTE INTEGER," +
                "USUARIO VARCHAR(25)," +
                "SENHA VARCHAR(8))";

        db.execSQL(comando);
        // Criação da entidade tab_cliente
        String comandoCliente = "CREATE TABLE " + TABELA_CLIENTE + "(" +
                "ID_CLIENTE INTEGER PRIMARY KEY," +
                "NOME VACHAR(100)," +
                "EMAIL VARCHAR(50)," +
                "TELEFONE VARCHAR(15)," +
                "ENDERECO VARCHAR(50))";
        db.execSQL(comandoCliente);

        // Criação da entidade tab_servico
        String comandoServico = "CREATE TABLE " + TABELA_SERVICO + "(" +
                "ID_SERVICO INTEGER PRIMARY KEY," +
                "NOME VACHAR(100)," +
                "DESCRICAO VARCHAR(50)," +
                "TEMPO VARCHAR(15))";
        db.execSQL(comandoServico);


    }














    public Long inserir(ClienteDTO clienteDTO){
        ContentValues values = new ContentValues();

        values.put("NOME",clienteDTO.getNome());
        values.put("EMAIL",clienteDTO.getEmail());
        values.put("TELEFONE",clienteDTO.getTelefone());
        values.put("ENDERECO",clienteDTO.getEndereco());

        long nLinhas = getWritableDatabase().insert(TABELA_CLIENTE, null, values);
        return nLinhas;
    }
    public ArrayList<ClienteDTO> consultarTodos(){
        String comando  = "SELECT * FROM " + TABELA_CLIENTE;
        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ArrayList<ClienteDTO> listaContato = new ArrayList<>();

        while (cursor.moveToNext()){
            ClienteDTO dtoContato = new ClienteDTO();
            dtoContato.setId(cursor.getInt(0));
            dtoContato.setNome(cursor.getString(1));
            dtoContato.setEmail(cursor.getString(2));
            dtoContato.setTelefone(cursor.getString(3));
            dtoContato.setEndereco(cursor.getString(4));
            listaContato.add(dtoContato);
        }

        return listaContato;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
