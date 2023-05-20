package com.example.petcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class reminderActivity extends AppCompatActivity implements  View.OnClickListener{

    Button home;
    Button setBtn;
    private int notification = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // MainActivity2 is the name of new created EmptyActivity.
                Intent intent = new Intent(reminderActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //set onclick listener
        findViewById(R.id.setBtn).setOnClickListener(this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);



    }

    @Override
    public void onClick(View view){
        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.timePicker);

        //set notification and text
        Intent intent = new Intent(reminderActivity.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notification); //changed from notificationId to notification
        intent.putExtra("todo", editText.getText().toString());

        //getBroadcast(context, request code, intent, flag)
        PendingIntent alarmIntent = PendingIntent.getBroadcast(reminderActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarm = (AlarmManager)  getSystemService(ALARM_SERVICE);


        int id = view.getId();

        if (id == R.id.setBtn){
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            ///create time
            Calendar startTime = Calendar.getInstance();
            startTime.set(Calendar. HOUR_OF_DAY, hour);
            startTime.set(Calendar. MINUTE, minute);
            startTime.set(Calendar. SECOND, 0);
            long alarmStartTime = startTime.getTimeInMillis();

            //Set alarm.
            //set(type, milliseconds, intent)
            alarm.set(AlarmManager. RTC_WAKEUP, alarmStartTime, alarmIntent);
            Toast.makeText(this, "Done!", Toast. LENGTH_SHORT).show();
        } else if (id == R.id.cancelBtn)
        {
            alarm.cancel(alarmIntent);
            Toast.makeText(this, "Canceled.", Toast. LENGTH_SHORT).show();
        }

    }
}