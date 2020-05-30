package com.projetos.mobiletechlawer.controladores.funcionario;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.dominios.Cliente;
import com.projetos.mobiletechlawer.dominios.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ControladorListViewFuncionario extends BaseAdapter {

    public Context mContext;
    LayoutInflater inflater;
    private List<Funcionario> funcionarios;
    private ArrayList<Funcionario> arrayList;


    public ControladorListViewFuncionario(Context mContext, List<Funcionario> funcionarios) {
        this.mContext = mContext;
        this.funcionarios = funcionarios;
        inflater = LayoutInflater.from(this.mContext);
        this.arrayList = new ArrayList<Funcionario>();
        this.arrayList.addAll(funcionarios);
    }



    public void fiterNome(String nome) {
        nome = nome.toLowerCase(Locale.getDefault());
        funcionarios.clear();
        if (nome.length() == 0){
            funcionarios.addAll(arrayList);
        }else {
            for (Funcionario funcionario : arrayList){
                if(funcionario.getNome().toLowerCase(Locale.getDefault()).contains(nome)){
                    funcionarios.add(funcionario);
                }
            }
        }notifyDataSetChanged();
    }

    public void filterCpf(String cpf) {
        cpf = cpf.toLowerCase(Locale.getDefault());
        funcionarios.clear();
        if (cpf.length() == 0){
            funcionarios.addAll(arrayList);
        }else {
            for (Funcionario funcionario : arrayList){
                if(funcionario.getCpf().toLowerCase(Locale.getDefault()).contains(cpf)){
                    funcionarios.add(funcionario);
                }
            }
        }notifyDataSetChanged();
    }
    public class ViewHolder{
        TextView txt_nome;
        TextView txt_cpf;
    }

    @Override
    public int getCount() {
        return funcionarios.size();
    }

    @Override
    public Object getItem(int position) {
        return funcionarios.get(position);
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
            convertView = inflater.inflate(R.layout.list_view_funcionario, null);

            holder.txt_nome = (TextView) convertView.findViewById(R.id.txt_nome);
            holder.txt_cpf = (TextView) convertView.findViewById(R.id.txt_cpf);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_nome.setText(funcionarios.get(position).getNome());
        holder.txt_cpf.setText(funcionarios.get(position).getCpf());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ControladorSelecionadoFuncionario.class);
                intent.putExtra("nome", (funcionarios.get(position).getNome()));
                intent.putExtra("nascimento", (funcionarios.get(position).getNascimento()));
                intent.putExtra("sexo", (funcionarios.get(position).getSexo()));
                intent.putExtra("naturalidade", (funcionarios.get(position).getNaturalidade()));
                intent.putExtra("estado", (funcionarios.get(position).getEstado()));
                intent.putExtra("cpf", (funcionarios.get(position).getCpf()));
                intent.putExtra("rg", (funcionarios.get(position).getRg()));
                intent.putExtra("ctps", (funcionarios.get(position).getCtps()));
                intent.putExtra("serie", (funcionarios.get(position).getSerie()));
                intent.putExtra("nascimento", (funcionarios.get(position).getNascimento()));
                intent.putExtra("digito", (funcionarios.get(position).getDigito()));
                intent.putExtra("registroProfissional", (funcionarios.get(position).getRegistroProfissional()));
                intent.putExtra("orgao", (funcionarios.get(position).getOrgao()));
                intent.putExtra("agencia", (funcionarios.get(position).getAgencia()));
                intent.putExtra("conta", (funcionarios.get(position).getConta()));
                intent.putExtra("grauInstrucao", (funcionarios.get(position).getGrauInstrucao()));
                intent.putExtra("estadoCivil", (funcionarios.get(position).getEstadoCivil()));
                intent.putExtra("endereco", (funcionarios.get(position).getEndereco()));
                intent.putExtra("complemento", (funcionarios.get(position).getComplemento()));
                intent.putExtra("bairro", (funcionarios.get(position).getBairro()));
                intent.putExtra("cidade", (funcionarios.get(position).getCidade()));
                intent.putExtra("cep", (funcionarios.get(position).getCep()));
                intent.putExtra("telefone", (funcionarios.get(position).getTelefone()));
                intent.putExtra("salario", (funcionarios.get(position).getSalario()));
                intent.putExtra("pagamento", (funcionarios.get(position).getPagamento()));
                intent.putExtra("cargo", (funcionarios.get(position).getCargo()));
                intent.putExtra("carteiraEstagiario", (funcionarios.get(position).getCarteiraEstagiario()));


                mContext.startActivity(intent);

            }
        });


        return convertView;
    }

}
