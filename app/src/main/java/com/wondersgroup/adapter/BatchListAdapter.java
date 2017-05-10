package com.wondersgroup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wondersgroup.padgrade.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Buger on 17/5/10/010.
 * 考评员选择批次
 */

public class BatchListAdapter extends BaseAdapter {

    private List<Map<String,Object>> list;
    private Context context;

    public BatchListAdapter(List<Map<String, Object>> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.batch_check_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tv1 = (TextView) convertView.findViewById(R.id.tv_batch_check1);
            viewHolder.tv2 = (TextView) convertView.findViewById(R.id.tv_batch_check2);
            viewHolder.tv3 = (TextView) convertView.findViewById(R.id.tv_batch_check3);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Map<String,Object> map = list.get(position);
        viewHolder.tv1.setText((String)map.get("title"));
        viewHolder.tv2.setText((String)map.get("address"));
        viewHolder.tv3.setText((String)map.get("time"));
        return convertView;
    }

    class ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }
}
