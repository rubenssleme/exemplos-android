package br.org.laramara.sisnfp.controladores;

import java.io.File;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import android.content.Intent;
import android.widget.Button;
import br.org.laramara.sisnfp.R;
import br.org.laramara.sisnfp.fabricas.FabricaNotaFiscal;
import br.org.laramara.sisnfp.tarefas.TarefaUpload;

@EActivity(value = R.layout.activity_tela_nota_fiscal)
public class ControladorTelaNotaFiscal extends ControladorTelaBase {
	private static final int PERMISSAO_CAMERA = 1888;
	public File notaFiscal;

	@ViewById(value = R.id.btFotografarNotaFiscal)
	public Button btFotografarNotaFiscal;

	@Bean
	public TarefaUpload tarefaUpload;

	@Click(value = R.id.btFotografarNotaFiscal)
	public void enviarNotaFiscal() {
		notaFiscal = FabricaNotaFiscal.criarNotaFiscal(this);
		iniciarCamera(PERMISSAO_CAMERA, notaFiscal);
	}
	
	@OnActivityResult(value = PERMISSAO_CAMERA)
	protected void resultadoCamera(int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			tarefaUpload.enviarArquivo(this, notaFiscal);
		}
	}
}