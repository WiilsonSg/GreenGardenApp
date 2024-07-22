package com.wilsoncode.greengardenapp;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class GardenList extends ArrayAdapter <GardenRegister> {

    LayoutInflater infleter;
    Context context;

    public GardenList(Context context, ArrayList<GardenRegister> miArray){
        super(context, 0, miArray);
        infleter = LayoutInflater.from(context);
        this.context = context;
    }

    //@Override
    public View getView(int position, View converView, ViewGroup parent) {

        converView = infleter.inflate(R.layout.activity_garden_list, null);

        ImageView image = converView.findViewById(R.id.iconoGarden);
        TextView name = converView.findViewById(R.id.nameGarde);

        GardenRegister planta = getItem(position);

        int idRecurso = context.getResources().getIdentifier(planta.image, "drawable", context.getPackageName());
        image.setImageResource(idRecurso);

        name.setText(planta.name);

        return converView;

    }
}