package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wilsoncode.greengardenapp.helper.FileManager;
import com.wilsoncode.greengardenapp.models.User;

public class Signin extends AppCompatActivity {

    //Usuario
    User user;
    EditText email; //Entrada del correo
    EditText password; //Entrada de contraseña
    Button loginMainscreem;//Boton de iniciar sesión

    TextView recoverPassword; //Boton para ir a la pantalla de recordar contraseña
    TextView passwordEntry;
    ImageButton visibilityButton; //Boton para ver u ocultar la contraseña
    ImageView buttonGoBack; //Boton para reguresar a la pantalla principal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        //Usuario
        email                   = findViewById(R.id.emailUser);
        password                = findViewById(R.id.passwordUser);
        loginMainscreem         = findViewById(R.id.loginMain);

        loginMainscreem.setOnClickListener(v -> {login();});


        //__________________________________________________________________________________________
        //Ir a pantalla de recordar contraseña
        recoverPassword  =findViewById(R.id.contra1);
        recoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Signin.this, RecoverPassword.class);
                startActivity(k);
            }
        });

        //__________________________________________________________________________________________
        //Change vicibility password
        passwordEntry = findViewById(R.id.passwordUser);
        visibilityButton = findViewById(R.id.visibilityOff);

        visibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordEntry.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD){
                    passwordEntry.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    visibilityButton.setImageResource(R.drawable.visibility_off);
                }else {
                    passwordEntry.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    visibilityButton.setImageResource(R.drawable.visibility_on);
                }
                //Mueve el cursor al final del texto
                //passwordEntry.setSelection(passwordEntry.getText().length());
            }
        });

        //__________________________________________________________________________________________
        //Boton de retroceso
        buttonGoBack = findViewById(R.id.goBack);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signin.this, MainActivity.class);
                startActivity(i);
            }
        });
        //__________________________________________________________________________________________
    }

    //Función de login
    public void  login(){
        String email        = this.email.getText().toString();
        String password     = this.password.getText().toString();
        //Obtenemos el usuario GLOBAL de la aplicación
        user                = (User) getApplicationContext();
        user                .setDefaultData();
        user.email          = email;
        user.password       = password;

        if(!email.isEmpty() && !password.isEmpty()){

            FileManager fileManager = new FileManager(this);
            Log.e("msg", "El error esta en " + fileManager);
            //Validar credenceiles en base de datos
            User result = fileManager.findUserByEmailAndPassword(user);

            if(result != null){

                user.copyData(result); //Actualizamos el usuario GLOBAL de la aplicación con los datos de la base de datpos

                Intent intent = new Intent(this, MainScreen.class); //Ojo verificar la clase si es la correspondiente
                startActivity(intent);
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}