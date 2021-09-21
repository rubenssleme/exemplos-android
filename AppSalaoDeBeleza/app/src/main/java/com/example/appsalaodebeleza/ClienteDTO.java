package com.example.appsalaodebeleza;

public class ClienteDTO {
    //Atributos
    private int id ;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    //Construtores
    public ClienteDTO() {

    }

    public ClienteDTO( String nome, String telefone, String email, String endereco) {
       this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    //ToString
    @Override
    public String toString() {
        return
                "Nome: " + nome     + "        " +
                 "Cel: " + telefone + "\n"       +
               "Email: " + email  ;

    }

//    @Override
//    public String toString() {
//        return "ClienteDTO{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                ", telefone='" + telefone + '\'' +
//                ", email='" + email + '\'' +
//                ", endereco='" + endereco + '\'' +
//                '}';
//    }
}
