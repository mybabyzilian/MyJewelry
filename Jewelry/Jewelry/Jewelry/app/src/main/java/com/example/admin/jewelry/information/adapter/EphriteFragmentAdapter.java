package com.example.admin.jewelry.information.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.jewelry.R;
import com.example.admin.jewelry.information.bean.InformationBean;


/**
 * Created by admin on 2016/8/15.
 */
public class EphriteFragmentAdapter extends BaseAdapter {
    private InformationBean data;
    private Context context;


    public EphriteFragmentAdapter(Context context) {
        this.context = context;
    }

    public void setData(InformationBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getObject().getList().size();
    }

    @Override
    public Object getItem(int i) {

        return data.getObject().getList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.ephrite_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.replayTv.setText("评论：" + data.getObject().getList().get(i).getReply_num());
        holder.lookTimesTv.setText("阅读：" + data.getObject().getList().get(i).getLook_times());
        holder.titleTv.setText(data.getObject().getList().get(i).getMessage_title());
        holder.userNameTv.setText(data.getObject().getList().get(i).getMessage_userIdTitle());
        Glide.with(context).load(data.getObject().getList().get(i).getMessage_facePic()).into(holder.facepicIv);
        return view;

    }

    class ViewHolder {
        ImageView facepicIv;
        TextView titleTv, userNameTv, lookTimesTv, replayTv;

        public ViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.Ephrite_message_title);
            userNameTv = (TextView) view.findViewById(R.id.Ephrite_user_name);
            lookTimesTv = (TextView) view.findViewById(R.id.Ephrite_look_times);
            replayTv = (TextView) view.findViewById(R.id.Ephrite_reply_num);
            facepicIv = (ImageView) view.findViewById(R.id.Ephrite_message_facepic);
        }
    }

}
