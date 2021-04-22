package com.example.appvideo.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appvideo.R;
import com.example.appvideo.adapter.HistorySearchMovieAdapter;
import com.example.appvideo.adapter.HistoryWatchedMovieAdapter;
import com.example.appvideo.model.HistoryMovieWatched;
import com.example.appvideo.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    List<HistoryMovieWatched> list;
    RecyclerView recyclerView;
    HistoryWatchedMovieAdapter historyWatchedMovieAdapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        list = new ArrayList<>();
        list.add(new HistoryMovieWatched(1, "R", "t", "k"));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("historyWatched");
        setLogin();

    }

    private void setrecyclerviewAdapter(List<HistoryMovieWatched> list) {
        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        historyWatchedMovieAdapter = new HistoryWatchedMovieAdapter(this, list);
        recyclerView.setAdapter(historyWatchedMovieAdapter);
    }

    private void setLogin() {

        //    List<User> listfriebase = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    list.add(dataSnapshot.getValue(HistoryMovieWatched.class));

                }
setrecyclerviewAdapter(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}