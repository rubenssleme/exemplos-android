package br.com.bg.apptccmobile.repositorios;

import android.content.Context;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bg.apptccmobile.dominio.Bebida;
import br.com.bg.apptccmobile.fabrica.FabricaConexao;

/**
 * Created by 3binfo on 25/10/2016.
 */

public class RepositorioBebida {
    private static final String TABELA_BEBIDA ="bebida";
    private static final String CHAVE_ID = "id";
    PreparedStatement ps = null;
    Connection conexao ;


    public  RepositorioBebida(Context context) {
        Object[] a = new Object[1];
         this.conexao = (java.sql.Connection) new FabricaConexao().doInBackground(a);
    }

    public boolean salvarBebida (Bebida bebida) {
        String sqlInsert =  "insert into" + TABELA_BEBIDA + " values(?,?,?,?);";
        boolean salvo = false;
        try  {
            ps = conexao.prepareStatement(sqlInsert);
            ps.setString(1, bebida.getNome());
            ps.setString(2, bebida.getDescricao());
            ps.setString(3, bebida.getQuantidade());
            salvo = true;
        } catch (SQLException e){
            e.printStackTrace();
        }

        Log.d("salvarBebida()" , bebida.toString());
        return salvo;
    }
   /* public List<Bebida> obterTodos() {
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
    }*/


}
