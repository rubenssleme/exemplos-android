package com.example.firebase.model;

import com.example.firebase.config.ConfigFirebase;
import com.example.firebase.helper.UsuarioFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String idUsuario;
    private String foto;

    public Usuario() {
    }

    public void atualizar(){

        String idUser = UsuarioFirebase.getIdUser();
        DatabaseReference firebaseRef = ConfigFirebase.getFirebaseDatabase();

        DatabaseReference usuariosRef = firebaseRef.child("usuarios")
                .child(idUser);


        Map<String, Object> valoresUsuario = converterParaMap();

        usuariosRef.updateChildren(valoresUsuario);
    }

    @Exclude
    public Map<String, Object> converterParaMap(){
        HashMap<String, Object> usuarioMap = new HashMap<>();

        usuarioMap.put("email",getEmail());
        usuarioMap.put("nome", getNome());
        usuarioMap.put("foto", getFoto());

        return usuarioMap;
    }

    public void salvar(){
        DatabaseReference firebaseRef = ConfigFirebase.getFirebaseDatabase();
        DatabaseReference usuario = firebaseRef.child("usuarios").child(getIdUsuario());

        usuario.setValue(this);
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Exclude
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
