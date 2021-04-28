package com.example.funfact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TestRecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view);
        recyclerView = findViewById(R.id.Recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        TaskAdapter taskAdapter = new TaskAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(taskAdapter);
    }
}