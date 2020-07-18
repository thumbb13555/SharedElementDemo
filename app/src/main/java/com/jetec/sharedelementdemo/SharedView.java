package com.jetec.sharedelementdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SharedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_view);
        /**取得從上個Activity得到的id*/
        int id = getIntent().getIntExtra("Detail",R.drawable.ic_launcher_background);

        /**將Intent得到的資源ID放進Shared的ImageView*/
        ImageView imageView = findViewById(R.id.imageView_Detail);
        imageView.setImageDrawable(getDrawable(id));
    }
}