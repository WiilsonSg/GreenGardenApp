package com.wilsoncode.greengardenapp.models;

import android.app.Application;
import com.google.gson.Gson;

public class User extends Application {
    //Atributos
    public String userName;
    public String email;
    public String imageProfile;
    public String biography;
    public String password;

    //Constructor vacio
    public User(){
        this.userName       = "";
        this.email          = "";
        this.imageProfile   = "";
        this.biography      = "";
        this.password       = "";
    }

    //Constructor
    public User(String userName, String email, String imageProfile,String biography, String password){
        this.userName       = userName;
        this.email          = email;
        this.imageProfile   = imageProfile;
        this.biography      = biography;
        this.password       = password;
    }

    public void setDefaultData(){
        this.userName       = "";
        this.email          = "";
        this.imageProfile   = "";
        this.biography      = "";
        this.password       = "";
    }

    public void copyData (User newData){
        this.userName       = newData.userName;
        this.email          = newData.email;
        this.imageProfile   = newData.imageProfile;
        this.biography      = newData.biography;
        this.password       = newData.password;
    }

    public String objetcToJSON(){
        String jsonData = new Gson().toJson(this);
        return jsonData;
    }

}
