package com.wilsoncode.greengardenapp;

public class GardenRegister {
    String image;
    String name;
    String archivo_plant;

    enum Plant{apio, zanahoria, tomate, fresa}

    public GardenRegister(String image, String name, Plant plant){
        this.image = image;
        this.name = name;

        switch (plant){
            case apio:
                archivo_plant = "apio";
                break;
            case zanahoria:
                archivo_plant = "zanahoria";
            case tomate:
                archivo_plant = "tomate";
            case fresa:
                archivo_plant = "fresa";
            default:
                archivo_plant = "";
        }
    }
}
