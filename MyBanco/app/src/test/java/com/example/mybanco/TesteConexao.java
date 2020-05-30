package com.example.mybanco;


import org.junit.Test;

public class TesteConexao {

    @Test
    public void test_conectarBancoSucesso(){
      Conexao cc = new Conexao();
      if(cc._status){
          System.out.println(cc.getClass().getSimpleName() + " - OK");
      }
    }

}
