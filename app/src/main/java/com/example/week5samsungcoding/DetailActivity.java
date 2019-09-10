package com.example.week5samsungcoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView ivDetail;
    TextView tvDetailTitle;
    TextView tvDetailDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent passedIntent = getIntent();
        Bundle passedBundle = passedIntent.getExtras();

        //TODO get this

        //


    }


}
