package com.example.fanxh.guidetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager MyPager;
    private List<Fragment> fragmentList;
    private LinearLayout LinearOne,LinearTwo,LinearThree;
    private TextView TextOne,TextTwo,TextThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();//初始化页面控件
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());

        MyPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        MyPager.setCurrentItem(0);
        MyPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        public MyViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }



        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }
    }

    private void initView(){
        MyPager = (ViewPager) findViewById(R.id.main_mypager);
        LinearOne = (LinearLayout) findViewById(R.id.include_main_linear_one);
        LinearOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPager.setCurrentItem(0);
            }
        });
        LinearTwo = (LinearLayout) findViewById(R.id.include_main_linear_two);
        LinearTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPager.setCurrentItem(1);
            }
        });
        LinearThree = (LinearLayout) findViewById(R.id.include_main_linear_three);
        LinearThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPager.setCurrentItem(2);
            }
        });
        TextOne = (TextView) findViewById(R.id.include_main_text_one);
        TextTwo = (TextView) findViewById(R.id.include_main_text_two);
        TextThree = (TextView) findViewById(R.id.include_main_text_three);
    }
    private void setTextColor(int position){
        TextOne.setTextColor(getResources().getColor(R.color.colorAccent));
        TextTwo.setTextColor(getResources().getColor(R.color.colorAccent));
        TextThree.setTextColor(getResources().getColor(R.color.colorAccent));
        switch (position){
            case 0:
                TextOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 1:
                TextTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 2:
                TextThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
    }
}
