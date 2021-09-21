package com.aprendaefaca.cursos.controladores.activities;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import android.app.FragmentManager;
import android.view.MenuItem;

import com.aprendaefaca.cursos.Opcao;
import com.aprendaefaca.cursos.R;
import com.aprendaefaca.cursos.utilitarios.Sessao;

@EActivity(value = R.layout.activity_tela_principal)
public class ControladorTelaActivityPrincipal extends
		ControladorTelaActivityBase {
	private FragmentManager gerenciadorFragment = getFragmentManager();

	@Bean
	public static Sessao sessao;

	// Menu Lateral
	@Override
	public void selecionarItem(int posicao) {
		if (posicao == Opcao.INICIO.obterPosicao()) {
			sessao.redirecionarParaFragmentInicio(gerenciadorFragment);
		} else if (posicao == Opcao.CURSOS.obterPosicao()) {
			sessao.redirecionarParaFragmentCursos(gerenciadorFragment);
		} else if (posicao == Opcao.VIDEOAULAS.obterPosicao()) {
			sessao.redirecionarParaVideoAulas(this);
		} else if (posicao == Opcao.ARTIGOS.obterPosicao()) {
			sessao.redirecionarParaArtigos(this);
		} else if (posicao == Opcao.SAIR.obterPosicao()) {
			sessao.sair();
		}
	}

	// Menu Superior Direito
	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem opcao) {
		if (mDrawerToggle.onOptionsItemSelected(opcao)) {
			return true;
		}
		int posicao = opcao.getItemId();
		switch (posicao) {
		case R.id.action_configuracoes:
			sessao.redirecionarParaFragmentConfiguracao(gerenciadorFragment);
			atribuirTitulo("Configuracões");
			break;
		case R.id.action_sobre:
			sessao.redirecionarParaFragmentSobre(gerenciadorFragment);
			atribuirTitulo("Sobre");
			break;
		case R.id.action_sair:
			sessao.sair();
			break;
		}
		fecharMenuLateral();
		return super.onOptionsItemSelected(opcao);
	}

}
