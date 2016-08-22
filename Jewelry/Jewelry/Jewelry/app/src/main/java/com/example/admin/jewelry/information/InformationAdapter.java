package com.example.admin.jewelry.information;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2016/8/15.
 */
public class InformationAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private String[] titles = {"玉石","宝石","文玩","其他"};


    public void setData(List<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public InformationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
