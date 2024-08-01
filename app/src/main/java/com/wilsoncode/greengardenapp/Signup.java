package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.wilsoncode.greengardenapp.helper.FileManager;
import com.wilsoncode.greengardenapp.models.User;

public class Signup extends AppCompatActivity {

    //Datos del usuario
    User user;
    EditText user_name;
    EditText user_email;
    EditText password;
    EditText password_confirm;
    Button singUpButtonGo;


    ImageView buttonGoBack;//Boton de regreso
    CheckBox goTerm;
    String termClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);


        // Boton ir atras pantalla de inicio
        buttonGoBack = findViewById(R.id.goBack);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this, MainActivity.class);
                startActivity(i);
            }
        });


        //Registro de usuario
        user_name           =findViewById(R.id.enterYourName);
        user_email          =findViewById(R.id.enterYourEmail);
        password            =findViewById(R.id.enterYourPassword);
        password_confirm    =findViewById(R.id.enterYourRePassword);
        singUpButtonGo      =findViewById(R.id.singUpButton);


        //Boton de registrarse
        singUpButtonGo.setOnClickListener(view ->{
            //Registrar usuarios en la base de datos
            user = new User();
            user.userName = user_name.getText().toString();
            user.email = user_email.getText().toString();
            user.password = password.getText().toString();

            storageUserInDatabase();
        });

        //CheckBox
        termClick = getString(R.string.checkBoxGreen);
        goTerm = findViewById(R.id.checkBoxTerm);

        SpannableString spannableString = new SpannableString(termClick);
        String keyword = "Términos.";
        int startIndex = termClick.indexOf(keyword);
        int endIndex = startIndex + keyword.length();

        ClickableSpan clickableSpan =  new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i = new Intent(Signup.this, TermsConditions.class);
                startActivity(i);
            }
        };

        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        goTerm.setText(spannableString);
        goTerm.setMovementMethod(LinkMovementMethod.getInstance());



    }

    private void storageUserInDatabase(){

        FileManager fileManager = new FileManager(this);

        if(fileManager.insertNewUser(user)){
            Intent intent = new Intent(this, Signin.class);
            startActivity(intent);
        }
    }
}