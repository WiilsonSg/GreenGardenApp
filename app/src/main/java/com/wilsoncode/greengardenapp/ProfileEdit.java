package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileEdit extends AppCompatActivity {

    LinearLayout changePasswordB;


    ImageView homeGreen;
    ImageView categoryGreen;
    ImageView staticsGreen;
    ImageView tipsGreen;
    ImageView profileGreen;
    LinearLayout exitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_edit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        homeGreen = findViewById(R.id.home);
        categoryGreen = findViewById(R.id.category);
        staticsGreen = findViewById(R.id.statics);
        tipsGreen = findViewById(R.id.tips);
        profileGreen = findViewById(R.id.profile);
        exitLogin = findViewById(R.id.exit);


        homeGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileEdit.this, MainScreen.class);
                startActivity(i);
            }
        });

        categoryGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileEdit.this, Category.class);
                startActivity(i);
            }
        });

        staticsGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileEdit.this, Statistics.class);
                startActivity(intent);
            }
        });

        tipsGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileEdit.this, Tips.class);
                startActivity(intent);
            }
        });

        profileGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileEdit.this, ProfileEdit.class);
                startActivity(intent);
            }
        });

        exitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileEdit.this, MainActivity.class);
                startActivity(intent);
            }
        });

        changePasswordB = findViewById(R.id.changePassword);
        changePasswordB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileEdit.this, ChangePassword.class);
                startActivity(i);
            }
        });
    }
}