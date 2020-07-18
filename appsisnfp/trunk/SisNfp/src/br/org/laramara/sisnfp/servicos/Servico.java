package br.org.laramara.sisnfp.servicos;

import java.io.IOException;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.androidannotations.annotations.HttpsClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.params.CoreConnectionPNames;

import android.content.Context;
import br.org.laramara.sisnfp.utilitarios.Configuracao;

@EBean(scope = Scope.Singleton)
public abstract class Servico {
	private static final int SEGUNDOS = 10;
	private static final int TEMPO_CONEXAO_MILLISEGUNDOS = SEGUNDOS * 1000;

	@HttpsClient
	protected HttpClient clienteHttp;

	protected String obterUrlConexao(Context contexto) {
		String urlBase = "http://" + Configuracao.obterConfiguracao(contexto, Configuracao.IP_LINK_UPLOAD) + ":"
				+ Configuracao.obterConfiguracao(contexto, Configuracao.NUMERO_PORTA_UPLOAD) + "/"
				+ Configuracao.obterConfiguracao(contexto, Configuracao.DIRETORIO_RAIZ_UPLOAD) + "/"
				+ Configuracao.obterConfiguracao(contexto, Configuracao.SCRIPT_UPLOAD);
		return urlBase;
	}

	protected HttpResponse executar(Context tela, HttpEntity entidade) throws ClientProtocolException, IOException {
		configurarTempoRespostaConexao();
		String urlBase = obterUrlConexao(tela);
		HttpPost httpPost = new HttpPost(urlBase);
		httpPost.setEntity(entidade);
		HttpResponse resultado = clienteHttp.execute(httpPost);
		return resultado;
	}

	private void configurarTempoRespostaConexao() {
		clienteHttp.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TEMPO_CONEXAO_MILLISEGUNDOS);
		clienteHttp.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, TEMPO_CONEXAO_MILLISEGUNDOS);
	}
}
