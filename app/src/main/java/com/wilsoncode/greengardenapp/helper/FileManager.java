package com.wilsoncode.greengardenapp.helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wilsoncode.greengardenapp.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private Context context;
    private File userFile;
    private File advicesFile;

    public FileManager(Context context){
        this.context = context;
        userFile = loadFileOrCreate("db_user");
        advicesFile = loadFileOrCreate("db_advices");
    }

    //busca el usuario
    private File loadFileOrCreate(String fileName){
        File file = new File(context.getFilesDir(), fileName + ".txt");

        if(file.exists()){
            Log.e("msg", "El archivo "+ file.getName() + " ya existe en: " + file.getAbsolutePath());
            return file;
        }else {
            try {
                file.createNewFile();
                Log.e("msg", "El archivo " + file.getName() + " fue creado exitosamente en:" + file.getAbsolutePath());
                return file;
            }catch (Exception e){
                Log.e("msg", "Error al crear el archivo "+ file.getName(), e);
                return null;
            }
        }
    }
    //creamos un nuevo usuario
    public boolean insertNewUser(User user){
        try {

            if (!validateIfUserExist(user)) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true));

                writer.write(user.objetcToJSON());
                writer.newLine();
                writer.close();

                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_LONG).show();

                Log.e("msg", "Se ha insertado el nuevo usuatio en" + userFile.getName() + "exitosamente'");

                return true;
            } else {
                Toast.makeText(context, "El usuario " + user.email + " ya está registrado", Toast.LENGTH_LONG).show();
            }
        } catch (IOException e){
            Toast.makeText(context, "Error al escribir en el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public boolean validateIfUserExist(User user){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(userFile));

            String data;
            while ((data = reader.readLine()) != null){
                //Convertimos el dato leido en u objeto de tipo User
                User dbUser = new Gson().fromJson(data, User.class);

                //Si el email ya existe retornamos true
                if(dbUser.email.equals(user.email)){
                    return true;
                }
            }
            reader.close();
        }catch (IOException e) {
            Toast.makeText(context, "Error al leer el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        //Si llega hasta acá es porque el email no existe en la base de datos
        return false;
    }
    //advicesFile
    public User findUserByEmailAndPassword(User user){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));

            String data;
            while((data = reader.readLine()) != null){
                //Convertimos el dato leido en un objeto de tipo User
                User dbUser = new Gson().fromJson(data, User.class);

                Log.e("msg", "Email: " + dbUser.email + ", Password: " + dbUser.password);
                Log.e("msg", "Email: " + user.email + ", Password: " + user.password);

                if(dbUser.email.equals(user.email) && dbUser.password.equals(user.password)){
                    Log.e("msg", "Email: " + user.email + ", Password: " + user.password + " <- Correct!");

                    return dbUser;
                }

            }
            reader.close();
        }catch (IOException e){
            Toast.makeText(context, "Error al leer el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return null;
    }


    //Insert new huerto de GreenGarde
}
