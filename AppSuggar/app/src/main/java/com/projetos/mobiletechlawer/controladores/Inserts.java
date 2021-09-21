package com.projetos.mobiletechlawer.controladores;

import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.projetos.mobiletechlawer.dominios.Cliente;
import com.projetos.mobiletechlawer.dominios.Funcionario;
import com.projetos.mobiletechlawer.dominios.Login;

import java.util.List;


public class Inserts  extends AppCompatActivity{

    public void insertLogin(){
        String[] scripts = {
                "INSERT INTO Login(usuario, senha) values('samuel','123');",
                "INSERT INTO Login(usuario, senha) values('giovanna','123');",
                "INSERT INTO Login(usuario, senha) values('adm','123');",
        };
        try {
            List<Login> listLogin = Login.listAll(Login.class);
            if (listLogin == null || listLogin.size() <= 0) {
                for (String script : scripts) {
                    Login.executeQuery(script);
                }}
        }catch (Exception e){
            Toast.makeText(this, "Erro em insert de Login", Toast.LENGTH_SHORT).show();
        }}
    public void insertCliente(){
        String[] scripts = {
                "INSERT INTO Cliente(nome,cpf,cnpj,rg,endereco,numero,complemento,cep,bairro,cidade,estado,email,celular,telefone) values ('samuel','00011111111','','333311111','Travessa Viario','08','B','0298-165','Parque Taipas','São Paulo,SP','sam_araujo@outlook.com','981660241','39455228');",
                "INSERT INTO Cliente(nome,cpf,cnpj,rg,endereco,numero,complemento,cep,bairro,cidade,estado,email,celular,telefone) values ('gabriel','00022222222','','33322222','Travessa Viario','09','B','0298-165','Parque Taipas','São Paulo,SP','gabriel_araujo@outlook.com','981660241','39455228');",
                "INSERT INTO Cliente(nome,cpf,cnpj,rg,endereco,numero,complemento,cep,bairro,cidade,estado,email,celular,telefone) values ('jose','00033333333','33333333','','Travessa Viario','10','B','0298-165','Parque Taipas','São Paulo,SP','gabriel_araujo@outlook.com','981660241','39455228');",
        };
        try{
            List<Cliente> listaCliente = Cliente.listAll(Cliente.class);
            if (listaCliente == null || listaCliente.size() <= 0){
                for(String script : scripts){
                    Cliente.executeQuery(script);
                }}
        }catch (Exception e){
            Toast.makeText(this, "Erro em insert de Cliente", Toast.LENGTH_SHORT).show();
        }}
    public void insertFuncionario(){
        String[] scripts = {
                "INSERT INTO Funcionario(nome,cpf,email,celular,telefone) values ('Giovanna','00011111111','Giovana@outlook.com','981660241','39455228');",
                "INSERT INTO Funcionario(nome,cpf,email,celular,telefone) values ('Ynara','00022222222','Ynara@outlook.com','981660241','39455228');",
                "INSERT INTO Funcionario(nome,cpf,email,celular,telefone) values ('Rodrigo','00033333333','Rodrigo@outlook.com','981660241','39455228');",
        };
        try{
            List<Funcionario> listaFuncionario = Funcionario.listAll(Funcionario.class);
            if (listaFuncionario == null || listaFuncionario.size() <= 0){
                for(String script : scripts){
                    Funcionario.executeQuery(script);
                }}
        }catch (Exception e){
            Toast.makeText(this, "Erro em insert de Funcionario", Toast.LENGTH_SHORT).show();
        }
    }
    //AO CHEGAR EM CASA LEMBRAR DE FAZER TROCA DE DADOS DO FUNCIONARIO PARA MOSTRAR APENAS DADOS PERTINENTES, FAZER TAMBEM RESTANTE DAS VALIDACOES E DEPOIS SO FOCAR EM APIU
}