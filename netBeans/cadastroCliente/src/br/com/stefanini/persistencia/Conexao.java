package br.com.stefanini.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rubens Leme
 */
public class Conexao {

    public static String status = "Não foi possivel conectar o banco de dados...";
    static Connection connection = null;    //atributo do tipo Connection
    //Método Construtor da Classe//
    public Conexao() {
    }

    //Método de Conexão//
    public static Connection getConexaoBanco() {
         try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "mysql";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "usbw";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
             return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
             System.out.println("Nao foi possivel conectar ao Banco de Dados.");
             return null;
        }
     return connection;
    }

    // Fechar a Conexao com o banco de dados.
    public boolean fecharConexao() throws SQLException {
        try {
            Conexao.getConexaoBanco().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public void testarConexaoBanco() throws SQLException {
        //Testa sua conexão//  
        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
    }
    
    //Método que retorna o status da sua conexão//
     public static String statusConection() {
         return status;
     }
      //Método que reinicia sua conexão//
 
    public  java.sql.Connection ReiniciarConexao() throws SQLException {
        fecharConexao();
        return Conexao.getConexaoBanco();
    }
    
}

