package br.org.laramara.sisnfp.servicos;

import java.io.File;

import android.content.Context;

public interface IServicoNotaFiscal {
	public boolean enviarArquivo(Context tela, File arquivo);
}
