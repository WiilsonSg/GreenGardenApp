package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signin extends AppCompatActivity {

    TextView recoverPassword;
    Button loginMainscreem;
    TextView passwordEntry;
    ImageButton visibilityButton;
    ImageView buttonGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recoverPassword  =findViewById(R.id.contra1);
        recoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Signin.this, RecoverPassword.class);
                startActivity(k);
            }
        });

        loginMainscreem =(Button) findViewById(R.id.loginMain);
        loginMainscreem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signin.this, MainScreen.class);
                startActivity(i);
            }
        });

        //Change vicibility password
        passwordEntry = findViewById(R.id.password_entry);
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

        buttonGoBack = findViewById(R.id.goBack);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signin.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}