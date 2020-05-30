package br.com.bg.apptccmobile.repositorios;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.bg.apptccmobile.fabrica.FabricaConexao;

public class RepositorioBaseMysql extends FabricaConexao {

    //PARA GARANTIR UMA CONEXAO ABERTA SEMPRE QUE ESSA CLASSE FOR INSTANCIADA,
    //VAMOS UTILIZAR UM CONSTRUTOR MUITO ZICA

    Connection conexao;
    public Connection retornaConexao() {
        Object[] a = new Object[1];
       return this.conexao = (Connection) new FabricaConexao().doInBackground(a);
    }


}
