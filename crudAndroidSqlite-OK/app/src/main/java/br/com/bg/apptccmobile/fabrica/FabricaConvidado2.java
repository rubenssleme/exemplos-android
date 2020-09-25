package br.com.bg.apptccmobile.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import br.com.bg.apptccmobile.dominio.Convidado2;

/**
 * Created by 3binfo on 25/11/2016.
 */

public class FabricaConvidado2 {

    public static Convidado2 criarConvidado2 (Cursor cursor) {
        Convidado2 convidado2 = new Convidado2();

        convidado2.setCodigo(Long.parseLong(cursor.getString(0)));
        convidado2.setNome(cursor.getString(1));
        convidado2.setEmail(cursor.getString(3));
        convidado2.setTelefone(cursor.getString(4));
        convidado2.setIdade(cursor.getString(2));


        return convidado2;
    }

    public static ContentValues criarConvidadoCv2(Convidado2 convidado2) {
        ContentValues convidadoCv2 = new ContentValues();

        convidadoCv2.put("nome", convidado2.getNome());
        convidadoCv2.put("email", convidado2.getEmail());
        convidadoCv2.put("telefone", convidado2.getTelefone());
        convidadoCv2.put("idade", convidado2.getIdade());


        return  convidadoCv2;

    }
}
