package br.org.laramara.sisnfp.fabricas;

import java.io.File;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import android.content.Context;
import android.os.Environment;
import br.org.laramara.sisnfp.utilitarios.ArquivoUtils;
import br.org.laramara.sisnfp.utilitarios.Configuracao;

@EBean(scope = Scope.Singleton)
public class FabricaNotaFiscal {

	public static File criarNotaFiscal(Context contexto) {
		String PREFIXO_NOTA_FISCAL = "NF_";
		String caminhoDiretorioAlbum = ArquivoUtils
				.obterArquivo(Environment.DIRECTORY_DCIM,
						Configuracao.obterConfiguracao(contexto, Configuracao.DIRETORIO_NOTAS_FISCAIS_UPLOAD), true)
				.getAbsolutePath();

		File notaFiscal = ArquivoUtils.criarArquivoComDataEHora(caminhoDiretorioAlbum, PREFIXO_NOTA_FISCAL,
				"." + Configuracao.obterConfiguracao(contexto, Configuracao.EXTENSAO_NOTA_FISCAL_UPLOAD));

		return notaFiscal;
	}
}
