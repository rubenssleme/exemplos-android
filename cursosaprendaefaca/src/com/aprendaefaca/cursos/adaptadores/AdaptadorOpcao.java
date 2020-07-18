package com.aprendaefaca.cursos.adaptadores;

import java.util.List;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import com.aprendaefaca.cursos.Opcao;
import com.aprendaefaca.cursos.viewholders.OpcaoViewHolder;
import com.aprendaefaca.cursos.viewholders.OpcaoViewHolder_;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

@EBean
public class AdaptadorOpcao extends BaseAdapter {
	private List<Opcao> opcoes;

	@RootContext
	Context contexto;

	@AfterInject
	void inicializarAdaptador() {
		opcoes = Opcao.obterTodos();
	}

	@Override
	public View getView(int posicao, View convertView, ViewGroup parent) {
		OpcaoViewHolder opcaoViewHolder;
		if (convertView == null) {
			opcaoViewHolder = OpcaoViewHolder_.build(contexto);
		} else {
			opcaoViewHolder = (OpcaoViewHolder) convertView;
		}

		opcaoViewHolder.atribuirOpcao(getItem(posicao));

		return opcaoViewHolder;
	}

	@Override
	public int getCount() {
		return opcoes.size();
	}

	@Override
	public Opcao getItem(int position) {
		return opcoes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}