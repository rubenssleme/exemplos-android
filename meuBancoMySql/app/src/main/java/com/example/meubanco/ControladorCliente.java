package com.example.meubanco;

public class ControladorCliente implements iConexao<Cliente> {
    Conexao conexao = new Conexao();

    @Override
    public void salvar(Cliente cliente) {
             conexao.Incluir(cliente);
    }

    @Override
    public void excluir(int id) {

    }

    @Override
    public void alterar(int id) {


    }

    @Override
    public void consultar(int id) {


    }
    public void consultar(Cliente cliente){
        conexao.Pesquisar(cliente);
        System.out.println(cliente.toString());
    }

    @Override
    public void listarTodos(String nome) {

    }
}
