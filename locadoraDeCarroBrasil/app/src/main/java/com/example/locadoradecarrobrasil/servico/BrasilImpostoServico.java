package com.example.locadoradecarrobrasil.servico;

public class BrasilImpostoServico implements ImpostoServico {

	@Override
	public Double imposto(Double montante) {
		if(montante<= 100.0) {
			return montante * 0.2;   //20%
		}else {
			return montante * 0.15;  //15%
		}
	}

}
