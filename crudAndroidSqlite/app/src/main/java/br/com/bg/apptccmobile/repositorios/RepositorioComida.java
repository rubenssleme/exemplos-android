package br.com.bg.apptccmobile.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import br.com.bg.apptccmobile.dominio.Comida;
import br.com.bg.apptccmobile.fabrica.FabricaComida;


/**
 * Created by 3binfo on 25/10/2016.
 */

public class RepositorioComida extends RepositorioBase {
    private static final long serialVersionUID = 46543445;
    private static final String TABELA_COMIDA ="comida";
    private static final String CHAVE_ID = "codigo";

    public  RepositorioComida(Context context) {super(context);}

    @Override
    public void onUpgrade (SQLiteDatabase db , int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS comida");
        this.onCreate(db);
    }
    public boolean salvarComida (Comida comida) {
        boolean salvo = salvar(TABELA_COMIDA, FabricaComida.criarComidaCv(comida));
        Log.d("salvarComida()" , comida.toString());
        return salvo;
    }
    public List<Comida> obterTodos() {
        List<Comida> comidas = new LinkedList<Comida>();

        String sql ="SELECT * FROM " + TABELA_COMIDA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                comidas.add(FabricaComida.criarComida(cursor));
            }while (cursor.moveToNext());
        }
        Log.d("obterTodos" , comidas.toString());
        return comidas;
    }
    public boolean atualizarComida(Comida comida){
        int retorno = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String conditionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { String.valueOf(comida.getCodigo())};
        ContentValues comidacv = FabricaComida.criarComidaCv(comida);

        retorno = db.update(TABELA_COMIDA, comidacv, conditionalWhere , parametroCodigo);
        db.close();
        return retorno != 0;
    }
    public boolean excluirComida(Long codigo) {
        int retorno = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String codigoString = String.valueOf(codigo);
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { codigoString};
        retorno = db.delete(TABELA_COMIDA, condicionalWhere, parametroCodigo);
        db.close();
        return retorno != 0;
    }



}


