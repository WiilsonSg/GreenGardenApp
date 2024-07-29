package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainScreenGrid extends AppCompatActivity {

    ImageView list_main;

    //Lista en grid de los huertos
    GridView list;
    ArrayList<GardenRegister> miArray2 = new ArrayList<GardenRegister>();
    GardenGrid adapter;

    GardenRegister.Plant plant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen_grid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list_main = findViewById(R.id.list);

        list_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainScreenGrid.this, MainScreen.class);
                startActivity(i);
            }
        });

        //Lista en grid de loshuertos

        list = findViewById(R.id.listGardenGrid);
        //función
        fillDataGraden();
    }

    private void fillDataGraden(){
        miArray2.add(new GardenRegister("apio", "Apio", plant.apio));
        miArray2.add(new GardenRegister("zanahoria", "Zanahoria", plant.zanahoria));
        miArray2.add(new GardenRegister("tomate", "Tomate", plant.tomate));
        miArray2.add(new GardenRegister("fresa", "Fresa", plant.fresa));

        adapter = new GardenGrid(this, miArray2);
        list.setAdapter(adapter);
    }
}