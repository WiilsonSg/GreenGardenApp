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

import com.wilsoncode.greengardenapp.Records.RecordWater;

public class Statistics extends AppCompatActivity {

    ImageView homeGreen;
    ImageView categoryGreen;
    ImageView staticsGreen;
    ImageView tipsGreen;
    ImageView profileGreen;

    LinearLayout ConsumoWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_statistics);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    v.getPaddingLeft(),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    systemBars.bottom
            );
            return insets;
        });

        ConsumoWater = findViewById(R.id.ConsumoWater);

        ConsumoWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, RecordWater.class);
                startActivity(intent);
            }
        });



        homeGreen = findViewById(R.id.home);
        categoryGreen = findViewById(R.id.category);
        staticsGreen = findViewById(R.id.statics);
        tipsGreen = findViewById(R.id.tips);
        profileGreen = findViewById(R.id.profile);


        homeGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Statistics.this, MainScreen.class);
                startActivity(i);
            }
        });

        categoryGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Statistics.this, Category.class);
                startActivity(i);
            }
        });

        staticsGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, Statistics.class);
                startActivity(intent);
            }
        });

        tipsGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, Tips.class);
                startActivity(intent);
            }
        });

        profileGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, ProfileEdit.class);
                startActivity(intent);
            }
        });
    }
}