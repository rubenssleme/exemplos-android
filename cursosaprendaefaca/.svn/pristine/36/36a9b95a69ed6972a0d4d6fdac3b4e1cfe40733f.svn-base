package com.aprendaefaca.cursos.utilitarios;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.EBean.Scope;

import android.content.Context;
import android.widget.Toast;

@EBean(scope = Scope.Singleton)
public class Mensagem {

	@UiThread
	public void exibirMensagem(Context contexto, String mensagem) {
		Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();
	}

}
