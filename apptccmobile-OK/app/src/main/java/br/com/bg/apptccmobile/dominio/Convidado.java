package br.com.bg.apptccmobile.dominio;

/**
 * Created by 3binfo on 25/10/2016.
 */

public class Convidado {

    private Long codigo;
    private String nome;
    private String email;
    private String idade;
    private String telefone;

    public Convidado() {

    }

    public Convidado (Long codigo, String nome, String email, String telefone, String idade) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade= idade;



    }


    public Convidado (String nome, String email, String telefone, String idade) {
        super();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade= idade;


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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString (){
        return "Convidado [ codigo = " + codigo + ", nome = " + nome + ", email = " + email + ", telefone = " +  telefone
                + ", idade = " + idade  + "]";
    }


}
