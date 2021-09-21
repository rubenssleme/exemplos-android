package com.example.firebase.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String cpf;
    public String date_of_birth;
    public String full_name;
    public String nick_name;


    public User(){

    }

    public User(String dateOfBirth, String fullName) {
        // ...
    }

    public User(String cpf, String dateOfBirth, String fullName, String nickname) {
     this.cpf = cpf;
     this.date_of_birth = dateOfBirth;
     this.full_name = fullName;
     this.nick_name = nickname;
    }



    @Override
    public String toString() {
        return "User{" +
                "date_of_birth='" + date_of_birth + '\'' +
                ", full_name='" + full_name + '\'' +
                ", nickname='" + nick_name + '\'' +
                '}';
    }
}

