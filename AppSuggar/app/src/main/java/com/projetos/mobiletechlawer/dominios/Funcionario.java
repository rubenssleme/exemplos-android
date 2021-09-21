package com.projetos.mobiletechlawer.dominios;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Funcionario extends SugarRecord {


    private String nome;
    private String nascimento;
    private String sexo;
    private String naturalidade;
    private String estado;
    private String cpf;
    private String rg;
    private String ctps;
    private String serie;
    private String digito;
    private String registroProfissional;
    private String orgao;
    private String agencia;
    private String conta;
    private String grauInstrucao;
    private String estadoCivil;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String telefone;
    private String salario;
    private String pagamento;
    private String cargo;
    private String carteiraEstagiario;

    public Funcionario() {
    }

    public Funcionario(String nome, String nascimento, String sexo, String naturalidade, String estado,
                       String cpf, String rg, String ctps, String serie, String digito, String registroProfissional,
                       String orgao, String agencia, String conta, String grauInstrucao, String estadoCivil,
                       String endereco, String complemento, String bairro, String cidade, String cep, String telefone,
                       String salario, String pagamento, String cargo, String carteiraEstagiario) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.naturalidade = naturalidade;
        this.estado = estado;
        this.cpf = cpf;
        this.rg = rg;
        this.ctps = ctps;
        this.serie = serie;
        this.digito = digito;
        this.registroProfissional = registroProfissional;
        this.orgao = orgao;
        this.agencia = agencia;
        this.conta = conta;
        this.grauInstrucao = grauInstrucao;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.salario = salario;
        this.pagamento = pagamento;
        this.cargo = cargo;
        this.carteiraEstagiario = carteiraEstagiario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getGrauInstrucao() {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCarteiraEstagiario() {
        return carteiraEstagiario;
    }

    public void setCarteiraEstagiario(String carteiraEstagiario) {
        this.carteiraEstagiario = carteiraEstagiario;
    }
}