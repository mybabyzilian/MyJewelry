package com.example.admin.jewelry.homepage;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseActivity;
import com.example.admin.jewelry.encyclopedia_fragment.EncyclopediaFragment;
import com.example.admin.jewelry.forhelp.ForHelpFragment;
import com.example.admin.jewelry.information.InformationFragment;
import com.example.admin.jewelry.mine.MineFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        private RadioButton homepageRb,informationRb,forhelpRb,baikeRb,mineRb;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        homepageRb = (RadioButton) findViewById(R.id.rb_homepage);
        informationRb = (RadioButton) findViewById(R.id.rb_information);
        forhelpRb = (RadioButton) findViewById(R.id.rb_forhelp);
        baikeRb = (RadioButton) findViewById(R.id.rb_encyclopedia);
        mineRb = (RadioButton) findViewById(R.id.rb_mine);

    }

    @Override
    protected void initData() {
        homepageRb.setOnClickListener(this);
        informationRb.setOnClickListener(this);
        forhelpRb.setOnClickListener(this);
        baikeRb.setOnClickListener(this);
        mineRb.setOnClickListener(this);
        homepageRb.setOnCheckedChangeListener(this);
        informationRb.setOnCheckedChangeListener(this);
        forhelpRb.setOnCheckedChangeListener(this);
        baikeRb.setOnCheckedChangeListener(this);
        mineRb.setOnCheckedChangeListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.homepage_framelaout, new HomePageFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.rb_homepage:
                fragmentTransaction.replace(R.id.homepage_framelaout, new HomePageFragment());

                break;
            case R.id.rb_information:
                fragmentTransaction.replace(R.id.homepage_framelaout,new InformationFragment());

                break;
            case R.id.rb_forhelp:
                fragmentTransaction.replace(R.id.homepage_framelaout,new ForHelpFragment());
                break;
            case R.id.rb_encyclopedia:
                fragmentTransaction.replace(R.id.homepage_framelaout,new EncyclopediaFragment());
                break;
            case R.id.rb_mine:
                fragmentTransaction.replace(R.id.homepage_framelaout,new MineFragment());
                break;

        }
        fragmentTransaction.commit();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            compoundButton.setTextColor(Color.RED);
        } else {
            compoundButton.setTextColor(Color.GRAY);
        }
    }
}
