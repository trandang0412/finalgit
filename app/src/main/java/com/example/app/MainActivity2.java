package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {


    TabLayout tabLayout;
    Myviewpage myviewpage;
    ViewPager2 viewPager2;
    Button button;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tab_layout2);
        viewPager2 = findViewById(R.id.view_pager);
        myviewpage = new Myviewpage(this);
        viewPager2.setAdapter(myviewpage);
        textView = findViewById(R.id.viewname);

        Intent i= getIntent();
        Bundle b= i.getExtras();
        String name = b.getString("ten");
        textView.setText("Hello "+ name);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
      /*  button = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivity2();
            }
        });*/
    }
   /* public void OpenActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

}