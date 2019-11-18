package com.example.myfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private GridView listFriends;
    private ArrayList<Friend> friends;
    private FriendAdapter friendAdapter;
    private ImageButton btnMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ativity);
        final Intent intent = getIntent();
        Toast.makeText(HomeActivity.this,"Chào mừng "+ intent.getStringExtra("username")+" đã đăng nhập thành công!", Toast.LENGTH_LONG).show();
        listFriends = (GridView) findViewById(R.id.gv_myFr);
        friends = new ArrayList<>();
        friends.add(new Friend("Thor", "is the Norse god of thunder, the sky, and agriculture. He is the son of Odin, chief of the gods, and Odin's consort Jord (Earth) and husband of the fertility goddess Sif", R.drawable.thor));
        friends.add(new Friend("G-Dragon", " G-Dragon trained for six years at South Korean entertainment label YG Entertainment before debuting in 2006 as the leader of the hip hop boy band Big Bang" +
                "", R.drawable.gdragon));
        friends.add(new Friend("Groot", "Don’t cry because it’s over, smile because it happened", R.drawable.groot));
        friends.add(new Friend("Hulk", "Insanity is doing the same thing, over and over again, but expecting different results", R.drawable.hulk));
        friends.add(new Friend("Tony Stack", "You only live once, but if you do it right, once is enough.", R.drawable.tony));
        friends.add(new Friend("Caption Mavel", " In three words I can sum up everything I’ve learned about life: it goes on", R.drawable.captain));
        friends.add(new Friend("Caption American", "To live is the rarest thing in the world. Most people exist, that is all", R.drawable.captainamerica));
        friendAdapter = new FriendAdapter(HomeActivity.this, R.layout.line_friend, friends);
        listFriends.setAdapter(friendAdapter);
        listFriends.setNumColumns(2);

        listFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend SelectorFr = friends.get(position);
                Intent intent1 = new Intent(HomeActivity.this, FriendProfileActivity.class);
                intent1.putExtra("selector", SelectorFr);
                HomeActivity.this.startActivity(intent1);
            }
        });

        btnMsg = (ImageButton) findViewById(R.id.btnMsg);
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(HomeActivity.this, MesageAtivity.class);
                HomeActivity.this.startActivity(intent2);
            }
        });
    }
}
