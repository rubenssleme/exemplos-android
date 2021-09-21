package br.com.bg.apptccmobile.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import br.com.bg.apptccmobile.dominio.Comida;

/**
 * Created by 3binfo on 27/10/2016.
 */

public class FabricaComida {

    public static Comida criarComida (Cursor cursor) {

        Comida comida = new Comida();

        comida.setCodigo(Long.parseLong(cursor.getString(0)));
        comida.setNome(cursor.getString(1));
        comida.setQuantidade(cursor.getString(2));
        comida.setDescricao(cursor.getString(3));


        return comida;

    }

    public static ContentValues criarComidaCv (Comida comida) {
        ContentValues comidaCv = new ContentValues();

        comidaCv.put("nome", comida.getNome());
        comidaCv.put("quantidade", comida.getQuantidade());
        comidaCv.put("descricao", comida.getDescricao());

        return comidaCv;

    }
}
