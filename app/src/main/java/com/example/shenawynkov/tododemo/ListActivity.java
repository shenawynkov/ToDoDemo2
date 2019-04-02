package com.example.shenawynkov.tododemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shenawynkov.tododemo.adapter.MyAdapter;
import com.example.shenawynkov.tododemo.data.AppDatabase;
import com.example.shenawynkov.tododemo.dbBackground.Tasks;

public class ListActivity extends BasicAcivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private  AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(getApplicationContext());
        new Tasks().new getTasks(getApplicationContext(),mAdapter).execute();


        recyclerView.setAdapter(mAdapter);
    }
}
