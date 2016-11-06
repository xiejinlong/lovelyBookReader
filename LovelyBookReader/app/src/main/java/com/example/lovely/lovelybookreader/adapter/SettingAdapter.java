package com.example.lovely.lovelybookreader.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovely.lovelybookreader.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lovely on 16/11/6.
 */

public class SettingAdapter extends BaseAdapter {

    private List<Integer> imageList = new ArrayList();
    private List<String> name = new ArrayList<>();

    public SettingAdapter(List<Integer> imageList, List<String> name) {
        this.imageList = imageList;
        this.name = name;
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return name.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(parent.getContext(), R.layout.book_setting_list_item,null);
        TextView tv = (TextView) convertView.findViewById(R.id.book_setting_list_text);
        ImageView iv = (ImageView) convertView.findViewById(R.id.book_setting_list_image);
        tv.setText(name.get(position));
        iv.setBackgroundResource(imageList.get(position));
        return convertView;
    }
}
