package com.example.a3binfo.tccarctos;

public class DtoChamados {
   String descricaoChamado;
   String dataAbertura;
   String dataEncerramento;
   String solucaoChamado;
    int usuarioId;
    int tecnicoId;
    int servicoId;
    int departamentoId;


    @Override
    public String toString() {
        //AQUI QUE ESCOLHEMOS OQ APARECERÁ NO LISTVIEW
        return descricaoChamado + " - " + dataAbertura;
    }
}
