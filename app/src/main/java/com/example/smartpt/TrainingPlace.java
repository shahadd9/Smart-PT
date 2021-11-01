package com.example.smartpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrainingPlace extends AppCompatActivity {
    Button home;
    Button gym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_place);

        home = findViewById(R.id.homeBtn);
        gym= findViewById(R.id.gymBtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goEqupment2();
            }
        });

        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goEqupment2();
            }
        });
    }

    public void goEqupment2(){
        Intent intent= new Intent(this, Equipment.class);
        startActivity(intent);
    }
}