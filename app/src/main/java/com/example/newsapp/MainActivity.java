package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Article> data;
    RecyclerViewAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles");
        dialog.show();

        NewsApi newsApi = RetrofitNews.getClient().create(NewsApi.class);
        Call<NewsSource> call = newsApi.getNewsFromResource("in",
                "general","9aad59de0da348d59b2e648a00649f4a");

        call.enqueue(new Callback<NewsSource>() {
            @Override
            public void onResponse(Call<NewsSource> call, Response<NewsSource> response) {
                data = response.body().getArticles();
                dialog.dismiss();
                adapter = new RecyclerViewAdapter(data,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsSource> call, Throwable t) {

            }
        });


    }
}