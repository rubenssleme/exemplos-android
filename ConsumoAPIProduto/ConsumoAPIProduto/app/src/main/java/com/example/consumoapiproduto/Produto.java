package com.example.consumoapiproduto;
public class Produto {
    private String id;
    private String nome;
    private String quantidade;
    private String valor;
    public Produto() {

    }

    public Produto(String id, String nome, String quantidade, String valor) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
