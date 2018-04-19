package com.example.mohammed.graduationproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammed.graduationproject.model.Notification;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Handler handler;
    Button watchOutDataBtn;
    Button setAlarmBtn;
    Button notificationBtn;
    TextView dateTV;
    TextView cityNameTV;
    TextView tempTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        watchOutDataBtn = findViewById(R.id.watch_out_data_btn);
        watchOutDataBtn.setOnClickListener(this);
        setAlarmBtn = findViewById(R.id.set_alarm_btn);
        setAlarmBtn.setOnClickListener(this);
        notificationBtn = findViewById(R.id.notification_btn);
        notificationBtn.setOnClickListener(this);

        dateTV = findViewById(R.id.date_main_activity);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy");
        String currentDateandTime = sdf.format(new Date());
        dateTV.setText(currentDateandTime);

        handler = new Handler();
        GPSTracker mGPS = new GPSTracker(this);

        cityNameTV = findViewById(R.id.city_nameTV);
        if (mGPS.canGetLocation) {
            mGPS.getLocation();
            cityNameTV.setText("Lat" + mGPS.getLatitude() + "Lon" + mGPS.getLongitude());
        } else {
            cityNameTV.setText("Unabletofind");
            System.out.println("Unable");
        }


    }

    @Override
    public void onClick(View v) {
        if (v == watchOutDataBtn) {
            startActivity(new Intent(MainActivity.this, WatchOutActivity.class));
        } else if (v == setAlarmBtn) {
            startActivity(new Intent(MainActivity.this, AlarmActivity.class));
        } else if (v == notificationBtn) {
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        }
    }
}
