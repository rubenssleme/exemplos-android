package br.com.bg.apptccmobile.dominio;

/**
 * Created by 3binfo on 27/10/2016.
 */

public class Usuario {
    private Long codigo;
    private String nome;
    private  String org;
    private String senha;


    public Usuario () {

    }

    public Usuario (Long codigo, String nome, String org, String senha) {
        super();
        this.codigo = codigo;
        this.org = org;
        this.nome = nome;
        this.senha = senha;
    }


    public Usuario (String nome, String org, String senha) {
        super();
        this.org = org;
        this.nome = nome;
        this.senha = senha;



    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {this.nome = nome;}

    public String getOrg() {return org;}

    public void setOrg(String org) {this.org = org;}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString (){
        return "Usuario [ codigo = " + codigo + ", nome = " + nome + ", usuario = " + org + ", senha = " +  senha
                + "]";
    }


}

