package com.example.firebase.model.pk;

import com.example.firebase.model.Pedido;

import java.io.Serializable;

public class PedidoItemPK<Produto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Pedido pedido;
    private Produto produto;



}
