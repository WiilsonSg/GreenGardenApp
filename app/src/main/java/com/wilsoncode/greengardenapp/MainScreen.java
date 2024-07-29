package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    ImageView homeGreen;
    ImageView categoryGreen;
    ImageView staticsGreen;
    ImageView tipsGreen;
    ImageView profileGreen;
    ImageView grid_main;

    //Lista de huertos
    ListView list;
    ArrayList<GardenRegister> miArray = new ArrayList<GardenRegister>();
    GardenList adapter;

    GardenRegister.Plant plant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //listGarden
        list = findViewById(R.id.listGardenView);
        fillDataGarden();

        //Botones de la barra de navegación
        homeGreen = findViewById(R.id.home);
        categoryGreen = findViewById(R.id.category);
        staticsGreen = findViewById(R.id.statics);
        tipsGreen = findViewById(R.id.tips);
        profileGreen = findViewById(R.id.profile);
        grid_main = findViewById(R.id.grid);


        homeGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainScreen.this, MainScreen.class);
                startActivity(i);
            }
        });

        categoryGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainScreen.this, Category.class);
                startActivity(i);
            }
        });

        staticsGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Statistics.class);
                startActivity(intent);
            }
        });

        tipsGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Tips.class);
                startActivity(intent);
            }
        });

        profileGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, ProfileEdit.class);
                startActivity(intent);
            }
        });

        grid_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(MainScreen.this, MainScreenGrid.class);
                startActivity(g);
            }
        });
    }

    private void fillDataGarden(){
        miArray.add(new GardenRegister("apio", "Apio", plant.apio));
        miArray.add(new GardenRegister("zanahoria", "Zanahoria", plant.zanahoria));
        miArray.add(new GardenRegister("tomate", "Tomate", plant.tomate));
        miArray.add(new GardenRegister("fresa", "Fresa", plant.fresa));

        adapter = new GardenList(this, miArray);
        list.setAdapter(adapter);
    }
}