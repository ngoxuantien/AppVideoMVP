package com.example.appvideo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appvideo.R;
import com.example.appvideo.adapter.HistorySearchMovieAdapter;
import com.example.appvideo.adapter.HistoryWatchedMovieAdapter;
import com.example.appvideo.model.HistoryMovieWatched;
import com.example.appvideo.model.HistorySearch;

import java.util.ArrayList;
import java.util.List;

public class HistorySearchActivity extends AppCompatActivity {
    List<HistorySearch> list;
    RecyclerView recyclerView;
   HistorySearchMovieAdapter historySearchMovieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_search);
        list= new ArrayList<>();
        list.add(new HistorySearch(1,"hoacai"));
        setrecyclerviewAdapter();
    }
    private void setrecyclerviewAdapter() {
        recyclerView= findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(HistorySearchActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        historySearchMovieAdapter= new HistorySearchMovieAdapter(this,list);
        recyclerView.setAdapter(historySearchMovieAdapter);
    }
}