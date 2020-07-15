package com.example.locadoradecarrobrasil.entidade;

public class Fatura {

	private Double valorSemImposto;
	private Double Imposto;
	public Fatura() {
		
	}
	public Fatura(Double valorSemImposto, Double imposto) {
		
		this.valorSemImposto = valorSemImposto;
		Imposto = imposto;
	}
	public Double getValorSemImposto() {
		return valorSemImposto;
	}
	public void setValorSemImposto(Double valorSemImposto) {
		this.valorSemImposto = valorSemImposto;
	}
	public Double getImposto() {
		return Imposto;
	}
	public void setImposto(Double imposto) {
		Imposto = imposto;
	}
	public Double getTotalDePagamento() {
		return getValorSemImposto() + getImposto();
	}
	
}
