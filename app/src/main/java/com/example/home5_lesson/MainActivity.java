package com.example.home5_lesson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    Button button;
    int list[];
    LinearLayout dotsLayout;
    TextView[] dots;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.scrollView);
        button = findViewById(R.id.btn_next);

        list=new int[3];
        list[0]=getResources().getColor(R.color.white);
        list[1]=getResources().getColor(R.color.white);
        list[2]=getResources().getColor(R.color.white);

        dotsLayout=findViewById(R.id.view_pager2);

        dots=new TextView[3];
        dotsIndicator();

        List<OnBoardingModel> list = new ArrayList<>();
        list.add(new OnBoardingModel("Smart Wallet", "Managing your money can be the easiest thing you do all day.", R.drawable.ic_group_3));
        list.add(new OnBoardingModel("Effortless Budgeting", "Customize your budget categories and stay on top of your spending 24/7.", R.drawable.group_2));
        list.add(new OnBoardingModel("Automatic Savings", "Set your savings goal, and let Empower figure out how to get you there.", R.drawable.group_1));
        adapter = new ViewPagerAdapter(list, getSupportFragmentManager());
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    button.setText("Start");
                } else {
                    button.setText("Next");
                }
                selectedIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pager.getCurrentItem() == 2){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else{
                    pager.setCurrentItem(pager.getCurrentItem() + 1);
                }
            }
        });
    }

    private void selectedIndicator(int position) {
        for (int i = 0; i <dots.length; i++) {
            if (i==position){
                dots[i].setTextColor(list[position]);
            }else{
                dots[i].setTextColor(getResources().getColor(R.color.gray));
            }
        }
    }

    private void dotsIndicator() {
        for (int i = 0; i < dots.length; i++) {
            dots[i]= new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679"));
            dots[i].setTextSize(18);
            dotsLayout.addView(dots[i]);
        }
    }

}