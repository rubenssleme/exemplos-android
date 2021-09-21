package com.aprendaefaca.cursos.controladores.fragments;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import com.aprendaefaca.cursos.R;
import com.aprendaefaca.cursos.utilitarios.Mensagem;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@EFragment(value = R.layout.fragment_tela_configuracoes)
public class ControladorTelaFragmentConfiguracao extends Fragment {
	@ViewById(value = R.id.edGostou)
	public EditText edGostou;
	@ViewById(value = R.id.edIndicacao)
	public EditText edIndicacao;
	@ViewById(value = R.id.edSugestao)
	public EditText edSugestao;
	@ViewById(value = R.id.btEnviar)
	public Button btEnviar;

	@Bean
	Mensagem mensagem;

	@Click(value = R.id.btEnviar)
	public void configurar() {
		mensagem.exibirMensagem(this.getActivity(), "Você clicou nas configuracoes");
	}

}
