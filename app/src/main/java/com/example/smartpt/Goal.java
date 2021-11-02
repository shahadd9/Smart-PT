package com.example.smartpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Goal extends AppCompatActivity {
    private CheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7;
    private Button b;
    private TextView show;
    private ArrayList<String> focusArea;
    private int count;
    private FirebaseFirestore db;
    private String userIp;
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
        focusArea= new ArrayList<>();
        show.setEnabled(false);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        userIp=Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        //show.setText(userIp);
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch1.isChecked()){
                    focusArea.add("Chest");
                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Chest");
                }
                activate();

            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ch2.isChecked()){
                    focusArea.add("Core");
                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Core");
                }
                activate();
            }
        });
        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch3.isChecked()){
                    focusArea.add("Glue");

                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Glue");
                }
                activate();

            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch4.isChecked()){
                    focusArea.add("Shoulder");

                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Shoulder");
                }
                activate();

            }
        });
        ch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch5.isChecked()){
                    focusArea.add("Leg");

                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Leg");
                }
                activate();

            }
        });
        ch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch6.isChecked()){
                    focusArea.add("Arm");

                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Arm");
                }
                activate();

            }
        });
        ch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch7.isChecked()){
                    focusArea.add("Back");

                    count++;

                }
                else {
                    count--;
                    focusArea.remove("Back");
                }
                activate();

            }
        });

        activate();
        //db = FirebaseFirestore.getInstance();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean empty=false;

                if(focusArea.isEmpty()){
                    empty=true;
                }

                if(empty){
                    show.setText("you must choose one at least");
                    show.setEnabled(false);
                }
                else {
                    show.setText("");
//                    Map<String,Object> user = new HashMap<>();
//                    user.put("focusArea",result.toString());
//                    db.collection("userProfile").document(userIp).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(Goal.this,"successful",Toast.LENGTH_SHORT);
//                            }
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Goal.this,"Faild",Toast.LENGTH_SHORT);
//
//                        }
//                    });

                    goFittnesLevel();
                }
            }

        });

    }
    public void goFittnesLevel(){
        Intent intent= new Intent(this, FitnessLevel.class);
        intent.putExtra("goal",focusArea);
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