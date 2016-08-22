package com.example.admin.jewelry.forhelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.jewelry.R;
import com.example.admin.jewelry.forhelp.bean.OnlineBean;

/**
 * Created by admin on 2016/8/17.
 */
public class GridViewAdapter extends BaseAdapter {
    private OnlineBean data;
    private Context context;

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(OnlineBean data) {
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
            view = LayoutInflater.from(context).inflate(R.layout.online_grid_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.helpTv.setText(data.getObject().getList().get(i).getHelp_money());
        holder.titleTv.setText(data.getObject().getList().get(i).getHelp_title());
        if (data.getObject().getList().get(i).getHelp_type().equals("MONEY")){
            holder.rewardTv.setText("元");
        }else if(data.getObject().getList().get(i).getHelp_type().equals("SCORE")) {
            holder.rewardTv.setText("积分");
        }
        Glide.with(context).load(data.getObject().getList().get(i).getHelp_facePic()).into(holder.faceIv);
        Glide.with(context).load(data.getObject().getList().get(i).getHelp_userHeadPic()).into(holder.userIv);

        return view;
    }

    class ViewHolder {
        ImageView faceIv, userIv;
        TextView titleTv, helpTv,rewardTv;

        public ViewHolder(View view) {
            faceIv = (ImageView) view.findViewById(R.id.grid_facepic_iv);
            userIv = (ImageView) view.findViewById(R.id.user_grid_iv);
            titleTv = (TextView) view.findViewById(R.id.user_help_title);
            helpTv = (TextView) view.findViewById(R.id.help_money_tv);
            rewardTv = (TextView) view.findViewById(R.id.reward_type);


        }
    }
}
