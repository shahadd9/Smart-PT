package com.example.smartpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingPlace extends AppCompatActivity {
    private Button home;
    private Button gym;
    private int place;  //0 for home 1 for gym
    private String level;
    private ArrayList<String> goal;
    private ArrayList<String> tDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_place);
        place=0;
        home = findViewById(R.id.homeBtn);
        gym= findViewById(R.id.gymBtn);
        level= getIntent().getStringExtra("level");
        goal=getIntent().getStringArrayListExtra("goal");
        tDays=getIntent().getStringArrayListExtra("tDays");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                place=0;
                goEqupment2();
            }
        });

        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                place=1;
                goEqupment2();
            }
        });
    }

    public void goEqupment2(){
        Intent intent= new Intent(this, Equipment.class);
        intent.putExtra("tDays",tDays);
        intent.putExtra("goal",goal);
        intent.putExtra("level",level);
        intent.putExtra("place",place);
        startActivity(intent);
    }
}