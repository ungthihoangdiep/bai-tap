package com.example.listnangc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView flowerList;
    private ArrayList<Flower> flowers;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowerList = findViewById(R.id.gv_flower);
        flowers = new ArrayList<>();
        flowers.add(new Flower(R.drawable.hongnhung, "Hoa Hồng Nhung","Biểu hiện của tình yêu, lòng biết ơn, sự cảm kích, sự nhã nhặn, ngọt ngào và đầy tính thi ca."));
        flowers.add(new Flower(R.drawable.hoacuc, "Hoa Cúc","Ý nghĩa chung của hoa cúc thể hiện sự ngây thơ và vẻ đẹp thanh khiết. Một bó hoa cúc có thể nâng tâm hồn của ai đó hay làm một ngày làm việc của người nhận trở nên vui tươi hơn."));
        flowers.add(new Flower(R.drawable.hoadienvi, "Hoa Diên Vĩ","chúng thể hiện sự thông cảm sâu sắc. Hơn 200 màu sắc khác nhau, hoa diên vĩ xuất phát từ tiếng Hy Lạp nghĩa là cầu vồng"));
        flowers.add(new Flower(R.drawable.hoacamchuong, "Hoa Cẩm Chướng"," Ý nghĩa của từ Dianthus tạm dịch là bông hoa tình yêu hay loài hoa của các vị thần."));

        adapter = new CustomAdapter(MainActivity.this, R.layout.style, flowers);
        flowerList.setAdapter(adapter);

    }
}
