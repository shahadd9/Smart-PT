package com.example.smartpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class FitnessLevel extends AppCompatActivity {
    private int level;
    private Button pickDaysBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_level);
        pickDaysBtn=findViewById(R.id.pickDaysBtn);
        SeekBar seekBar = (SeekBar)findViewById(R.id.lvlSeekBar);
        final TextView seekBarValue = (TextView)findViewById(R.id.seekBarValue);
        TextView tLvl= findViewById(R.id.lvl);
        level=0;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(progress)+"/100");
                int lvl=progress;
                if(lvl<=33){
                    tLvl.setText("Beginner");
                    level=1;
                }
                else if(lvl>33 && lvl<= 66){
                    tLvl.setText("Intermediate");
                    level=2;
                }
                else{
                    tLvl.setText("Professional");
                    level=3;

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
        pickDaysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                goTrainingDays();
            }


        });
    }
    public void goTrainingDays(){
        Intent intent= new Intent(this, TrainingDays.class);
        startActivity(intent);
    }
    public int getLevel(){

        return level;
    }

}