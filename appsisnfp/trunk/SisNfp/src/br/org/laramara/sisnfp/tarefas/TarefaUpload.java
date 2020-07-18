package br.org.laramara.sisnfp.tarefas;

import java.io.File;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import android.app.Activity;
import br.org.laramara.sisnfp.fachadas.FachadaNotaFiscal;

@EBean(scope = Scope.Singleton)
public class TarefaUpload extends Tarefa {
	@Bean
	public FachadaNotaFiscal fachadaNotaFiscal;

	@Background(serial = "upload_nota_fiscal_sequencia")
	public void enviarArquivo(Activity tela, File arquivo) {
		exibirMensagemEspera(tela, "Enviando nota fiscal...");
		boolean sucesso = fachadaNotaFiscal.enviarArquivo(tela, arquivo);
		if (sucesso) {
			exibirMensagem(tela, "Nota fiscal enviada com sucesso");
		} else {
			exibirMensagem(tela, "Falha ao conectar no servidor. Tente novamente mais tarde.");
		}
	}

}
