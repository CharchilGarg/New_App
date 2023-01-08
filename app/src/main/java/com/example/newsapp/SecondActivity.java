package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {


    TextView title,author,time,detail,content;
    ImageView imageView;
    Article data;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title = findViewById(R.id.Title);
        author = findViewById(R.id.detailAuthor);
        time = findViewById(R.id.secondTime);
        detail = findViewById(R.id.secondDetails);
        imageView = findViewById(R.id.secondImage);

        data = (Article) getIntent().getSerializableExtra("info");

        title.setText(data.getTitle());
        author.setText(data.getAuthor());
        time.setText(data.getPublishedAt());
        detail.setText(data.getDescription());

        String img = data.getUrlToImage();
        Picasso.get().load(img).into(imageView);


    }
}