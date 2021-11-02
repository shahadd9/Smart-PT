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

public class Equipment extends AppCompatActivity {
    private Button equBtn;
    private CheckBox dmbl;
    private CheckBox barbell;
    private CheckBox ball;
    private CheckBox jumpR;
    private CheckBox ktl;
    private CheckBox pullup;
    private  CheckBox btlR;
    private CheckBox band;
    private TextView t ;
    private ArrayList<String> equpmtList;
    private int count;
    private int place;  //0 for home 1 for gym
    private String level;
    private ArrayList<String> goal;
    private ArrayList<String> tDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        equBtn= findViewById(R.id.equBtn);
        dmbl=findViewById(R.id.dumbble);
        barbell=findViewById(R.id.barbell);
        ball=findViewById(R.id.ball);
        jumpR=findViewById(R.id.jumpR);
        ktl=findViewById(R.id.kettle);
        pullup=findViewById(R.id.pullUp);
        btlR=findViewById(R.id.battleR);
        band=findViewById(R.id.band);
        equpmtList=new ArrayList<>();
        level= getIntent().getStringExtra("level");
        goal=getIntent().getStringArrayListExtra("goal");
        tDays=getIntent().getStringArrayListExtra("tDays");
        place=getIntent().getIntExtra("place",0);


        //t= findViewById(R.id.textView2);

        count=0;
        dmbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dmbl.isChecked()){
                    equpmtList.add((String) dmbl.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) dmbl.getText());
                }
                activate();
            }
        });
        barbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(barbell.isChecked()){
                    equpmtList.add((String) barbell.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) barbell.getText());
                }
                activate();
            }
        });

        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ball.isChecked()){
                    equpmtList.add((String) ball.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) ball.getText());
                }
                activate();
            }
        });

        jumpR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(jumpR.isChecked()){
                    equpmtList.add((String) jumpR.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) jumpR.getText());
                }
                activate();
            }
        });
        ktl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ktl.isChecked()){
                    equpmtList.add((String) ktl.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) ktl.getText());
                }
                activate();
            }
        });

        pullup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pullup.isChecked()){
                    equpmtList.add((String) pullup.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) pullup.getText());
                }
                activate();
            }
        });

        btlR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btlR.isChecked()){
                    equpmtList.add((String) btlR.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) btlR.getText());
                }
                activate();
            }
        });

        band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(band.isChecked()){
                    equpmtList.add((String) band.getText());
                    count++;
                }
                else {
                    count--;
                    equpmtList.remove((String) band.getText());
                }
                activate();
            }
        });

        equBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean empty=false;
                //StringBuilder stringBuilder= new StringBuilder();

                // for(String a: result){
                if(equpmtList.isEmpty()){
                    empty=true;
                }
                // else {

                //stringBuilder.append(a).append("\n");
                //}
                //   }
                if(empty){
                    //show.setText(stringBuilder.toString());
                    //show.setText("you must choose one at least");
                    //show.setEnabled(false);
                }
                else {
                    //show.setText("");
                    goNext();
                }
            }

        });
    }
    public void goNext(){
        Intent intent= new Intent(this, LoadPa.class);
        intent.putExtra("tDays",tDays);
        intent.putExtra("goal",goal);
        intent.putExtra("level",level);
        intent.putExtra("place",place);
        intent.putExtra("equpmtList",equpmtList);
        startActivity(intent);
    }
    public void activate(){

        if(count>0){

            equBtn.setBackgroundColor(Color.parseColor("#48D0FE"));
            //t.setText(equpmtList.toString());

        }
        else{
            equBtn.setBackgroundColor(Color.parseColor("#D8D4D4"));
            //t.setText(equpmtList.toString());

        }

    }
}