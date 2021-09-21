package com.aprendaefaca.cursos.viewholders;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.aprendaefaca.cursos.Opcao;
import com.aprendaefaca.cursos.R;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@EViewGroup(R.layout.activity_menu_lateral)
public class OpcaoViewHolder extends LinearLayout {

	@ViewById
	ImageView ivIcone;

	@ViewById
	TextView tvNome;

	public OpcaoViewHolder(Context context) {
		super(context);
	}

	public void atribuirOpcao(Opcao opcao) {
		tvNome.setText(opcao.nome);
		ivIcone.setImageResource(opcao.imagem);
	}

}