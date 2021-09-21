package com.example.pqsumiu;

public class DtoUsuario {
    int id, nivel;

    public DtoUsuario(){

    }

    public DtoUsuario(int nivel, String nome, String usuario, String senha) {
        this.nivel = nivel;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    String nome, usuario, senha;




    @Override
    public String toString() {
        return nome + "-" + usuario;
    }
}