package com.aprendaefaca.cursos.controladores.fragments;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import com.aprendaefaca.cursos.R;
import com.aprendaefaca.cursos.utilitarios.Mensagem;
import com.aprendaefaca.cursos.utilitarios.Sessao;

import android.app.Fragment;
import android.widget.TextView;

@EFragment(value = R.layout.fragment_tela_cursos)
public class ControladorTelaFragmentCursos extends Fragment {
	@ViewById(value = R.id.tvCursoVB)
	public TextView tvCursoVB;
	@ViewById(value = R.id.tvCursoJava)
	public TextView tvCursoJava;
	@ViewById(value = R.id.tvCursoCSharp)
	public TextView tvCursoCSharp;
	@ViewById(value = R.id.tvCursoAndroid)
	public TextView tvCursoAndroid;

	@Bean
	Mensagem mensagem;

	@Bean
	Sessao sessao;

	@Click(value = R.id.tvCursoVB)
	public void redirecionarParaPaginaCursoVb() {
		sessao.redirecionarParaCursoVb(this);
	}

	@Click(value = R.id.tvCursoJava)
	public void redirecionarParaPaginaCursoJava() {
		sessao.redirecionarParaCursoJava(this);
	}

	@Click(value = R.id.tvCursoCSharp)
	public void redirecionarParaPaginaCursoCSharp() {
		sessao.redirecionarParaCursoCSharp(this);
	}

	@Click(value = R.id.tvCursoAndroid)
	public void redirecionarParaPaginaCursoAndroid() {
		sessao.redirecionarParaCursoAndroid(this);
	}
}
