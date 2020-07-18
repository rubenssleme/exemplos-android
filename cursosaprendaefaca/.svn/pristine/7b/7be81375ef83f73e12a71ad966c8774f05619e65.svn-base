package com.aprendaefaca.cursos.utilitarios;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import com.aprendaefaca.cursos.R;
import com.aprendaefaca.cursos.controladores.fragments.ControladorTelaFragmentConfiguracao_;
import com.aprendaefaca.cursos.controladores.fragments.ControladorTelaFragmentCursos_;
import com.aprendaefaca.cursos.controladores.fragments.ControladorTelaFragmentSobre_;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@EBean(scope = Scope.Singleton)
public class Sessao {
	private static final String URL_BASE = "http://www.aprendaefaca.com/site/course/";
	private static final String URL_CURSO_VB = URL_BASE + "/programacao-vb-net";
	private static final String URL_CURSO_ANDROID = URL_BASE + "/programacao-android";
	private static final String URL_CURSO_CSHARP = URL_BASE + "/programacao-c-sharp";
	private static final String URL_CURSO_JAVA = URL_BASE + "/programacao-java";
	private static final String URL_VIDEO_AULAS = "https://www.youtube.com/channel/UCbRUstipHXMea974_2Vec6w";
	private static final String URL_ARTIGOS = "http://www.aprendaefaca.com/site/category/programacao/";
	private static final int ID_CONTEUDO_PRINCIPAL = R.id.conteudo_principal;
	
	private Intent obterIntentBrowser(String url) {
		Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
		return intent;
	}

	private void redirecionar(Context tela, String url) {
		Intent intent = obterIntentBrowser(url);
		tela.startActivity(intent);
	}

	private void redirecionar(Fragment tela, String url) {
		Intent intent = obterIntentBrowser(url);
		tela.startActivity(intent);	
	}

	private void redirecionarFragment(FragmentManager fragmentManager, Fragment fragment) {
		fragmentManager.beginTransaction().replace(ID_CONTEUDO_PRINCIPAL, fragment).commit();
	}

	public void redirecionarParaFragmentInicio(FragmentManager fragmentManager) {
		redirecionarFragment(fragmentManager, new Fragment());
	}

	public void redirecionarParaFragmentCursos(FragmentManager fragmentManager) {
		redirecionarFragment(fragmentManager, new ControladorTelaFragmentCursos_());
	}

	public void redirecionarParaFragmentConfiguracao(FragmentManager fragmentManager) {
		redirecionarFragment(fragmentManager, new ControladorTelaFragmentConfiguracao_());
	}

	public void redirecionarParaFragmentSobre(FragmentManager fragmentManager) {
		redirecionarFragment(fragmentManager, new ControladorTelaFragmentSobre_());
	}

	public void redirecionarParaCursoVb(Fragment tela) {
		redirecionar(tela, URL_CURSO_VB);
	}

	public void redirecionarParaCursoJava(Fragment tela) {
		redirecionar(tela, URL_CURSO_JAVA);
	}

	public void redirecionarParaCursoCSharp(Fragment tela) {
		redirecionar(tela, URL_CURSO_CSHARP);
	}

	public void redirecionarParaCursoAndroid(Fragment tela) {
		redirecionar(tela, URL_CURSO_ANDROID);
	}

	public void redirecionarParaVideoAulas(Activity tela) {
		redirecionar(tela, URL_VIDEO_AULAS);
	}

	public void redirecionarParaArtigos(Activity tela) {
		redirecionar(tela, URL_ARTIGOS);
	}

	public void sair() {
		System.exit(0);
	}
}
