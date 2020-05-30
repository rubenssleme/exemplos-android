package com.example.a3binfo.tccarctos;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoChamados  {

    //PARA GARANTIR UMA CONEXAO ABERTA SEMPRE QUE ESSA CLASSE FOR INSTANCIADA,
    //VAMOS UTILIZAR UM CONSTRUTOR MUITO ZICA
    Connection conexao;
    public DaoChamados() throws SQLException, ClassNotFoundException {
        Object[] a = new Object[1];
        this.conexao = (Connection) new FabricaConexao().doInBackground(a);
    }


    public ArrayList<DtoChamados> consultarTudo() throws SQLException{
        String comandoSql = "SELECT * FROM tbChamados";
        PreparedStatement ps = conexao.prepareStatement(comandoSql);
        //RESULTSET: GUARDA O RESULTADO DE UM SELECT, POSSUI LINHAS E COLUNAS
        //EXECUTEQUERY: USADO NO SELECT, POIS POSSUI RETORNO
        ResultSet resultado = ps.executeQuery();

        //INSTANCIA O ARRAYLIST:
        ArrayList<DtoChamados> ListChamados = new ArrayList<>();

        //O NEXT() RETORNA AS LINHAS DO RESULTADO, QND NAO HA MAIS LINHAS, RETORNA FALSE E SAI
        //DO WHILE. PASSAMOS O NOME DA COLUNA NO "GETTIPO" PARA INDICAR A COLUNA DA TABELA
        while(resultado.next()) {
            DtoChamados dtoChamados = new DtoChamados();
            dtoChamados.descricaoChamado = resultado.getString("descricaoChamado");
            //fazer p todos

            ListChamados.add(dtoChamados);
        }
        return ListChamados;
    }

}
