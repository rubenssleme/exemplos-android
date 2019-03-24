package com.example.a3binfo.tccarctos;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

private  String[] mTabTitles;
    public MyFragmentPagerAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentAbertos();
            case 1:
                return new FragmentEmAndamento();
                case 2:
                    return new FragmentEncerrados();
                    default:
                        return null;

        }

    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
