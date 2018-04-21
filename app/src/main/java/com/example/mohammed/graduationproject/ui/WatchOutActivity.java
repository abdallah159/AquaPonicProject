package com.example.mohammed.graduationproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mohammed.graduationproject.R;
import com.example.mohammed.graduationproject.adapter.DataAdapter;
import com.example.mohammed.graduationproject.model.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WatchOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_out);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE\ndd MMM yyyy");
        String currentDateandTime = sdf.format(new Date());

        ArrayList<Data> dataArrayList = new ArrayList<>();
        dataArrayList.add(new Data(currentDateandTime, 25, 7, 2));
        dataArrayList.add(new Data(currentDateandTime, 26, 7, 2));
        dataArrayList.add(new Data(currentDateandTime, 27, 7, 2));
        dataArrayList.add(new Data(currentDateandTime, 24, 7, 2));
        dataArrayList.add(new Data(currentDateandTime, 23, 7, 2));

        final RecyclerView recyclerView = findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new DataAdapter(getApplicationContext(), R.layout.data_recycler_row, dataArrayList));


    }
}
