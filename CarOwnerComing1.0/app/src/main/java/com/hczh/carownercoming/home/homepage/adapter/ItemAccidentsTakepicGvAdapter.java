package com.hczh.carownercoming.home.homepage.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.utils.MyApplication;

public class ItemAccidentsTakepicGvAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemAccidentsTakepicGvAdapter(Context context,List<T> objects) {
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_accidents_takepic_gv, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.itemAccidentsTakepicIv = (ImageView) convertView.findViewById(R.id.item_accidents_takepic_iv);
            viewHolder.itemAccidentsTakepicTv = (TextView) convertView.findViewById(R.id.item_accidents_takepic_tv);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
       Map map = (Map) object;
        String  title = (String) map.get("title");
        String picName = (String) map.get("picName");
        if(title!=null){
            holder.itemAccidentsTakepicTv.setText(title);
            holder.itemAccidentsTakepicIv.setImageResource(R.drawable.car4);
            //MyApplication.mBitmapUtils.display(holder.itemAccidentsTakepicIv,"/sdcard/" +"20160414113900.jpg");
        }

        if(!TextUtils.isEmpty(picName)){
            MyApplication.mBitmapUtils.display(holder.itemAccidentsTakepicIv,"/sdcard/" +picName+".jpg");
        }else {
            holder.itemAccidentsTakepicIv.setImageResource(R.drawable.car4);
        }





    }

    protected class ViewHolder {
        private ImageView itemAccidentsTakepicIv;
    private TextView itemAccidentsTakepicTv;
    }
}
