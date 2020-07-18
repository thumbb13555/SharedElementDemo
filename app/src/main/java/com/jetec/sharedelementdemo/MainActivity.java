package com.jetec.sharedelementdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**設置圖片陣列*/
        int[] images = {R.drawable.ic_baseline_drive_eta_24
                , R.drawable.ic_baseline_computer_24
                , R.drawable.ic_baseline_child_friendly_24};

        /**設置Recyclerview*/
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(images);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        /**取得點擊Recyclerview得到的內容*/
        adapter.ItemClick(new RecyclerViewAdapter.OnImageClick() {
            @Override
            public void onImageClick(int imageId, ImageView imageView) {
                /**點擊後，跳轉至Shared Element*/
                Intent intent = new Intent(MainActivity.this, SharedView.class);
                /**挾帶資料*/
                intent.putExtra("Detail", imageId);
                /**設置Activity跳轉傳輸動畫*/
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this, imageView, ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());

            }
        });
    }
}