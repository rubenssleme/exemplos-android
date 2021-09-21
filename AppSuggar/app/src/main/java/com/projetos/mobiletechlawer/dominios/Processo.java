package com.projetos.mobiletechlawer.dominios;

import com.orm.SugarRecord;
import com.orm.dsl.Table;


@Table
public class Processo extends SugarRecord {

    private String numero;
    private String assunto;
    private Cliente cliente;
    private String acao;
    private String situacao;
    private String valor;
    private String pasta;
    private String condicao;
    private String parteContraria;
    private String advogadoContrario;
    private String tipoJustica;
    private String regiao;
    private String secao;
    private String subsecao;
    private String cidadeComarca;
    private String foro;
    private String vara;
    private String observacoes;

    public Processo() {
    }

    public Processo(String numero, String assunto, Cliente cliente, String acao, String situacao,
                    String valor, String pasta, String condicao, String parteContraria, String advogadoContrario,
                    String tipoJustica, String regiao, String secao, String subsecao, String cidadeComarca,
                    String foro, String vara, String observacoes) {

        this.numero = numero;
        this.assunto = assunto;
        this.cliente = cliente;
        this.acao = acao;
        this.situacao = situacao;
        this.valor = valor;
        this.pasta = pasta;
        this.condicao = condicao;
        this.parteContraria = parteContraria;
        this.advogadoContrario = advogadoContrario;
        this.tipoJustica = tipoJustica;
        this.regiao = regiao;
        this.secao = secao;
        this.subsecao = subsecao;
        this.cidadeComarca = cidadeComarca;
        this.foro = foro;
        this.vara = vara;
        this.observacoes = observacoes;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getParteContraria() {
        return parteContraria;
    }

    public void setParteContraria(String parteContraria) {
        this.parteContraria = parteContraria;
    }

    public String getAdvogadoContrario() {
        return advogadoContrario;
    }

    public void setAdvogadoContrario(String advogadoContrario) {
        this.advogadoContrario = advogadoContrario;
    }

    public String getTipoJustica() {
        return tipoJustica;
    }

    public void setTipoJustica(String tipoJustica) {
        this.tipoJustica = tipoJustica;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getSubsecao() {
        return subsecao;
    }

    public void setSubsecao(String subsecao) {
        this.subsecao = subsecao;
    }

    public String getCidadeComarca() {
        return cidadeComarca;
    }

    public void setCidadeComarca(String cidadeComarca) {
        this.cidadeComarca = cidadeComarca;
    }

    public String getForo() {
        return foro;
    }

    public void setForo(String foro) {
        this.foro = foro;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
