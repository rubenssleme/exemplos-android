package com.projetos.mobiletechlawer.controladores.processo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.dominios.Cliente;
import com.projetos.mobiletechlawer.dominios.Processo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by r2d2 on 12/06/17.
 */

public class ControladorListViewProcesso extends BaseAdapter {

    public Context mContext;
    LayoutInflater inflater;
    private List<Processo> processos = null;
    private ArrayList<Processo> arraylist;

    public ControladorListViewProcesso(Context mContext, List<Processo> processos) {
        this.mContext = mContext;
        this.processos = processos;
        inflater = LayoutInflater.from(this.mContext);
        this.arraylist = new ArrayList<Processo>();
        this.arraylist.addAll(processos);
    }

    public void filternumero(String numero) {
        numero = numero.toLowerCase(Locale.getDefault());
        processos.clear();
        if (numero.length()==0){
            processos.addAll(arraylist);
        } else{
            for(Processo processo : arraylist){
                if (processo.getNumero().toLowerCase(Locale.getDefault()).contains(numero)){
                    processos.add(processo);
                }
            }
        }notifyDataSetChanged();
    }

    public void filterpasta(String pasta) {
        pasta = pasta.toLowerCase(Locale.getDefault());
        processos.clear();
        if (pasta.length()==0){
            processos.addAll(arraylist);
        } else{
            for(Processo processo : arraylist){
                if (processo.getPasta().toLowerCase(Locale.getDefault()).contains(pasta)){
                    processos.add(processo);
                }
            }
        }notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView txt_numero;
        TextView txt_pasta;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ControladorListViewProcesso.ViewHolder holder;
        if (convertView == null){
            holder =new ControladorListViewProcesso.ViewHolder();
            convertView = inflater.inflate(R.layout.list_view_processo, null);

            //LOCALIZA AS TEXTVIEWS
            holder.txt_numero.setText(processos.get(position).getNumero());
            holder.txt_pasta.setText(processos.get(position).getPasta());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, ControladorSelecionadoProcesso.class);

                    i.putExtra("numero", (processos.get(position).getNumero()));
                    i.putExtra("assunto", (processos.get(position).getAssunto()));
                    //i.putExtra("cliente", (processos.get(position).getCliente()));
                    i.putExtra("acao", (processos.get(position).getAcao()));
                    i.putExtra("situacao", (processos.get(position).getSituacao()));
                    i.putExtra("valor", (processos.get(position).getValor()));
                    i.putExtra("pasta", (processos.get(position).getPasta()));
                    i.putExtra("condicao", (processos.get(position).getCondicao()));
                    i.putExtra("parteContraria", (processos.get(position).getParteContraria()));
                    i.putExtra("advogadoContrario", (processos.get(position).getAdvogadoContrario()));
                    i.putExtra("tipoJustica", (processos.get(position).getTipoJustica()));
                    i.putExtra("regiao", (processos.get(position).getRegiao()));
                    i.putExtra("secao", (processos.get(position).getSecao()));
                    i.putExtra("subsecao", (processos.get(position).getSubsecao()));
                    i.putExtra("cidadeComarca", (processos.get(position).getCidadeComarca()));
                    i.putExtra("foro", (processos.get(position).getForo()));
                    i.putExtra("vara", (processos.get(position).getVara()));
                    i.putExtra("observacoes", (processos.get(position).getObservacoes()));

                    mContext.startActivity(i);
                }
            });

        }
        return convertView;
    }

}
