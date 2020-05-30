package br.com.stefanini.repositorio;

import br.com.stefanini.modelo.Cliente;
import br.com.stefanini.utilitarios.Mensagem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f665152
 */
public class RepositorioCliente extends RepositorioBase<Cliente>{

    private static final String COMANDO_BASE = " SELECT * From Cliente ";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_CPF = "cpf";
    private static final String COLUNA_ENDERECO = "endereco";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String CONDICIONAL_WHERE = " WHERE ";


    public boolean incluir(Cliente cliente) {
          String nome = cliente.getNome();
        String email = cliente.geteMail();
        String cpf = cliente.getCpf();
        String endereco = cliente.getEndereco();
        String telefone = cliente.getTelefone();

        String sql = "INSERT INTO Cliente (" + COLUNA_ID + "," + COLUNA_NOME
                + "," + COLUNA_CPF + ", " + COLUNA_ENDERECO + ", "
                + COLUNA_EMAIL + ", " + COLUNA_TELEFONE
                + ") VALUES (DEFAULT, '" + nome + "','" + cpf + "','"
                + endereco + "','" + email + "','" + telefone + "')";
       
        
        if (cliente.validar()) {
            return super.salvar(sql);
        }else{
            return false;
        }


    }
    
    public boolean alterar(Cliente cliente) {
        String id = cliente.getId().toString();
        String nome = cliente.getNome();
        String cpf = cliente.getCpf();
        String endereco = cliente.getEndereco();
        String email = cliente.geteMail();
        String telefone = cliente.getTelefone();

        String sql = "UPDATE Cliente SET " + COLUNA_NOME + " = '" + nome
                + "', " + COLUNA_CPF + " = '" + cpf + "', "
                + COLUNA_ENDERECO + " = '" + endereco + "', "
                + COLUNA_EMAIL + " = '" + email + "', " + COLUNA_TELEFONE
                + " = '" + telefone + "'" + CONDICIONAL_WHERE + COLUNA_ID
                + " = " + id;

        return super.alterar(sql);
    }

    public boolean excluir(Long id) {
        String sql = "DELETE FROM Cliente " + CONDICIONAL_WHERE + COLUNA_ID
                + " = " + String.valueOf(id);
        return super.excluir(sql);
    }

    public List<Cliente> obterTodos() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            ResultSet clientesObtido = super.obterPorId(COMANDO_BASE);

            while (clientesObtido.next()) {
                Cliente cliente = new Cliente();

                Long id = clientesObtido.getLong(COLUNA_ID);
                String nome = clientesObtido.getString(COLUNA_NOME);
                String cpf = clientesObtido.getString(COLUNA_CPF);
                String endereco = clientesObtido
                        .getString(COLUNA_ENDERECO);
                String email = clientesObtido.getString(COLUNA_EMAIL);
                String telefone = clientesObtido.getString(COLUNA_TELEFONE);

                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                cliente.seteMail(email);
                cliente.setTelefone(telefone);

                clientes.add(cliente);
            }
            encerrarComando();
        } catch (SQLException e) {
            Mensagem.exbirMensagem(e.getMessage());
        }
        return clientes;
    }

    public Cliente obterPorId(Long id) {
        Cliente c = null;
        try {
            String sql = COMANDO_BASE + CONDICIONAL_WHERE + COLUNA_ID + " = "
                    + String.valueOf(id);

            ResultSet clienteObtido = super.obterPorId(sql);

            if (clienteObtido.next()) {
                id = clienteObtido.getLong(COLUNA_ID);
                String nome = clienteObtido.getString(COLUNA_NOME);
                String cpf = clienteObtido.getString(COLUNA_CPF);
                String endereco = clienteObtido
                        .getString(COLUNA_ENDERECO);
                String email = clienteObtido.getString(COLUNA_EMAIL);
                String telefone = clienteObtido.getString(COLUNA_TELEFONE);

                c = new Cliente();
                c.setId(id);
                c.setNome(nome);
                c.setCpf(cpf);
                c.setEndereco(endereco);
                c.seteMail(email);
                c.setTelefone(telefone);
            } else {
                Mensagem.exbirMensagem("Nenhum registro foi encontrado.");
            }
        } catch (SQLException e) {
            Mensagem.exbirMensagem(e.getMessage());
        }

        return c;
    }

    public List<Cliente> pesquisar(Cliente cliente) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "";

        Long id = cliente.getId();
        String nome = cliente.getNome();
        String cpf = cliente.getCpf();
        String endereco = cliente.getEndereco();
        String email = cliente.geteMail();
        String telefone = cliente.getTelefone();

        sql += COMANDO_BASE;

        if (cliente != null) {
            sql += CONDICIONAL_WHERE;
        }

        if (nome != null && !nome.isEmpty()) {
            sql += " nome = '" + nome + "'";
        } else if (cpf != null && !cpf.isEmpty()) {
            sql += " cpf = '" + cpf + "'";
        } else if (endereco != null && !endereco.isEmpty()) {
            sql += " endereco = '" + endereco + "'";
        } else if (email != null && !email.isEmpty()) {
            sql += " email = '" + email + "'";
        } else if (telefone != null && !telefone.isEmpty()) {
            sql += " telefone = '" + telefone + "'";
        }
        Cliente c = null;
        try {
            ResultSet clienteObtido = super.obterPorId(sql);

            while (clienteObtido.next()) {
                id = clienteObtido.getLong(COLUNA_ID);
                nome = clienteObtido.getString(COLUNA_NOME);
                cpf = clienteObtido.getString(COLUNA_CPF);
                endereco = clienteObtido.getString(COLUNA_ENDERECO);
                email = clienteObtido.getString(COLUNA_EMAIL);
                telefone = clienteObtido.getString(COLUNA_TELEFONE);

                c = new Cliente();

                c.setId(id);
                c.setNome(nome);
                c.setCpf(cpf);
                c.setEndereco(endereco);
                c.seteMail(email);
                c.setTelefone(telefone);

                clientes.add(c);
            }
        } catch (SQLException e) {
            Mensagem.exbirMensagem(e.getMessage());
        }

        return clientes;
    }
}
