package com.example.locadoradecarrobrasil.entidade;

import java.util.Date;

public class AluguelCarro {
	private Date dataRetirada;
	private Date dataDevolucao;
	
	private Veiculo veiculo;
	private Fatura fatura;

	public AluguelCarro() {

	}

	public AluguelCarro(Date dataRetirada, Date dataDevolucao, Veiculo veiculo) {
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.veiculo = veiculo;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	

}
