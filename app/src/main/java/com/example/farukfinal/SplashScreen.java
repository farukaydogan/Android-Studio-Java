package com.example.farukfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    Button login;
    Button register;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(SplashScreen.this, MainNavigationDrawerActivity.class);
            startActivity(intent);
        }
        //register and login button get by id from xml
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerButton);

        //register button click listener
        register.setOnClickListener(v -> {
            Intent intent = new Intent(SplashScreen.this, RegisterActivity.class);
            startActivity(intent);
        });
        //login button click listener
        login.setOnClickListener(v -> {
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
        });

    }
}