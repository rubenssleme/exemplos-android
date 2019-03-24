package br.com.bg.apptccmobile.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import br.com.bg.apptccmobile.dominio.Convidado2;
import br.com.bg.apptccmobile.fabrica.FabricaConvidado2;

/**
 * Created by 3binfo on 25/11/2016.
 */

public class RepositorioConvidado2 extends RepositorioBase {
    private static final String TABELA_CONVIDADO2 ="convidado2";
    private static final String CHAVE_ID = "codigo";


    public  RepositorioConvidado2(Context context) {super(context);}


    @Override
    public void onUpgrade (SQLiteDatabase db , int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS convidado2");
        this.onCreate(db);
    }
    public boolean salvarConvidado2 (Convidado2 convidado2) {
        boolean salvo = salvar(TABELA_CONVIDADO2, FabricaConvidado2.criarConvidadoCv2(convidado2));
        Log.d("salvarConvidado2()" , convidado2.toString());
        return salvo;
    }
    public List<Convidado2> obterTodos() {
        List<Convidado2> convidados2 = new LinkedList<Convidado2>();

        String sql ="SELECT * FROM " + TABELA_CONVIDADO2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                convidados2.add(FabricaConvidado2.criarConvidado2(cursor));
            }while (cursor.moveToNext());
        }
        Log.d("obterTodos" , convidados2.toString());
        return convidados2;
    }
    public boolean atualizarConvidado2(Convidado2 convidado2){
        int retorno = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String conditionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { String.valueOf(convidado2.getCodigo())};
        ContentValues convidadocv2 = FabricaConvidado2.criarConvidadoCv2(convidado2);

        retorno = db.update(TABELA_CONVIDADO2, convidadocv2, conditionalWhere , parametroCodigo);
        db.close();
        return retorno != 0;
    }
    public boolean excluirConvidado2(Long codigo) {
        int retorno = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String codigoString = String.valueOf(codigo);
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { codigoString};
        retorno = db.delete(TABELA_CONVIDADO2, condicionalWhere, parametroCodigo);
        db.close();
        return retorno != 0;
    }
}
