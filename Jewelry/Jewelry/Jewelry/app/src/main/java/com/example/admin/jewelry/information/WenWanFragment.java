package com.example.admin.jewelry.information;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;
import com.example.admin.jewelry.information.adapter.EphriteFragmentAdapter;
import com.example.admin.jewelry.information.bean.InformationBean;
import com.example.admin.jewelry.netrequest.OkHttpClientManager;
import com.example.admin.jewelry.netrequest.Urls;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/8/15.
 */
public class WenWanFragment extends BaseFragment {
    private ListView listView;
    private EphriteFragmentAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_wenwan;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.wenwan_list);
        adapter = new EphriteFragmentAdapter(context);
    }

    @Override
    protected void initData() {
        Map<String, String> maps = new HashMap<>();
        maps.put("entity_id", "3");
        OkHttpClientManager.postAsyn(Urls.EPHRITEURL, new OkHttpClientManager.ResultCallback<InformationBean>() {
            @Override
            public void onError(Request request, Exception e) {
                Toast.makeText(context, "请求失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(InformationBean response) {
                adapter.setData(response);
                listView.setAdapter(adapter);
            }

        }, maps);
    }
}
