package com.example.admin.jewelry.forhelp;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;
import com.example.admin.jewelry.forhelp.adapter.PopuAdapter;
import com.example.admin.jewelry.forhelp.bean.OnlineBean;
import com.example.admin.jewelry.forhelp.bean.PopuBean;
import com.example.admin.jewelry.netrequest.OkHttpClientManager;
import com.example.admin.jewelry.netrequest.Urls;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/8/16.
 */
public class OnlineHelpFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout sortlayout,typeLayout,rewardLayout,parentLayout;
    private PopupWindow popupWindow;
    private ImageView sortIv,rewardIv,typeIv;
    private TextView sortTv,typeTv,rewardTv;
    private View popuView;
    private PopuBean bean;
    private PopuAdapter popuAdapter;
    private ListView popuListView;
    private GridView gridView;
    private GridViewAdapter adapter;
    private String id = null;


    @Override
    protected int setLayout() {
        return R.layout.fragment_online_help;
    }

    @Override
    protected void initView(View view) {
        sortlayout = (LinearLayout) view.findViewById(R.id.sort_linear_layout);
        typeLayout = (LinearLayout) view.findViewById(R.id.type_linear_layout);
        rewardLayout = (LinearLayout) view.findViewById(R.id.reward_linear_layout);
        parentLayout = (LinearLayout) view.findViewById(R.id.parent_linear_layout);
        sortTv = (TextView) view.findViewById(R.id.sort_Tv);
        typeTv = (TextView) view.findViewById(R.id.type_tv);
        rewardTv = (TextView) view.findViewById(R.id.reward_tv);
        sortIv = (ImageView) view.findViewById(R.id.sort_iv);
        rewardIv = (ImageView) view.findViewById(R.id.reward_iv);
        typeIv = (ImageView) view.findViewById(R.id.type_iv);
        popuView = LayoutInflater.from(context).inflate(R.layout.view_popu,null);
        popuListView = (ListView) popuView.findViewById(R.id.popu_list);
        gridView = (GridView) view.findViewById(R.id.online_grid_view);


    }

    @Override
    protected void initData() {
        sortlayout.setOnClickListener(this);
        typeLayout.setOnClickListener(this);
        rewardLayout.setOnClickListener(this);
        popuAdapter = new PopuAdapter(context);
        adapter = new GridViewAdapter(context);
        Map<String, String> map = new HashMap<>();
        map.put("entity_id", "1");
        OkHttpClientManager.postAsyn(Urls.ONLINE_POPU_URL, new OkHttpClientManager.ResultCallback<PopuBean>() {
            @Override
            public void onError(Request request, Exception e) {
                Toast.makeText(context, "请求失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(PopuBean response) {
                bean = response;
                sortTv.setText(bean.getObject().getClist().get(0).getCategory_name());
                typeTv.setText(bean.getObject().getTlist().get(0).getTitle());
                rewardTv.setText(bean.getObject().getAlist().get(0).getTitle());
            }

        }, map);


        popuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupWindow.dismiss();
                id = bean.getObject().getClist().get(i).getEntity_id();
            }
        });


        Map<String, String> maps = new HashMap<>();
        maps.put("entity_id", "1");
        OkHttpClientManager.postAsyn(Urls.ONLINE_GRID_URL, new OkHttpClientManager.ResultCallback<OnlineBean>() {
            @Override
            public void onError(Request request, Exception e) {
                Toast.makeText(context, "请求失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(OnlineBean response) {
                adapter.setData(response);
                gridView.setAdapter(adapter);
            }

        }, maps);


    }

    public void showPopuWindows(){
        WindowManager wm = (WindowManager)context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = (int) (wm.getDefaultDisplay().getWidth());


        popupWindow = new PopupWindow(popuView, width, WindowManager.LayoutParams.WRAP_CONTENT, false) {
            @Override
            public void dismiss() {
                super.dismiss();
                sortIv.setImageResource(R.mipmap.drop_top);
                rewardIv.setImageResource(R.mipmap.drop_top);
                typeIv.setImageResource(R.mipmap.drop_top);


            }
        };
        //外部获得焦点
        popupWindow.setOutsideTouchable(true);
        //内部获得焦点
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setInputMethodMode(popupWindow.INPUT_METHOD_NEEDED);
        popupWindow.showAsDropDown(parentLayout);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sort_linear_layout:
                sortIv.setImageResource(R.mipmap.dropdown);
                showPopuWindows();
                if (bean != null){
                popuAdapter.setData(bean,1);
                popuListView.setAdapter(popuAdapter);
                }

                break;
            case R.id.reward_linear_layout:
                rewardIv.setImageResource(R.mipmap.dropdown);
                showPopuWindows();
                if (bean != null){
                popuAdapter.setData(bean,2);
                popuListView.setAdapter(popuAdapter);
                }
                break;
            case R.id.type_linear_layout:
                typeIv.setImageResource(R.mipmap.dropdown);
                showPopuWindows();
                if (bean != null){
                popuAdapter.setData(bean,3);
                popuListView.setAdapter(popuAdapter);
                }
                break;
        }
    }
}
