package com.example.myfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Friend> friends;
    private ImageView avtFr;
    private TextView nameFr;

    public FriendAdapter(Context context, int layout, List<Friend> friends) {
        this.context = context;
        this.layout = layout;
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return friends.size();
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

        avtFr = (ImageView) convertView.findViewById(R.id.img_avtFr);
        nameFr = (TextView) convertView.findViewById(R.id.tvFr);

        Friend friend = friends.get(position);
        nameFr.setText(friend.getName());
        avtFr.setImageResource(friend.getAvt_fr());
        return convertView;
    }
}
