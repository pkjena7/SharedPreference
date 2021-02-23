package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    EditText email,password,gender,location,age,name;
    Button login;
    SharedPreferences sharedPreferences;

    static final String MY_PREFERENCES = "myPref";
    static final String EMAIL_KEY = "email";
    static final String PASS_KEY = "password";
    static final String GENDER_KEY = "gender";
    static final String LOCATION_KEY = "location";
    static final String AGE_KEY = "age";
    static final String NAME_KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

//        DeviceFile -> data -> data -> package name -> shared_pref -> file
        sharedPreferences = getSharedPreferences(MY_PREFERENCES,MODE_PRIVATE);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        name=findViewById(R.id.name);
        gender=findViewById(R.id.gender);
        location=findViewById(R.id.location);
        age=findViewById(R.id.age);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(EMAIL_KEY,email.getText().toString());
                editor.putString(PASS_KEY,password.getText().toString());
                editor.putString(NAME_KEY,name.getText().toString());
                editor.putString(GENDER_KEY,gender.getText().toString());
                editor.putString(LOCATION_KEY,location.getText().toString());
                editor.putString(AGE_KEY,age.getText().toString());
                editor.apply();

                Intent intent=new Intent(context,HomeActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_SHORT);
            }
        });
    }

}