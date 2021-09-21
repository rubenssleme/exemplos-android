package br.com.bg.apptccmobile.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import br.com.bg.apptccmobile.dominio.Bebida;



public class FabricaBebida {

    public static Bebida criarBebida (Cursor cursor) {

        Bebida bebida = new Bebida ();

        bebida.setCodigo(Long.parseLong(cursor.getString(0)));
        bebida.setNome(cursor.getString(1));
        bebida.setQuantidade(cursor.getString(2));
        bebida.setDescricao(cursor.getString(2));



        return bebida;


    }

    public static ContentValues criarBebidaCv (Bebida bebida){
        ContentValues bebidaCv = new ContentValues();

        bebidaCv.put("nome", bebida.getNome());
        bebidaCv.put ("quantidade", bebida.getQuantidade());
        bebidaCv.put ("descrição", bebida.getDescricao());


        return bebidaCv;
    }
}
