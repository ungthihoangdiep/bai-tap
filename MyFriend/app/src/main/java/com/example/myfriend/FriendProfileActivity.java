package com.example.myfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendProfileActivity extends AppCompatActivity {
    private ImageView avtProfile;
    private TextView nameProfile, sttProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profile);
        Intent intent = getIntent();
        Friend friend = (Friend) intent.getSerializableExtra("selector");
        Mapping();
        avtProfile.setImageResource(friend.getAvt_fr());
        nameProfile.setText(friend.getName());
        sttProfile.setText(friend.getStatus());

    }

    private void Mapping() {
        avtProfile = (ImageView) findViewById(R.id.avtProfile);
        nameProfile = (TextView) findViewById(R.id.nameProfile);
        sttProfile = (TextView) findViewById(R.id.sttProfile);
    }
}
