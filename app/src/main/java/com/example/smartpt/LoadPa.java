package com.example.smartpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import android.widget.Toast;
import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class LoadPa extends AppCompatActivity {
    private ImageView logo;
    private FirebaseFirestore db;
    private int place;  //0 for home 1 for gym
    private String level;
    private ArrayList<String> goal;
    private ArrayList<String> tDays;
    private ArrayList<String> equpmtList;
    private String userIp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_pa);
        logo= findViewById(R.id.imageView4);
        level= getIntent().getStringExtra("level");
        goal=getIntent().getStringArrayListExtra("goal");
        tDays=getIntent().getStringArrayListExtra("tDays");
        place=getIntent().getIntExtra("place",0);
        equpmtList= getIntent().getStringArrayListExtra("equpmtList");
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        userIp=Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        rotateAnimation();
        add();
    }

    private void add() {
        db = FirebaseFirestore.getInstance();
        Map<String,Object> user = new HashMap<>();
        user.put("focusArea",goal.toString());
        user.put("level",level);
        user.put("trainingDays",tDays.toString());
        user.put("trainingPlace",place);
        user.put("equipment",equpmtList.toString());

        db.collection("userProfile").document(userIp).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(Goal.this,"successful",Toast.LENGTH_SHORT);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(Goal.this,"Faild",Toast.LENGTH_SHORT);
            }
        });

    }

    private void rotateAnimation() {

        Animation rotate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

                logo.setAnimation(rotate);
    }
}