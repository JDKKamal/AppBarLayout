package com.jdkgroup.appbarlayout;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout_toolbar);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Title");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        List<String> list = new ArrayList<>();
        list.add("Tab 1");
        list.add("Tab 2");
        list.add("Tab 3");
        list.add("Tab 4");
        list.add("Tab 5");
        list.add("Tab 6");
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(list.size());
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClick(View view){
        Snackbar.make(view,"Floating Click", Snackbar.LENGTH_SHORT).show();
    }

    public class MyPagerAdapter extends FragmentPagerAdapter{

        private List<String> titleList;

        public MyPagerAdapter(FragmentManager fm, List<String> list){
            super(fm);
            this.titleList = list;
        }

        @Override
        public int getCount() {
            return titleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return MyTitleFragment.newInstance(titleList.get(position));
        }
    }
}