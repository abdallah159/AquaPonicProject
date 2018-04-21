package com.example.mohammed.graduationproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mohammed.graduationproject.R;
import com.example.mohammed.graduationproject.adapter.DataAdapter;
import com.example.mohammed.graduationproject.adapter.NotificationAdapter;
import com.example.mohammed.graduationproject.model.Notification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE\ndd MMM yyyy");
        String currentDateandTime = sdf.format(new Date());

        ArrayList<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Temprature Alarm", "Warning!\nThe temprature has been raised dangerously", currentDateandTime));
        notifications.add(new Notification("Ph Alarm", "Warning!\nThe Ph has been raised dangerously", currentDateandTime));
        notifications.add(new Notification("High Level Alarm", "Warning!\nThe level has been raised dangerously", currentDateandTime));
        notifications.add(new Notification("Temprature Alarm", "Warning!\nThe temprature has been raised dangerously", currentDateandTime));

        final RecyclerView recyclerView = findViewById(R.id.notification_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new NotificationAdapter(getApplicationContext(), R.layout.notification_recycler_row, notifications));


    }
}
