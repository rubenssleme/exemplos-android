package com.example.a3binfo.tccarctos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    private BottomNavigationView mMainNav;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        TextView title =(TextView) findViewById(R.id.activityTitle2);
        title.setText(" oi ");

        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        Menu menu = mMainNav.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_chamados:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                        Intent intent = new Intent(ActivityTwo.this, telaChamado.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_ajuda:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                        Intent intent1 = new Intent(ActivityTwo.this, ActivityOne.class);
                        startActivity(intent1);
                        break;
                    case R.id.navigation_sobre:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                        Intent intent2 = new Intent(ActivityTwo.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;
                    case R.id.navigation_sair:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                        Intent intent3 = new Intent(ActivityTwo.this, MainActivity.class);
                        startActivity(intent3);
                        break;


                }

                return false;
            }


        });
    }
}