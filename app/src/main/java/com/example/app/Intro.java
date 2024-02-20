package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import me.relex.circleindicator.CircleIndicator;

public class Intro extends AppCompatActivity {

    Button btnSkip;
    ViewPager viewpager;
    RelativeLayout layoutBottom;
    CircleIndicator circle;
    LinearLayout layoutNext;

    ViewIntro viewintro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initUI();

        viewintro = new ViewIntro(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewpager.setAdapter(viewintro);

        circle.setViewPager(viewpager);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 4){
                    btnSkip.setVisibility(View.GONE);
                    layoutBottom.setVisibility(View.GONE);
                }else{
                    btnSkip.setVisibility(View.VISIBLE);
                    layoutBottom.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initUI(){
        btnSkip = findViewById(R.id.btn_skip);
        viewpager= findViewById(R.id.view_pager);
        layoutBottom = findViewById(R.id.layout_bottom);
        circle = findViewById(R.id.circle);
        layoutNext = findViewById(R.id.layout_next);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(4);
            }
        });

        layoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewpager.getCurrentItem() < 4){
                    viewpager.setCurrentItem( viewpager.getCurrentItem() + 1 );
                }
            }
        });

    }
}