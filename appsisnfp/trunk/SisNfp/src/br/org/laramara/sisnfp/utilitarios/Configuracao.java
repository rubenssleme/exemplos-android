package br.org.laramara.sisnfp.utilitarios;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class Configuracao {

	private static Logger logger = Logger.getLogger(Configuracao.class
			.getName());

	private static Properties arquivoPropriedades;

	public static final String ARQUIVO_CONFIGURACAO = "application.properties";

	public static final String IP_LINK_UPLOAD = "ip.link.upload";
	public static final String NUMERO_PORTA_UPLOAD = "numero.porta.upload";
	public static final String SCRIPT_UPLOAD = "script.upload";
	public static final String NOTAS_FISCAIS_UPLOAD = "notas.fiscais.upload";
	public static final String DIRETORIO_NOTAS_FISCAIS_UPLOAD = "diretorio.notas.fiscais.upload";
	public static final String DIRETORIO_RAIZ_UPLOAD = "diretorio.raiz.upload";
	public static final String EXTENSAO_NOTA_FISCAL_UPLOAD = "extensao.nota.fiscal.upload";
	
	private Configuracao() {
	}

	private synchronized static void inicializar(Object objeto) {
		if (arquivoPropriedades == null)
			try {
				arquivoPropriedades = new Properties();
				Resources resources = ((Context) objeto).getResources();
				AssetManager assetManager = resources.getAssets();
				InputStream inputStream = assetManager
						.open(ARQUIVO_CONFIGURACAO);
				arquivoPropriedades.load(inputStream);
			} catch (Exception e) {
				logger.severe(e.getMessage());
			}
	}

	public synchronized static String obterConfiguracao(Object objeto,
			String chave) {
		inicializar(objeto);
		return arquivoPropriedades.getProperty(chave);
	}
}
