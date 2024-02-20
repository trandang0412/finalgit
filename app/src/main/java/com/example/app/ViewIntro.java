package com.example.app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app.fragment2.onboard1;
import com.example.app.fragment2.onboard2;
import com.example.app.fragment2.onboard3;
import com.example.app.fragment2.onboard4;
import com.example.app.fragment2.onboard5;

public class ViewIntro extends FragmentStatePagerAdapter {
    public ViewIntro(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new onboard1();
            case 1:
                return new onboard2();
            case 2:
                return new onboard3();
            case 3:
                return new onboard4();
            case 4:
                return new onboard5();

            default:
                return new onboard1();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
