package br.com.stefanini.modelo;

import java.io.Serializable;

/**
 *
 * @author Rubens Leme
 */
public class Cliente implements Serializable{
    private Long id;
    private String nome;
    private String eMail;
    private String cpf;
    private String endereco;
    private String telefone;
    private boolean validado;

    public Cliente() {
    }

    public Cliente(Long id,String nome, String eMail, String cpf,String endereco,String telefone) {
       
        this.id  = id;
        this.nome = nome;
        this.eMail = eMail;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.validado = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
     public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean validar() {
        if((this.nome!= null)&&(this.nome.isEmpty())){
            this.validado = false;
        }
        return validado;
    }
  @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", eMail=" + eMail + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }
   
    
}
