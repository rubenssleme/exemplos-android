package br.org.laramara.sisnfp.tarefas;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.androidannotations.annotations.UiThread;

import android.app.ProgressDialog;
import android.content.Context;
import br.org.laramara.sisnfp.utilitarios.Mensagem;

@EBean(scope = Scope.Singleton)
public abstract class Tarefa {
	@Bean
	Mensagem mensagem;

	private ProgressDialog pdMensagem;

	@UiThread
	protected void exibirMensagem(Context tela, String texto) {
		encerrarMensagemEspera();
		mensagem.exibirMensagem(tela, texto);
	}

	@UiThread
	protected void exibirMensagemEspera(Context tela, String mensagem) {
		pdMensagem = ProgressDialog.show(tela, "Mensagem", mensagem);
	}

	private void encerrarMensagemEspera() {
		pdMensagem.dismiss();
	}

}
