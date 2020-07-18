package com.aprendaefaca.cursos.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendaefaca.cursos.R;
import com.aprendaefaca.cursos.menus.Opcao;

public class ControladorTelaMenuLateral extends ArrayAdapter<Opcao> {
	private final Context contexto;
	private Opcao[] opcoes;

	public ControladorTelaMenuLateral(Context context, Opcao[] opcoes) {
		super(context, R.layout.activity_tela_menu_lateral, opcoes);
		this.contexto = context;
		this.opcoes = opcoes;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tvNome;
		ImageView ivIcone;
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(contexto).inflate(
					R.layout.activity_tela_menu_lateral, parent, false);
			tvNome = (TextView) view.findViewById(R.id.tvNome);
			ivIcone = (ImageView) view.findViewById(R.id.ivIcone);
			view.setTag(new ViewHolder(ivIcone, tvNome));
		} else {
			ViewHolder viewHolder = (ViewHolder) view.getTag();
			tvNome = viewHolder.tvNome;
			ivIcone = viewHolder.ivIcone;
		}

		tvNome.setText(opcoes[position].obterNome());
		ivIcone.setImageResource(opcoes[position].obterImagem());

		return view;
	}

	private static class ViewHolder {
		public final ImageView ivIcone;
		public final TextView tvNome;

		public ViewHolder(ImageView ivIcone, TextView tvNome) {
			this.ivIcone = ivIcone;
			this.tvNome = tvNome;
		}
	}
}