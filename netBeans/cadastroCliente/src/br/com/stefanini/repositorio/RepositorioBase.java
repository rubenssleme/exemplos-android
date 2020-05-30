package br.com.stefanini.repositorio;

import br.com.stefanini.controlador.IRepositorioBase;
import static br.com.stefanini.persistencia.Conexao.getConexaoBanco;
import br.com.stefanini.utilitarios.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Rubens Leme
 */
public abstract class RepositorioBase<T> implements IRepositorioBase<T>{
    protected Connection conexaoBanco;
    protected  PreparedStatement comando;
    protected  static String NENHUM_REGISTRO_ENCONTRADO = "Nenhum Registro Encontrado"; 
    public RepositorioBase() {
        conexaoBanco = getConexaoBanco();
        comando = null;
    }

    public void encerrarComando(){
        try {
            comando.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void encerrarConexao(){
        try {
            conexaoBanco.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public boolean alterar(String sql) {
    boolean alterado = false;
        try {
            comando = conexaoBanco.prepareStatement(sql);
            alterado = true;
        } catch (Exception e) {
            Mensagem.exbirMensagem(e.getMessage());
            alterado = false;
        }
    return  alterado;
    }
    
    
    
    public boolean salvar(String sql) {
        boolean salvo = false;
        try {
            comando = conexaoBanco.prepareStatement(sql);
            comando.executeUpdate();
            salvo = true;
            encerrarComando();
        } catch (Exception e) {
            Mensagem.exbirMensagem(e.getMessage());
            salvo = false;
        }
    return  salvo;
    }
  
    public boolean excluir(String sql) {
     boolean excluido = false;
        try {
            comando = conexaoBanco.prepareStatement(sql);
            comando.executeUpdate();
            excluido = true;
            encerrarComando();
        } catch (Exception e) {
            Mensagem.exbirMensagem(e.getMessage());
            excluido = false;
        }
    return  excluido;
    }

    
    public ResultSet obterPorId(String sql) {
    ResultSet  resultado =  null;
        try {
            comando = conexaoBanco.prepareStatement(sql);
            resultado = comando.executeQuery();
        } catch (Exception e) {
            Mensagem.exbirMensagem(e.getMessage());
        }
    return resultado;
    }

    

}
