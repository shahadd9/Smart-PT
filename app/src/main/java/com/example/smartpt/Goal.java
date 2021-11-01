package com.example.smartpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Goal extends AppCompatActivity {
    private CheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7;
    private Button b;
    private TextView show;
    private ArrayList<String> result;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        ch1= findViewById(R.id.chest);
        ch2= findViewById(R.id.core);
        ch3= findViewById(R.id.glute);
        ch4= findViewById(R.id.shoulder);
        ch5= findViewById(R.id.leg);
        ch6= findViewById(R.id.arm);
        ch7= findViewById(R.id.back);
        b= findViewById(R.id.pickDaysBtn);
        count=0;


        show=findViewById(R.id.shows);
        result= new ArrayList<>();
        show.setEnabled(false);
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch1.isChecked()){
                    result.add("Chest");
                    count++;

                }
                else {
                    count--;
                    result.remove("Chest");
                }
                activate();

            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ch2.isChecked()){
                    result.add("Core");
                    count++;

                }
                else {
                    count--;
                    result.remove("Core");
                }
                activate();
            }
        });
        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch3.isChecked()){
                    result.add("Glue");

                    count++;

                }
                else {
                    count--;
                    result.remove("Glue");
                }
                activate();

            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch4.isChecked()){
                    result.add("Shoulder");

                    count++;

                }
                else {
                    count--;
                    result.remove("Shoulder");
                }
                activate();

            }
        });
        ch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch5.isChecked()){
                    result.add("Leg");

                    count++;

                }
                else {
                    count--;
                    result.remove("Leg");
                }
                activate();

            }
        });
        ch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch6.isChecked()){
                    result.add("Arm");

                    count++;

                }
                else {
                    count--;
                    result.remove("Arm");
                }
                activate();

            }
        });
        ch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch7.isChecked()){
                    result.add("Back");

                    count++;

                }
                else {
                    count--;
                    result.remove("Back");
                }
                activate();

            }
        });

        activate();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean empty=false;
                //##StringBuilder stringBuilder= new StringBuilder();

                // for(String a: result){
                if(result.isEmpty()){
                    empty=true;
                }
                // else {

                //stringBuilder.append(a).append("\n");
                //}
                //   }
                if(empty){
                    //show.setText(stringBuilder.toString());
                    show.setText("you must choose one at least");
                    show.setEnabled(false);
                }
                else {
                    show.setText("");
                    goFittnesLevel();
                }
            }

        });

    }
    public void goFittnesLevel(){
        Intent intent= new Intent(this, FitnessLevel.class);
        startActivity(intent);
    }

    public void activate(){

        if(count>0){

            b.setBackgroundColor(Color.parseColor("#48D0FE"));
            show.setText(" ");

        }
        else{
            b.setBackgroundColor(Color.parseColor("#D8D4D4"));

        }

    }
}