package br.org.laramara.sisnfp.utilitarios;

import java.io.File;

import android.os.Environment;

public class ArquivoUtils {
	public static File obterArquivo(String local, String nome, boolean criarSeNecessario) {
		File localArmazenamento = new File(Environment.getExternalStoragePublicDirectory(local) + "/" + nome);

		if (criarSeNecessario) {
			if (!localArmazenamento.exists()) {
				localArmazenamento.mkdirs();
			}
		}
		return localArmazenamento;
	}

	public static File criarArquivoComDataEHora(String diretorio, String nome, String extensao) {
		String dataEHora = DataHoraUtils.obtemDataHoraAtualComUnderline();

		String nomeImagem = diretorio + "/" + nome + dataEHora + extensao;

		File arquivoCriado = new File(nomeImagem);
		return arquivoCriado;
	}

	public static void excluirArquivo(String local, String diretorio) {
		File diretorioObtido = new File(Environment.getExternalStoragePublicDirectory(local) + "/" + diretorio);
		if (diretorioObtido.isDirectory()) {
			File[] arquivosObtidos = diretorioObtido.listFiles();
			for (File arquivoObtido : arquivosObtidos) {
				arquivoObtido.delete();
			}
			diretorioObtido.delete();
		}
	}

}
