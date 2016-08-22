package com.example.admin.jewelry.information;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/15.
 */
public class InformationFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private InformationAdapter adapter;
    private List<Fragment> data;
    @Override
    protected int setLayout() {
        return R.layout.fragmnet_information;
    }

    @Override
    protected void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.information_tb);
        viewPager = (ViewPager) view.findViewById(R.id.information_vp);
        adapter = new InformationAdapter(getChildFragmentManager());
        data = new ArrayList<>();

    }

    @Override
    protected void initData() {
        data.add(new EphriteFragment());
        data.add(new JewelryFragment());
        data.add(new WenWanFragment());
        data.add(new OtherFragment());
        adapter.setData(data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
