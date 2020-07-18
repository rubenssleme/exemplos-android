package com.aprendaefaca.cursos;

import java.util.Arrays;
import java.util.List;

public enum Opcao {
	INICIO("Inicio", R.drawable.ic_action_good), 
	CURSOS("Cursos",R.drawable.ic_action_gamepad), 
	VIDEOAULAS("VideoAulas", R.drawable.ic_action_labels),
	ARTIGOS("Artigos",R.drawable.ic_action_search), 
	SAIR("Sair", R.drawable.ic_action_cloud);

	public String nome;
	public int imagem;

	//construtor
	Opcao(String nome, int imagem) {
		this.nome = nome;
		this.imagem = imagem;
	}
	
	//metodo para obter posição  
	public int obterPosicao() {
		return this.ordinal();
	}
	// metodo de lista para retornar as opçoes
	public static List<Opcao> obterTodos() {
		return Arrays.asList(Opcao.values());
	}

	//retorna nome
	@Override
	public String toString() {
		return nome;
	}
}
