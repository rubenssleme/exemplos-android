package com.example.a3binfo.tccarctos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }


    public void clickButton (View view){

        Intent intentClick = new Intent(getApplicationContext(), telaChamado.class);
        startActivity(intentClick);
    }
}
