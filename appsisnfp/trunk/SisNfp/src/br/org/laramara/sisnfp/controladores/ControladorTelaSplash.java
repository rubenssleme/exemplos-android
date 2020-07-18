package br.org.laramara.sisnfp.controladores;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import android.os.Bundle;
import br.org.laramara.sisnfp.R;

@EActivity(value = R.layout.activity_tela_splash)
public class ControladorTelaSplash extends ControladorTelaBase {
	private static final int TEMPO = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		iniciarTelaSplash();
	}

	@Background(delay = TEMPO)
	public void iniciarTelaSplash() {
		finish();
		redirecionar(this, ControladorTelaPrincipal_.class);
	}

}
