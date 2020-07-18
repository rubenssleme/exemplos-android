package br.org.laramara.sisnfp.controladores;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.widget.Button;
import br.org.laramara.sisnfp.R;

@EActivity(value = R.layout.activity_tela_principal)
public class ControladorTelaPrincipal extends ControladorTelaBase {

	@ViewById(value = R.id.btDoarNotaFiscal)
	public Button btDoarNotaFiscal;
	@ViewById(value = R.id.btQuemSomos)
	public Button btQuemSomos;
	@ViewById(value = R.id.btComoAjudar)
	public Button btComoAjudar;
	@ViewById(value = R.id.btSair)
	public Button btSair;

	@Click(value = R.id.btDoarNotaFiscal)
	public void doarNotaFiscal() {
		redirecionar(this, ControladorTelaNotaFiscal_.class);
	}

	@Click(value = R.id.btQuemSomos)
	public void redirecionarParaPaginaQuemSomos() {
		redirecionar(URL_QUEM_SOMOS);
	}

	@Click(value = R.id.btComoAjudar)
	public void redirecionarParaPaginaComoAjudar() {
		redirecionar(URL_COMO_AJUDAR);
	}

	@Click(value = R.id.btSair)
	public void fechar() {
		sair();
	}
}
