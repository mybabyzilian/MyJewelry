package com.example.admin.jewelry.forhelp;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;

/**
 * Created by admin on 2016/8/15.
 */
public class ForHelpFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private RadioButton onlineForhelpRb,offlineRb,surrondRb;

    @Override
    protected int setLayout() {

        return R.layout.fragmnet_forhelp;

    }

    @Override
    protected void initView(View view) {
        onlineForhelpRb = (RadioButton) view.findViewById(R.id.rb_online_forhelp);
        offlineRb = (RadioButton) view.findViewById(R.id.rb_offline_yuyue);
        surrondRb = (RadioButton) view.findViewById(R.id.rb_surrond_arg);
        onlineForhelpRb.setOnCheckedChangeListener(this);
        offlineRb.setOnCheckedChangeListener(this);
        surrondRb.setOnCheckedChangeListener(this);
        onlineForhelpRb.setOnClickListener(this);
        offlineRb.setOnClickListener(this);
        surrondRb.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.forhelp_frame_layout, new OnlineHelpFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            compoundButton.setTextColor(Color.parseColor("#8f0303"));
        } else {
            compoundButton.setTextColor(Color.GRAY);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.rb_online_forhelp:
                fragmentTransaction.replace(R.id.forhelp_frame_layout, new OnlineHelpFragment());

                break;
            case R.id.rb_offline_yuyue:
                fragmentTransaction.replace(R.id.forhelp_frame_layout,new OfflineHelpFragmnet());

                break;
            case R.id.rb_surrond_arg:
                fragmentTransaction.replace(R.id.forhelp_frame_layout,new SurroundChatFragment());
                break;
        }
        fragmentTransaction.commit();


    }
}
