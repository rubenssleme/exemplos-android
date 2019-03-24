package com.projetos.mobiletechlawer.dominios;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Compromisso extends SugarRecord {

    private String titulo;
    private String data;
    private Boolean diaTodo;
    private String local;
    private String descricao;

    public Compromisso() {
    }

    public Compromisso(String titulo, String data, Boolean diaTodo, String local, String descricao) {
        this.titulo = titulo;
        this.data = data;
        this.diaTodo = diaTodo;
        this.local = local;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getDiaTodo() {
        return diaTodo;
    }

    public void setDiaTodo(Boolean diaTodo) {
        this.diaTodo = diaTodo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
