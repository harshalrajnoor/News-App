package com.example.news_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem home, sports, finance, health, technology, science, entertainment;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;

    String api = "23c948702cd24f8798a49998f4b77a72";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home = findViewById(R.id.home);
        sports = findViewById(R.id.sports);
        health = findViewById(R.id.health);
        technology = findViewById(R.id.technology);
        science = findViewById(R.id.science);
        entertainment = findViewById(R.id.entertainment);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);

        tabLayout = findViewById(R.id.include);


        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 7);
        viewPager.setAdapter((pagerAdapter));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5 || tab.getPosition() == 6) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}