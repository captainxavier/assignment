package com.mohamed.projectapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    Context mContext;
    int totalTabs;

    public SectionPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        mContext = context;
        this.totalTabs = behavior;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentTabOne fragmentTabOne = new FragmentTabOne();
                return fragmentTabOne;
            case 1:
                FragmentTabTwo fragmentTabTwo = new FragmentTabTwo();
                return fragmentTabTwo;
            case 2:
                FragmentTabThree fragmentTabThree = new FragmentTabThree();
                return fragmentTabThree;
            default:
                return null;
        }
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
