package com.example.admin.jewelry.homepage;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;
import com.example.admin.jewelry.certificate.CertificateActivity;
import com.youth.banner.Banner;

/**
 * Created by admin on 2016/8/15.
 */
public class HomePageFragment extends BaseFragment {
    private Banner banner;
    private LinearLayout linearLayout;
    @Override
    protected int setLayout() {
        return R.layout.hompage_fragment;
    }

    @Override
    protected void initView(View view) {
        banner = (Banner) view.findViewById(R.id.homepage_banner);
       // banner.setImages();
        banner.setDelayTime(3000);
        banner.setBannerStyle(Banner.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);
        linearLayout = (LinearLayout) view.findViewById(R.id.search_);


    }

    @Override
    protected void initData() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CertificateActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
