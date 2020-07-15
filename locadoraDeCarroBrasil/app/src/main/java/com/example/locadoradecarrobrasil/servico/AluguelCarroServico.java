package com.example.locadoradecarrobrasil.servico;


import com.example.locadoradecarrobrasil.entidade.AluguelCarro;
import com.example.locadoradecarrobrasil.entidade.Fatura;

public class AluguelCarroServico {
	private Double precoPorDia;
	private Double precoPorHora;
	
	private ImpostoServico impostoServico;

	public AluguelCarroServico(Double precoPorDia, Double precoPorHora, ImpostoServico impostoServico) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoServico = impostoServico;
	}
	
	public void processamentoFatura(AluguelCarro aluguelCarro) {
		long t1 = aluguelCarro.getDataRetirada().getTime();
		long t2 = aluguelCarro.getDataDevolucao().getTime();
		
		double horas = (double)(t2-t1)/1000 /60 / 60;
		
		double pagamentoSemImposto;
		
		if(horas<=12.0) {
			pagamentoSemImposto = precoPorHora * Math.ceil(horas);
		}else {
			pagamentoSemImposto = precoPorDia * Math.ceil(horas/24);
		}
		
		double imposto = impostoServico.imposto(pagamentoSemImposto);
		
		aluguelCarro.setFatura(new Fatura(pagamentoSemImposto,imposto));
		
	}
	
	

}
