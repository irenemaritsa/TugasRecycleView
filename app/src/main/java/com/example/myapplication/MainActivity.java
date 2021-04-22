package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Hero> heroes = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_hero);
        recyclerView.setHasFixedSize(true);

        heroes.addAll(HeroDataSource.getListData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter adapter = new ListHeroAdapter(heroes);
        adapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra(NewActivity.name, data.getName());
                intent.putExtra(NewActivity.detail, data.getDetail());
                intent.putExtra(NewActivity.photo, data.getPhoto());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}