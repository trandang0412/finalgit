package com.example.app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.app.fragments.HomeFragment;
import com.example.app.fragments.ModifiFragment;
import com.example.app.fragments.SettingFragment;

public class Myviewpage extends FragmentStateAdapter {
    public Myviewpage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ModifiFragment();
            case 2:
                return new SettingFragment();
            default:
                return new HomeFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
