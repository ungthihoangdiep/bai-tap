package com.example.listnangc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Flower> flowers;

    public CustomAdapter(Context context, int layout, List<Flower> flowers) {
        this.context = context;
        this.layout = layout;
        this.flowers = flowers;
    }

    @Override
    public int getCount() {
        return flowers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView name_obj = (TextView) convertView.findViewById(R.id.name_obj);
        ImageView img_obj = (ImageView) convertView.findViewById(R.id.img_obj);
        TextView describe_obj = (TextView) convertView.findViewById(R.id.describe_obj);
        Flower flower = flowers.get(position);
        name_obj.setText(flower.getName_flower());
        img_obj.setImageResource(flower.getImg_flower());
        describe_obj.setText(flower.getDescribe());


        return convertView;
    }
}
