package com.example.a3binfo.tccarctos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.time.Instant;


public class telaChamado extends AppCompatActivity {

        private TabLayout mTabLayout;
        private ViewPager mViewPager;




        private BottomNavigationView mMainNav;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tela_chamado);

            mTabLayout =(TabLayout) findViewById(R.id.tab_layout);
            mViewPager = (ViewPager) findViewById(R.id.view_pager);

            mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titles_tab)));

            mTabLayout.setupWithViewPager(mViewPager);


           mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
           Menu menu = mMainNav.getMenu();
           MenuItem menuItem = menu.getItem(0);
           menuItem.setChecked(true);

           mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                   switch (item.getItemId()) {
                       case R.id.navigation_chamados:
                           mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);

                           break;
                       case R.id.navigation_ajuda:
                           mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                           Intent intent1 = new Intent(telaChamado.this, ActivityOne.class);
                           startActivity(intent1);
                           break;
                       case R.id.navigation_sobre:
                           mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                           Intent intent2 = new Intent(telaChamado.this, ActivityTwo.class);
                           startActivity(intent2);
                           break;
                       case R.id.navigation_sair:
                           mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                           Intent intent3 = new Intent(telaChamado.this, MainActivity.class);
                           startActivity(intent3);
                           break;


                   }

                   return false;
               }


           });
        }

    }

