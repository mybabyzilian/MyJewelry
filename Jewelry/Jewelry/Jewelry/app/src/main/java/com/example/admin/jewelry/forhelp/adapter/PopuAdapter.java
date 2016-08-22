package com.example.admin.jewelry.forhelp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.jewelry.R;
import com.example.admin.jewelry.forhelp.bean.PopuBean;

/**
 * Created by admin on 2016/8/17.
 */
public class PopuAdapter extends BaseAdapter {
    private PopuBean bean;
    private Context context;
    private int type = 0;


    public PopuAdapter(Context context) {
        this.context = context;
    }

    public void setData(PopuBean bean, int type) {
        this.bean = bean;
        this.type = type;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        if (type == 1) {
            return bean.getObject().getClist().size() > 0&&bean.getObject().getClist()!=null ? bean.getObject().getClist().size() : 0;
        } else if (type == 2) {
            return bean.getObject().getAlist().size() > 0&&bean.getObject().getClist()!=null ? bean.getObject().getAlist().size() : 0;
        } else if (type == 3) {
            return bean.getObject().getTlist().size() > 0&&bean.getObject().getTlist()!=null ? bean.getObject().getTlist().size() : 0;
        } else {
            return 0;
        }
    }


    @Override
    public Object getItem(int i) {
        if (type == 1) {
            return bean.getObject().getClist().get(i);
        } else if (type == 2) {
            return bean.getObject().getTlist().get(i);
        } else if (type == 3) {
            return bean.getObject().getAlist().get(i);

        } else {
            return i;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.popu_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (type == 1) {
            holder.popuTv.setText(bean.getObject().getClist().get(i).getCategory_name());
        } else if (type == 2) {
            holder.popuTv.setText(bean.getObject().getAlist().get(i).getTitle());
        } else if (type == 3) {
            holder.popuTv.setText(bean.getObject().getTlist().get(i).getTitle());
        }
        return view;
    }

    class ViewHolder {

        TextView popuTv;

        public ViewHolder(View v) {

            popuTv = (TextView) v.findViewById(R.id.popu_item_tv);

        }

    }


}
