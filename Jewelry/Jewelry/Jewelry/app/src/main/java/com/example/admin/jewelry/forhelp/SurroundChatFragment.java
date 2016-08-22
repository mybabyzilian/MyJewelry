package com.example.admin.jewelry.forhelp;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.base.BaseFragment;
import com.example.admin.jewelry.forhelp.adapter.SurroundAdapter;
import com.example.admin.jewelry.forhelp.bean.SurrondBean;
import com.example.admin.jewelry.netrequest.OkHttpClientManager;
import com.example.admin.jewelry.netrequest.Urls;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/8/16.
 */
public class SurroundChatFragment extends BaseFragment {
    private ListView listView;
    private SurroundAdapter adapter;
    private PopupWindow popupWindow;
    private View popuView;
    private RelativeLayout relativeLayout;
    private ImageView popuIv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_chat_surround;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.surround_list);
        adapter = new SurroundAdapter(context);
        popuView = LayoutInflater.from(context).inflate(R.layout.surround_popu,null);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.surround_jewelry_layout);
        popuIv = (ImageView) view.findViewById(R.id.surround_popu_iv);

    }

    @Override
    protected void initData() {
        Map<String, String> maps = new HashMap<>();
        maps.put("entity_id", "1");
        OkHttpClientManager.postAsyn(Urls.SURROUND_URL, new OkHttpClientManager.ResultCallback<SurrondBean>() {
            @Override
            public void onError(Request request, Exception e) {
                Toast.makeText(context, "请求失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(SurrondBean response) {
                adapter.setData(response);
                listView.setAdapter(adapter);
            }

        }, maps);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopuWindows();
                popuIv.setImageResource(R.mipmap.drop_top);
            }
        });

    }
    public void showPopuWindows(){
        WindowManager wm = (WindowManager)context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = (int) (wm.getDefaultDisplay().getWidth());


        popupWindow = new PopupWindow(popuView, width, WindowManager.LayoutParams.WRAP_CONTENT, false) {
            @Override
            public void dismiss() {
                super.dismiss();
                popuIv.setImageResource(R.mipmap.drop_top);

            }
        };
        //外部获得焦点
        popupWindow.setOutsideTouchable(true);
        //内部获得焦点
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setInputMethodMode(popupWindow.INPUT_METHOD_NEEDED);
        popupWindow.showAsDropDown(relativeLayout);

    }
}
