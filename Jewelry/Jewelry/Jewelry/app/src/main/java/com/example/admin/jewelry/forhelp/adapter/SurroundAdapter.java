package com.example.admin.jewelry.forhelp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.jewelry.R;
import com.example.admin.jewelry.forhelp.bean.SurrondBean;

/**
 * Created by admin on 2016/8/18.
 */
public class SurroundAdapter extends BaseAdapter {

    private SurrondBean data;
    private Context context;

    public SurroundAdapter(Context context) {
        this.context = context;
    }

    public void setData(SurrondBean data) {
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
            view = LayoutInflater.from(context).inflate(R.layout.surround_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.likeTv.setText(data.getObject().getList().get(i).getLike_num());
        holder.replayTv.setText(data.getObject().getList().get(i).getReply_num());
        holder.infoTv.setText(data.getObject().getList().get(i).getTalk_info());
        holder.talkTv.setText(data.getObject().getList().get(i).getTalk_title());
        holder.timeTv.setText(data.getObject().getList().get(i).getCreate_time());
        holder.lookTv.setText(data.getObject().getList().get(i).getLook_times());
        holder.userNameTv.setText(data.getObject().getList().get(i).getHelp_userNickName());
        holder.userTitleTv.setText(data.getObject().getList().get(i).getHelp_userIdTitle());
        Glide.with(context).load(data.getObject().getList().get(i).getHelp_userHeadPic()).into(holder.userIv);
        return view;

    }

    class ViewHolder {
        ImageView userIv;
        TextView userNameTv, userTitleTv, timeTv, talkTv, infoTv, replayTv, likeTv,lookTv;

        public ViewHolder(View view) {
            userIv = (ImageView) view.findViewById(R.id.surround_user_iv);
            userNameTv = (TextView) view.findViewById(R.id.surround_user_name);
            userTitleTv = (TextView) view.findViewById(R.id.surround_user_title);
            timeTv = (TextView) view.findViewById(R.id.surround_time);
            talkTv = (TextView) view.findViewById(R.id.surround_talk_tv);
            infoTv = (TextView) view.findViewById(R.id.surround_info_tv);
            replayTv = (TextView) view.findViewById(R.id.surround_replay_tv);
            likeTv = (TextView) view.findViewById(R.id.surround_like_tv);
            lookTv = (TextView) view.findViewById(R.id.surround_look_Tv);

        }
    }
}
