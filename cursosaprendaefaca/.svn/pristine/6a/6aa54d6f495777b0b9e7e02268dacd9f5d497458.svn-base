package com.aprendaefaca.cursos.controladores.activities;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import com.aprendaefaca.cursos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

@EActivity(value = R.layout.activity_tela_splash)
public class ControladorTelaActivitySplash extends Activity {
	private static final int TEMPO = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		iniciarTelaSplash();
	}

	@Background(delay = TEMPO)
	public void iniciarTelaSplash() {
		finish();
		Intent intent = new Intent(this, ControladorTelaActivityPrincipal_.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	@Override
	public void onBackPressed() {		
	}

}
