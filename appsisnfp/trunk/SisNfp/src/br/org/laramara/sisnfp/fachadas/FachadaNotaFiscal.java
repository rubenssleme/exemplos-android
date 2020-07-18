package br.org.laramara.sisnfp.fachadas;

import java.io.File;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import android.app.Activity;
import br.org.laramara.sisnfp.servicos.IServicoNotaFiscal;
import br.org.laramara.sisnfp.servicos.ServicoNotaFiscal;
import br.org.laramara.sisnfp.utilitarios.ImageUtils;

@EBean(scope = Scope.Singleton)
public class FachadaNotaFiscal {
	@Bean(value = ServicoNotaFiscal.class)
	public IServicoNotaFiscal servicoNotaFiscal;

	public boolean enviarArquivo(Activity tela, File arquivo) {
		File arquivoCompactado = ImageUtils.compactarArquivo(arquivo);
		boolean sucesso = servicoNotaFiscal.enviarArquivo(tela, arquivoCompactado);
		return sucesso;
	}

}
