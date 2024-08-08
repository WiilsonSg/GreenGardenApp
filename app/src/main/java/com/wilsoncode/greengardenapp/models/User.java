package com.wilsoncode.greengardenapp.models;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

public class User extends Application{//
    //Atributos
    public String userName;
    public String email;
    public String imageProfile;
    public String biography;
    public String password;
    public ArrayList<CategoryType> categoryType;

    //Constructor vacio
    public User(){
        this.userName       = "";
        this.email          = "";
        this.imageProfile   = "";
        this.biography      = "";
        this.password       = "";
        this.categoryType   = new ArrayList<CategoryType>();
    }

    //Constructor con parametros
    public User(String userName, String email, String imageProfile,String biography, String password){
        this.userName       = userName;
        this.email          = email;
        this.imageProfile   = imageProfile;
        this.biography      = biography;
        this.password       = password;
        this.categoryType   = new ArrayList<CategoryType>();
    }

    public void setDefaultData(){
        this.userName       = "";
        this.email          = "";
        this.imageProfile   = "";
        this.biography      = "";
        this.password       = "";
        this.categoryType   = new ArrayList<CategoryType>();
    }

    public void copyData (User newData){
        this.userName       = newData.userName;
        this.email          = newData.email;
        this.imageProfile   = newData.imageProfile;
        this.biography      = newData.biography;
        this.password       = newData.password;
        this.categoryType   = newData.categoryType;
    }

    public void addCategory(CategoryType categoryType){
        this.categoryType.add(categoryType);
    }

    //Nos muestra los datos de la categoria registrada
    public String showCategory(){
        String lista = "";

        for (CategoryType category : this.categoryType){
            lista += "Fecha de Registro \n" ;  //+ category.dateTime.toString() + "\n\n"
            lista += category.showWaterRegister();

            Log.e("msg", "ver ciclo 1");
        }
        return lista;
    }


    public String objetcToJSON(){
        String jsonData = new Gson().toJson(this);
        return jsonData;
    }

}
