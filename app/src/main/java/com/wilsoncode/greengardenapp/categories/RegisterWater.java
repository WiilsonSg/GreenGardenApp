package com.wilsoncode.greengardenapp.categories;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wilsoncode.greengardenapp.R;
import com.wilsoncode.greengardenapp.Records.RecordWater;
import com.wilsoncode.greengardenapp.helper.FileManager;
import com.wilsoncode.greengardenapp.models.CategoryType;
import com.wilsoncode.greengardenapp.models.User;
import com.wilsoncode.greengardenapp.models.WaterRegister;

import java.util.ArrayList;

public class RegisterWater extends AppCompatActivity {

    User user;
    CategoryType categoryType;
    ArrayList<WaterRegister> waterRegisters;
    EditText dateWater;
    EditText volumeWater;
    EditText costWater;

    Button registerWater;
    Button ViewButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_water);
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

        ViewButton = findViewById(R.id.ViewButton);

        ViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterWater.this, RecordWater.class);
                startActivity(intent);
            }
        });


        waterRegisters = new ArrayList<WaterRegister>();


        //recuperamos el usuario GLOBAL de la app
        user = ((User) getApplicationContext());

        categoryType = new CategoryType();
        categoryType.waterRegisters = waterRegisters;


        volumeWater = findViewById(R.id.volumeW);
        costWater = findViewById(R.id.costW);
        dateWater = findViewById(R.id.dateW);
        registerWater = findViewById(R.id.registerW);

        registerWater.setOnClickListener(viw ->{
            try {
            WaterRegister waterRegister = new WaterRegister();
            waterRegister.date = dateWater.getText().toString();
            waterRegister.volume = Double.parseDouble(volumeWater.getText().toString());
            waterRegister.cost = Double.parseDouble(costWater.getText().toString());

            categoryType.addWaterRegister(waterRegister);

            user.addCategory(categoryType);
            //Almecenamos el usuario en la base de datos
            storageUserInDatabase();

            Toast.makeText(this, "Se han registrado correctamente", Toast.LENGTH_SHORT).show();

            //Limpia los campos despúes del registro
            volumeWater.setText("");
            costWater.setText("");
            dateWater.setText("");

            }catch (Exception e){
                Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show();
                Log.e("RegisterWater", "Error en los datos ingresados", e);
            }

            user.addCategory(categoryType);
            storageUserInDatabase();



        });


    }

    private void storageUserInDatabase(){
        FileManager fileManager = new FileManager(this);
        fileManager.insertNewCategory(user);
    }
}






















