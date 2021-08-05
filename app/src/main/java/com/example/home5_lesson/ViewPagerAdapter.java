package com.example.home5_lesson;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<OnBoardingModel> list = new ArrayList<>();

    public ViewPagerAdapter(List<OnBoardingModel> list, FragmentManager fragmentManager){
        super(fragmentManager);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new BlankFragment();
        switch (position){
            case 0:
            case 1:
            case 2:
                return BlankFragment.newInstance(list.get(position).getTitle(), list.get(position).getDescription(), list.get(position).getImage());
        }
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
