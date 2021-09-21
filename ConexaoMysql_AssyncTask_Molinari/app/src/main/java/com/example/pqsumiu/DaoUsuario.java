package com.example.pqsumiu;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoUsuario {

       Connection connection = FabricaConexao.connection;


    public boolean login(String usuario, String senha) throws SQLException {
        String comando = "select * from tb_usuario where usuario = ? and senha = ?";
        PreparedStatement ps = connection.prepareStatement(comando);
        ps.setString(1,usuario);
        ps.setString(2,senha);
        ResultSet resultSet = ps.executeQuery();
        //retorna true se hover linha ou false se não houver
        return resultSet.next();
    }

    public boolean inserir(DtoUsuario dtoUsuario) throws SQLException {
        String comando = "insert into tb_usuario values(default,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(comando);
        ps.setString(1,dtoUsuario.nome);
        ps.setString(2,dtoUsuario.usuario);
        ps.setString(3,dtoUsuario.senha);
        ps.setInt(4,dtoUsuario.nivel);
        return ps.execute();
    }

    public boolean deletar(int id) throws SQLException {
        String comando = "delete from tb_usuario where id=?";
        PreparedStatement ps = connection.prepareStatement(comando);
        ps.setInt(1,id);
        return ps.execute();
    }

    public ArrayList<DtoUsuario> consultar() throws SQLException {
        String comando = "select * from tb_usuario";
        PreparedStatement ps;
        ps = connection.prepareStatement(comando);
        ResultSet resultSet = ps.executeQuery();
        ArrayList<DtoUsuario> listUsuarios = new ArrayList();
        while(resultSet.next()){
            DtoUsuario dtoUsuario = new DtoUsuario();
            dtoUsuario.nome=resultSet.getString("nome");
            dtoUsuario.usuario=resultSet.getString("usuario");
            listUsuarios.add(dtoUsuario);
        }
        return listUsuarios;

    }

}