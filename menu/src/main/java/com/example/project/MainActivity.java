package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          //뷰페이저 구현
//        ViewPager vpPager = findViewById(R.id.vpPager);
//        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
//        vpPager.setAdapter(adapterViewPager);
//
//        CircleIndicator indicator = findViewById(R.id.indicator);
//        indicator.setViewPager(vpPager);

        //각 레이아웃에 창 전환 Event
        ImageView wasabi = findViewById(R.id.wasabi);
        wasabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WasabiActivity.class);
                startActivity(intent);
            }
        });
        ImageView tuna = findViewById(R.id.tuna);
        tuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TunaActivity.class);
                startActivity(intent);
            }
        });
        ImageView egg = findViewById(R.id.egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EggActivity.class);
                startActivity(intent);
            }
        });
        ImageView pork = findViewById(R.id.pork);
        pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PorkActivity.class);
                startActivity(intent);
            }
        });
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;
        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }
        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FirstFragment.newInstance(0, "Page # 1");
                case 1:
                    return SecondFragment.newInstance(1, "Page # 2");
                case 2:
                    return ThirdFragment.newInstance(2, "Page # 3");
                case 3:
                    return FourFragment.newInstance(3, "page #4");
                case 4:
                default:
                    return null;
            }
        }
        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }
    }
}
