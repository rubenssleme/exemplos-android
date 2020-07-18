package br.org.laramara.sisnfp.servicos;

import java.io.File;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import android.content.Context;

@EBean(scope = Scope.Singleton)
public class ServicoNotaFiscal extends Servico implements IServicoNotaFiscal {

	@Override
	public boolean enviarArquivo(Context tela, File imagem) {
		boolean sucesso = false;
		try {
			MultipartEntity entidade = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			entidade.addPart("uploaded_file", new FileBody(imagem));

			HttpResponse resultado = super.executar(tela, entidade);
			HttpEntity resultadoEntidade = resultado.getEntity();
			long resultadoEntidadeTamanho = resultadoEntidade.getContentLength();
			if (resultadoEntidade != null) {
				resultadoEntidade.consumeContent();
			}
			sucesso = resultadoEntidadeTamanho != 0;
		} catch (Exception e) {
			sucesso = false;
		}
		return sucesso;
	}

}