package com.wilsoncode.greengardenapp.models;

import android.widget.EditText;

public class WaterRegister {

    public String date;
    public double volume;
    public double cost;

    public WaterRegister(){
        this.date = "";
        this.volume = 0;
        this.cost = 0;
    }
    public WaterRegister(String date, double volume, double cost){
        this.date = date;
        this.volume = volume;
        this.cost = cost;
    }
}




