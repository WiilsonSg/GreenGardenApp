package com.wilsoncode.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TermsConditions extends AppCompatActivity {

    TextView texpolicies;
    String paragraph;
    Button acepTerms, noAcepTerm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terms_conditions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texpolicies = findViewById(R.id.textCondition);
        paragraph = getString(R.string.styled_text_terms);
        acepTerms = (Button) findViewById(R.id.actpTerms);
        noAcepTerm = (Button) findViewById(R.id.noAcep);

        SpannableString spannableString = new SpannableString(paragraph);
        String keyword = "Política";
        int startIndex = paragraph.indexOf(keyword);
        int endIndex = startIndex + keyword.length();

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i = new Intent(TermsConditions.this, Political.class);
                startActivity(i);
            }
        };
        // Aplicar el ClickableSpan al texto del párrafo
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Establecer el texto del TextView como SpannableString y habilitar los enlaces clicables
        texpolicies.setText(spannableString);
        texpolicies.setMovementMethod(LinkMovementMethod.getInstance());


        acepTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermsConditions.this, Signup.class);
                startActivity(intent);
            }
        });

        noAcepTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(TermsConditions.this,MainActivity.class);
                startActivity(intent2);
            }
        });


    }
}