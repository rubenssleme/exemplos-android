package com.example.firebase.model;

import com.example.firebase.model.enuns.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class Pedido {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momento;
    private StatusPedido statusPedido;

}
