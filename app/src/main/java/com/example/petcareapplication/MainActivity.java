package com.example.petcareapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {

    // declare variables
    FirebaseAuth auth;
    Button button;
    TextView textView, id;
    FirebaseUser user;
    ImageView dogInfo;
    ImageView catInfo;
    ImageView reminderPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables values
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // initialize Dog imageView
        // with method findViewById()
        dogInfo = findViewById(R.id.dog);

        // initialize cat imageView
        // with method findViewById()
        catInfo = findViewById(R.id.cat);

        // initialize reminder imageView
        // with method findViewById()
        reminderPage = findViewById(R.id.reminder);

        // initialize logout button
        // with method findViewById()
        button = findViewById(R.id.logout);

        // initialize textView
        // with method findViewById()
        textView = findViewById(R.id.user_details);

        // Apply OnClickListener  to imageView to switch from one activity to another
        // in this instance the Dog image view is used to navigate to the 'Dog Information' Page.
        dogInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // MainActivity2 is the name of new created EmptyActivity.
                // MainActivity2 holds the 'Dog Information' page
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        // Apply OnClickListener  to imageView to switch from one activity to another
        // in this instance the cat image view is used to navigate to the 'Cat Information' Page.
        catInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // CatInformation is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, CatInfomation.class);
                startActivity(intent);
                finish();
            }
        });

        // Apply OnClickListener  to imageView to switch from one activity to another
        // in this instance the reminder image view is used to navigate to the 'reminderActivity' Page.
        reminderPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // reminderActivity is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, reminderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Checks if the user is logged in
        if (user == null){
            // If the user has not logged in then they are taken to the login page.
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        } else{
            // sets the top text view as the users email.
            textView.setText(user.getEmail());
        }

        // Apply OnClickListener to button to switch from one activity to another
        // in this instance the button is used to navigate to the 'login' Page when the logout button is clicked.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}