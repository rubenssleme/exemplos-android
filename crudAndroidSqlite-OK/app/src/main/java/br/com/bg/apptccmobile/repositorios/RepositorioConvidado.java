package br.com.bg.apptccmobile.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import br.com.bg.apptccmobile.dominio.Convidado;
import br.com.bg.apptccmobile.fabrica.FabricaConvidado;

/**
 * Created by 3binfo on 25/10/2016.
 */

public class RepositorioConvidado extends RepositorioBase {
    private static final String TABELA_CONVIDADO ="convidado";
    private static final String CHAVE_ID = "codigo";


    public  RepositorioConvidado(Context context) {super(context);}

    @Override
    public void onUpgrade (SQLiteDatabase db , int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS convidado");
        this.onCreate(db);
    }
    public boolean salvarConvidado (Convidado convidado) {
        boolean salvo = salvar(TABELA_CONVIDADO, FabricaConvidado.criarConvidadoCv(convidado));
        Log.d("salvarConvidado()" , convidado.toString());
        return salvo;
    }
    public List<Convidado> obterTodos() {
        List<Convidado> convidados = new LinkedList<Convidado>();

        String sql ="SELECT * FROM " + TABELA_CONVIDADO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                convidados.add(FabricaConvidado.criarConvidado(cursor));
            }while (cursor.moveToNext());
        }
        Log.d("obterTodos" , convidados.toString());
        return convidados;
    }
    public boolean atualizarConvidado(Convidado convidado){
        int retorno = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String conditionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { String.valueOf(convidado.getCodigo())};
        ContentValues convidadocv = FabricaConvidado.criarConvidadoCv(convidado);

        retorno = db.update(TABELA_CONVIDADO, convidadocv, conditionalWhere , parametroCodigo);
        db.close();
        return retorno != 0;
    }
    public boolean excluirConvidado(Long codigo) {
        int retorno = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String codigoString = String.valueOf(codigo);
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroCodigo = new String[] { codigoString};
        retorno = db.delete(TABELA_CONVIDADO, condicionalWhere, parametroCodigo);
        db.close();
        return retorno != 0;
    }


}
