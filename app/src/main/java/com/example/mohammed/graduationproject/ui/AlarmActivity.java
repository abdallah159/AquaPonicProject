package com.example.mohammed.graduationproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohammed.graduationproject.R;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {

    EditText tempET;
    EditText levelET;
    EditText phET;
    Button tempCancelBtn;
    Button levelCancelBtn;
    Button phCancelBtn;
    Button tempOkBtn;
    Button levelOkBtn;
    Button phOkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        tempET = findViewById(R.id.tempET);
        levelET=findViewById(R.id.levelET);
        phET=findViewById(R.id.phET);

        tempCancelBtn=findViewById(R.id.temp_clearBtn);
        tempCancelBtn.setOnClickListener(this);
        tempOkBtn=findViewById(R.id.temp_okBtn);
        tempOkBtn.setOnClickListener(this);


        levelCancelBtn=findViewById(R.id.level_clearBtn);
        levelCancelBtn.setOnClickListener(this);
        levelOkBtn=findViewById(R.id.level_okBtn);
        levelOkBtn.setOnClickListener(this);

        phCancelBtn=findViewById(R.id.ph_clearBtn);
        phCancelBtn.setOnClickListener(this);
        phOkBtn=findViewById(R.id.ph_okBtn);
        phOkBtn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if (v==tempCancelBtn){
            tempET.setText(null);
        }else if (v==tempOkBtn){
            Toast.makeText(this, "Temprature alarm submitted Succesfully", Toast.LENGTH_SHORT).show();
        }if (v==phCancelBtn){
            phET.setText(null);
        }else if (v==phOkBtn){
            Toast.makeText(this, "Ph alarm submitted Succesfully", Toast.LENGTH_SHORT).show();
        }if (v==levelCancelBtn){
            levelET.setText(null);
        }else if (v==levelOkBtn){
            Toast.makeText(this, "Level alarm submitted Succesfully", Toast.LENGTH_SHORT).show();
        }

    }
}
