package com.projetos.mobiletechlawer.controladores.compromissos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.controladores.cliente.ControladorListViewCliente;
import com.projetos.mobiletechlawer.controladores.processo.ControladorListViewProcesso;
import com.projetos.mobiletechlawer.dominios.Compromisso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by r2d2 on 16/06/17.
 */

public class ControladorListViewCompromisso extends BaseAdapter {

    public Context mContext;
    LayoutInflater inflater;
    private List<Compromisso> compromissos;
    private ArrayList<Compromisso> arrayList;

    public ControladorListViewCompromisso(Context mContext, List<Compromisso> compromissos) {
        this.mContext = mContext;
        this.compromissos = compromissos;
        inflater = LayoutInflater.from(this.mContext);
        this.arrayList = new ArrayList<Compromisso>();
        this.arrayList.addAll(compromissos);
    }

    public void filterTitulo(String titulo) {
        titulo = titulo.toLowerCase(Locale.getDefault());
        compromissos.clear();
        if (titulo.length() == 0 ){
            compromissos.addAll(arrayList);
        }else{
            for (Compromisso compromisso : arrayList){
                if (compromisso.getTitulo().toLowerCase(Locale.getDefault()).contains(titulo)){
                    compromissos.add(compromisso);
                }
            }
        }notifyDataSetChanged();
    }

    public void filterData(String data) {
        data = data.toLowerCase(Locale.getDefault());
        compromissos.clear();
        if (data.length() == 0){
            compromissos.addAll(arrayList);
        }else {
            for (Compromisso compromisso : arrayList){
                if (compromisso.getData().toLowerCase(Locale.getDefault()).contains(data)){
                    compromissos.add(compromisso);
                }
            }
        }notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView txt_titulo;
        TextView txt_data;
    }

    @Override
    public int getCount() {
        return compromissos.size();
    }

    @Override
    public Object getItem(int position) {
        return compromissos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_view_compromisso, null);

            holder.txt_titulo = (TextView) convertView.findViewById(R.id.txt_titulo);
            holder.txt_data = (TextView) convertView.findViewById(R.id.txt_data);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_titulo.setText(compromissos.get(position).getTitulo());
        holder.txt_data.setText(compromissos.get(position).getData());
        return convertView;
    }
}
