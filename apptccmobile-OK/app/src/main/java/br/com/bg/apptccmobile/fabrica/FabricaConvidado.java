package br.com.bg.apptccmobile.fabrica;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.bg.apptccmobile.dominio.Convidado;


public class FabricaConvidado {

    public static Convidado criarConvidado (Cursor cursor) {
        Convidado convidado = new Convidado();

        convidado.setCodigo(Long.parseLong(cursor.getString(0)));
        convidado.setNome(cursor.getString(1));
        convidado.setEmail(cursor.getString(3));
        convidado.setTelefone(cursor.getString(4));
        convidado.setIdade(cursor.getString(2));


        return convidado;
    }

    public static ContentValues criarConvidadoCv(Convidado convidado) {
        ContentValues convidadoCv = new ContentValues();

        convidadoCv.put("nome", convidado.getNome());
        convidadoCv.put("email", convidado.getEmail());
        convidadoCv.put("telefone", convidado.getTelefone());
        convidadoCv.put("idade", convidado.getIdade());


        return  convidadoCv;

    }
}
