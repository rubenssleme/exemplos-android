package com.example.mybanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rubens Leme
 */
public class Conexao extends _Default implements Runnable {

    /*
     * Definição das informacoes necessarias para conexao a banco
     */

    // Driver de conexao ao MySql
    private Connection conn;
    private String db = "dbPagbank";
    private String host = "localhost";
    private int porta = 3306;
    private String servidor = "com.mysql.cj.jdbc.Driver";
    // url que identifica o banco
    private String urlBanco = "jdbc:mysql://%s:%d/%s";
    // login de usuario no banco
    private String usuarioBanco = "root";
    // senha do usuario no banco
    private String senhaBanco = "root";

    public Conexao() {
        super();
        this.urlBanco = String.format(this.urlBanco,this.host, this.porta, this.db);

        this.conecta();
        this.disconecta();
    }

    @Override
    public void run() {
        try{
            Class.forName(servidor);
            this.conn = DriverManager.getConnection(this.urlBanco,this.usuarioBanco,this.senhaBanco);
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }
    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void disconecta(){
        if (this.conn!= null){
            try{
                this.conn.close();
            }catch (Exception e){

            }finally {
                this.conn = null;
            }
        }
    }
    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }


   /* // *** Metodo de teste de conexao
    public boolean testaConexao() {

        // Declaracao e inicializacao de uma variavel de retorno ("true" se conectou ou "false" se ocorreu erro)
        boolean ret = false;
        // Declaracao e inicializacao de uma variavel do tipo Connection que armazenara a conexao estabelecida
        Connection con = null;

        // Tenta executar as instrucoes em try
        try {

            // Quando o método estático Class.forName() é utilizado, o Class Loader tenta inicializar esta classe.
            // Esta classe (que é o nosso driver jdbc) possui um bloco inicializador estático que irá registrar
            // essa classe como um driver JDBC, avisando o java.sql.DriverManager, pelo método registerDriver.
            Class.forName(servidor);

            // A classe DriverManager abre uma conexao com o banco de dados.
            // A classe Connection designa um objeto, no caso con, para receber a conexao estabelecida
            con = DriverManager.getConnection(urlBanco, usuarioBanco, senhaBanco);

            // Seta a variavel de retorno com true
            ret = true;

            // Se der erro no try verifica qual erro foi gerado
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // se ClassNotFoundException o servidor (MySql) não foi encontrado,

        } catch (SQLException e) {
            e.printStackTrace();
            // se der outro erro, apresenta a descrição do erro utilizando
            // a classe SQLException que trata de erros scripts slq
        }

        return ret;
    }*/


}

