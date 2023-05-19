package com.example.petcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatInfomation extends AppCompatActivity {
    Button home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_infomation);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // MainActivity2 is the name of new created EmptyActivity.
                Intent intent = new Intent(CatInfomation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}