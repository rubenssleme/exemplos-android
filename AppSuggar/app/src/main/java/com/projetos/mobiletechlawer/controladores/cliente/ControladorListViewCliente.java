package com.projetos.mobiletechlawer.controladores.cliente;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.dominios.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ControladorListViewCliente extends BaseAdapter {

    public Context mContext;
    LayoutInflater inflater;
    private List<Cliente> clientes;
    private ArrayList<Cliente> arrayList;

    public ControladorListViewCliente(Context mContext, List<Cliente> clientes) {
        this.mContext = mContext;
        this.clientes = clientes;
        inflater = LayoutInflater.from(this.mContext);
        this.arrayList = new ArrayList<Cliente>();
        this.arrayList.addAll(clientes);
    }

    public void filternome(String nome) {
        nome = nome.toLowerCase(Locale.getDefault());
        clientes.clear();
        if (nome.length() == 0){
            clientes.addAll(arrayList);
        }else {
            for (Cliente cliente : arrayList){
                if(cliente.getCpf().toLowerCase(Locale.getDefault()).contains(nome)){
                    clientes.add(cliente);
                }
            }
        }notifyDataSetChanged();
    }

    public void filtercpf(String cpf) {
        cpf = cpf.toLowerCase(Locale.getDefault());
        clientes.clear();
        if (cpf.length()==0){
            clientes.addAll(arrayList);
        }else {
            for (Cliente cliente : arrayList){
                if (cliente.getCnpj().toLowerCase(Locale.getDefault()).contains(cpf)){
                    clientes.add(cliente);
                }}}
        notifyDataSetChanged();
    }

    public void filtercnpj(String cnpj) {
        cnpj = cnpj.toLowerCase(Locale.getDefault());
        clientes.clear();
        if (cnpj.length()==0){
            clientes.addAll(arrayList);
        }else {
            for (Cliente cliente : arrayList){
                if (cliente.getCnpj().toLowerCase(Locale.getDefault()).contains(cnpj)){
                    clientes.add(cliente);
                }}}
        notifyDataSetChanged();
    }

    //SELECIONAR QUAIS DADOS APARECERAM NO LISTVIEW
    public class ViewHolder{
        TextView txt_nome;
        TextView txt_cpf;
        TextView txt_cnpj;
    }


    //CONSTRUTORES CRIADOS A PARTIR DO EXTENDS DO BASEADAPTER
    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_view_cliente, null);

            //LOCALIZANDO AS TEXTVIEWS NO LAYOUT
            holder.txt_nome = (TextView) convertView.findViewById(R.id.txt_nome);
            holder.txt_cpf = (TextView) convertView.findViewById(R.id.txt_cpf);
            holder.txt_cnpj = (TextView) convertView.findViewById(R.id.txt_cnpj);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //SETANDO OS RESULTADOS NAS TEXTVIEWS
        holder.txt_nome.setText(clientes.get(position).getNome());
        holder.txt_cpf.setText(clientes.get(position).getCpf());
        holder.txt_cnpj.setText(clientes.get(position).getCnpj());

        //AGORA VAMOS SETAR OS DADOS DO CLIENTE SELECIONADO EM OUTRA TELA
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ControladorSelecionadoCliente.class);
                intent.putExtra("nome", (clientes.get(position).getNome()));
                intent.putExtra("cpf", (clientes.get(position).getCpf()));
                intent.putExtra("cnpj", (clientes.get(position).getCnpj()));
                intent.putExtra("rg", (clientes.get(position).getRg()));
                intent.putExtra("endereco", (clientes.get(position).getEndereco()));
                intent.putExtra("numero", (clientes.get(position).getNumero()));
                intent.putExtra("complemento", (clientes.get(position).getComplemento()));
                intent.putExtra("cep", (clientes.get(position).getCep()));
                intent.putExtra("bairro", (clientes.get(position).getBairro()));
                intent.putExtra("cidade", (clientes.get(position).getCidade()));
                intent.putExtra("estado", (clientes.get(position).getEstado()));
                intent.putExtra("email", (clientes.get(position).getEmail()));
                intent.putExtra("celular", (clientes.get(position).getCelular()));
                intent.putExtra("telefone", (clientes.get(position).getTelefone()));

                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
}
