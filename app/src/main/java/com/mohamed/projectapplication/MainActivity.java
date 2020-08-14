package com.mohamed.projectapplication;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> users = new ArrayList<>();
        users.add(new User("test","password"));
        users.add(new User("test1","password1"));
        users.add(new User("test2","password2"));
        users.add(new User("test3","password3"));
        users.add(new User("test4","password4"));

        //user input
        if (users.contains("test")){
            User user = new User("test", "password");

        }

        final ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab_text_1)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab_text_2)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab_text_3)));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),tabs.getTabCount(),this);
        viewPager.setAdapter(sectionPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.getCurrentItem();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}