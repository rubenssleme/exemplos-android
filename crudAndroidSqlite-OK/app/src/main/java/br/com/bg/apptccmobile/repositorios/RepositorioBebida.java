package br.com.bg.apptccmobile.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import br.com.bg.apptccmobile.dominio.Bebida;
import br.com.bg.apptccmobile.fabrica.FabricaBebida;

/**
 * Created by 3binfo on 25/10/2016.
 */

public class RepositorioBebida extends RepositorioBase {
    private static final String TABELA_BEBIDA ="bebida";
    private static final String CHAVE_ID = "codigo";

    public  RepositorioBebida(Context context) {super(context);}

    @Override
    public void onUpgrade (SQLiteDatabase db , int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS bebida");
        this.onCreate(db);
    }
    public boolean salvarBebida (Bebida bebida) {
        boolean salvo = salvar(TABELA_BEBIDA, FabricaBebida.criarBebidaCv(bebida));
        Log.d("salvarBebida()" , bebida.toString());
        return salvo;
    }
    public List<Bebida> obterTodos() {
        List<Bebida> bebidas = new LinkedList<Bebida>();

        String sql ="SELECT * FROM " + TABELA_BEBIDA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                bebidas.add(FabricaBebida.criarBebida(cursor));
            }while (cursor.moveToNext());
        }
        Log.d("obterTodos" , bebidas.toString());
        return bebidas;
    }
    public boolean atualizarBebida(Bebida bebida){
        int retorno = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String conditionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { String.valueOf(bebida.getCodigo())};
        ContentValues bebidaCv = FabricaBebida.criarBebidaCv(bebida);

        retorno = db.update(TABELA_BEBIDA, bebidaCv, conditionalWhere , parametroCodigo);
        db.close();
        return retorno != 0;
    }
    public boolean excluirBebida(Long codigo) {
        int retorno = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String codigoString = String.valueOf(codigo);
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { codigoString};
        retorno = db.delete(TABELA_BEBIDA, condicionalWhere, parametroCodigo);
        db.close();
        return retorno != 0;
    }


}
