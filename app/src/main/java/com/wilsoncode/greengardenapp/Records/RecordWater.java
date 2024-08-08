package com.wilsoncode.greengardenapp.Records;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wilsoncode.greengardenapp.R;
import com.wilsoncode.greengardenapp.helper.FileManager;
import com.wilsoncode.greengardenapp.models.User;

public class RecordWater extends AppCompatActivity {

    User user;

    TextView records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_record_water);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        records = findViewById(R.id.recordsW);

        user = ((User) getApplicationContext());

        getCategoryWater();
    }

    private void getCategoryWater(){
        FileManager fileManager = new FileManager(this);

        if(fileManager.readCategoryWater(user)){

            String recordsList = user.showCategory();
            records.setText(recordsList);

        }
        else{
            Toast.makeText(this, "No se encontraron registros", Toast.LENGTH_SHORT).show();
        }

    }

}