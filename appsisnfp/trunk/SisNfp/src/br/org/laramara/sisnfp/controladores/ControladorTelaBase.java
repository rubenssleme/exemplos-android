package br.org.laramara.sisnfp.controladores;

import java.io.File;

import org.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

@EActivity
public abstract class ControladorTelaBase extends Activity {
	protected static final String URL_BASE = "http://laramara.org.br/";
	protected static final String URL_QUEM_SOMOS = URL_BASE + "quem-somos/sobre";
	protected static final String URL_COMO_AJUDAR = URL_BASE + "como-ajudar/doacao";

	protected void redirecionar(String url) {
		Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
		iniciarActivity(intent);
	}

	protected void redirecionar(Context telaAtual, Class<?> telaASerRedirecionado) {
		Intent intent = new Intent(telaAtual, telaASerRedirecionado);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		iniciarActivity(intent);
	}

	protected void iniciarActivity(Intent intent) {
		startActivity(intent);
	}

	protected void sair() {
		System.exit(0);
	}

	@Override
	public void onBackPressed() {
		redirecionarTelaInicial();
	}

	protected void iniciarCamera(int permissao, File arquivoSaida) {
		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivoSaida));
		this.startActivityForResult(cameraIntent, permissao);
	}

	private void redirecionarTelaInicial() {
		if (!(estaNaPaginaPrincipalOuSplash())) {
			redirecionar(this, ControladorTelaPrincipal_.class);
		}
	}

	private boolean estaNaPaginaPrincipalOuSplash() {
		return (this instanceof ControladorTelaPrincipal_) || (this instanceof ControladorTelaSplash_);
	}

}
