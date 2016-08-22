package com.example.admin.jewelry.encyclopedia_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.jewelry.R;

/**
 * Created by admin on 2016/8/19.
 */
public class EncyGridAdapter extends BaseAdapter {
    private EncyBean data;
    private Context context;

    public EncyGridAdapter(Context context) {
        this.context = context;
    }

    public void setData(EncyBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getObject().getHotlist().size();
    }

    @Override
    public Object getItem(int i) {
        return data.getObject().getHotlist().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.ency_grid_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.nameTv.setText(data.getObject().getHotlist().get(i).getCategory_name());
        Glide.with(context).load(data.getObject().getHotlist().get(i).getCategory_pic()).into(holder.coveredIv);
        return view;
    }

    class ViewHolder {
        ImageView coveredIv;
        TextView nameTv;

        public ViewHolder(View view) {
            coveredIv = (ImageView) view.findViewById(R.id.ency_grid_iv);
            nameTv = (TextView) view.findViewById(R.id.ency_grid_tv);
        }
    }
}
