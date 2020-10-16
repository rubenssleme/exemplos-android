package com.example.meubanco;

/**
 * @author rubens.leme
 */
public interface iConexao<T> {
    void salvar(T t);

    void excluir(int id);

    void alterar(int id);

    void consultar(int id);

    void listarTodos(String nome);

}



