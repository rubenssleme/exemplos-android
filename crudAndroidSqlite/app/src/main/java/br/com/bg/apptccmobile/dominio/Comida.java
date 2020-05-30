package br.com.bg.apptccmobile.dominio;

/**
 * Created by 3binfo on 27/10/2016.
 */

public class Comida {

    private Long codigo;
    private String nome;
    private String quantidade;
    private String descricao;


    public Comida () {

    }

    public Comida (Long codigo, String nome, String quantidade, String descricao) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;


    }
    public Comida (String nome, String quantidade, String descricao) {
        super();
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;


    }

    public Long getCodigo() {return codigo;}

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString (){
        return "Comida [ codigo = " + codigo + ", nome = " + nome + ", quantidade = " + quantidade + ", descrição = " +  descricao + "]";
    }
}
