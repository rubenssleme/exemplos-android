package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.firebase.config.User;
import com.example.firebase.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rootNode = FirebaseDatabase.getInstance();//A instancia atual do banco de dados
        reference = rootNode.getReference("Usuarios");

        User user = new User("222222222-11","28-04-1974","Rubens","Rubão");
//        User user = new User("101111111-12","28-04-1984","Caio","caio");
//        User user = new User("110111111-13","28-04-1994","Welliton","welliton");
//        User user = new User("112111111-14","28-04-2004","Nilson","nilson");
//        User user = new User("121111111-15","28-04-2014","Marcelo","marcelo");
//        User user = new User("131111111-16","28-04-2021","Juliana","juliana");
//        User user = new User("113111111-17","28-04-2021","Ariane","ariane");
//        User user = new User("141111111-18","28-04-2021","Guilherme","guilherme");
//        User user = new User("114111111-19","28-04-2021","Guilherme V","guilherme v");
//        User user = new User("151111111-10","28-04-2021","Camila","camila");

        reference.child(user.cpf).setValue(user);


    }


}