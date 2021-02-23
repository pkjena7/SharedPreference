package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.sharedpreference.MainActivity.AGE_KEY;
import static com.example.sharedpreference.MainActivity.EMAIL_KEY;
import static com.example.sharedpreference.MainActivity.GENDER_KEY;
import static com.example.sharedpreference.MainActivity.LOCATION_KEY;
import static com.example.sharedpreference.MainActivity.MY_PREFERENCES;
import static com.example.sharedpreference.MainActivity.NAME_KEY;
import static com.example.sharedpreference.MainActivity.PASS_KEY;

public class HomeActivity extends AppCompatActivity {

    TextView tv1, tv2,tv3,tv4,tv5,tv6;
    Button button;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        button=findViewById(R.id.button);



        sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);

        String email = sharedPreferences.getString(EMAIL_KEY, null);
        String password = sharedPreferences.getString(PASS_KEY, null);
        String name = sharedPreferences.getString(NAME_KEY, null);
        String gender = sharedPreferences.getString(GENDER_KEY, null);
        String age = sharedPreferences.getString(AGE_KEY, null);
        String location = sharedPreferences.getString(LOCATION_KEY, null);
        tv1.setText("email id is " + email);
        tv2.setText("password is " + password);
        tv3.setText("name is " + name);
        tv4.setText("gender is " + gender);
        tv5.setText("location is " + location);
        tv6.setText("age is " + age);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });


    }
}