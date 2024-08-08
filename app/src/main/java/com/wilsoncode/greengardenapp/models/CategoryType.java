package com.wilsoncode.greengardenapp.models;

import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CategoryType {

    public String       dateTime;
    public double       cost; //costo del gasto en pesos promedio
    public ArrayList<WaterRegister> waterRegisters;
//    public ArrayList<LightRegister> lightRegisters;
//    public ArrayList<AbonoRegister> abonoRegisters;
//    public ArrayList<GardenRegister> gardenRegisters;

//Constructor vacio
    public CategoryType(){
        this.dateTime = "";//LocalDateTime.now().toString();
        this.cost = 0;
        this.waterRegisters = new ArrayList<WaterRegister>();
    }
//Constructor con parámetros
    public CategoryType(String dateTime, double cost, ArrayList<WaterRegister> waterRegisters){
        this.dateTime =  dateTime;//LocalDateTime.now().toString();
        this.cost = cost;
        this.waterRegisters = waterRegisters;
    }
//Agregar un waterRegister
    public void addWaterRegister(WaterRegister waterRegister){
        this.waterRegisters.add(waterRegister);
    }
//Mostrar
    public String showWaterRegister(){
        String lista = "";
        for (WaterRegister waterRegister : waterRegisters){
            lista += ">>Consumo en m3 " + waterRegister.volume + "\n";
            lista += "  precio " + waterRegister.cost + " COP\n";
            lista += "  fecha " + waterRegister.date + "\n";
            lista += " ____________________________________________";
            Log.e("msg", "ver ciclo 2");
        }

        lista += "================================\n\n";
        return lista;
    }
//Convertir a JSON
    public String objetcToJSON(){
        String jsonData = new Gson().toJson(this);
        return jsonData;
    }
}
