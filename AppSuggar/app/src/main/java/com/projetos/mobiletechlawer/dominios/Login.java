package com.projetos.mobiletechlawer.dominios;

import com.orm.SugarRecord;
import com.orm.dsl.Table;


@Table
public class Login extends SugarRecord {

    private String usuario;
    private String senha;

    public Login() {
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
