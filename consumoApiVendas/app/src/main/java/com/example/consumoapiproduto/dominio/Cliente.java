package com.example.consumoapiproduto.dominio;

public class Cliente {
    private String nome;
    private String cpf;
    private String eMail;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String eMail, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.eMail = eMail;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", eMail='" + eMail + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
