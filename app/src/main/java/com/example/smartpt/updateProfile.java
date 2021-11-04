package com.example.smartpt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.os.Bundle;

public class updateProfile extends AppCompatActivity implements nameDialog.DialogListener,
        genderDialog.DialogListener, DB_Dialog.DialogListener, heightDialog.DialogListener,
        areaDialog.DialogListener, weightDialog.DialogListener,
        reminderDialog.DialogListener, daysDialog.DialogListener{

    TextView eName, eGender, eDB, eHeight, eWeight, eFocusArea, eReminder, eTrainingDays;
    Button updateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eName=(TextView) findViewById(R.id.editName);
        eGender=(TextView) findViewById(R.id.editGender);
        eDB=(TextView) findViewById(R.id.editBD);
        eHeight=(TextView) findViewById(R.id.editHeight);
        eWeight=(TextView) findViewById(R.id.editWeight);
        eFocusArea=(TextView) findViewById(R.id.editFocusArea);
        eReminder = (TextView) findViewById(R.id.editReminder);
        eTrainingDays = (TextView) findViewById(R.id.editTrainingDays);
        updateProfile=(Button) findViewById(R.id.updateProfileB);

        eName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNameDialog();
            }


        });

        eGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGenderDialog();
            }


        });

        eDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDB_Dialog();
            }


        });

        eHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHeightDialog();
            }


        });

        eWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWeightDialog();
            }


        });

        eFocusArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAreaDialog();
            }


        });

        eReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReminderDialog();
            }


        });

        eTrainingDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDaysDialog();
            }


        });
    }

    public void openNameDialog(){
        nameDialog eName=new nameDialog();
        eName.show(getSupportFragmentManager(),"Name");
    }

    public void openGenderDialog(){
        genderDialog eGender=new genderDialog();
        eGender.show(getSupportFragmentManager(),"Gender");
    }

    public void openDB_Dialog(){
        DB_Dialog eDB=new DB_Dialog();
        eDB.show(getSupportFragmentManager(),"DB");
    }

    public void openHeightDialog(){
        heightDialog eHeight=new heightDialog();
        eHeight.show(getSupportFragmentManager(),"Height");
    }

    public void openWeightDialog(){
        weightDialog eWeight=new weightDialog();
        eWeight.show(getSupportFragmentManager(),"Weight");
    }

    public void openAreaDialog(){
        areaDialog eFocusArea=new areaDialog();
        eFocusArea.show(getSupportFragmentManager(),"Area");
    }

    public void openReminderDialog(){
        reminderDialog eReminder=new reminderDialog();
        eReminder.show(getSupportFragmentManager(),"Reminder");
    }

    public void openDaysDialog(){
        daysDialog eTrainingDays=new daysDialog();
        eTrainingDays.show(getSupportFragmentManager(),"Training Days");
    }

    public void applyNameText(String name){
        eName.setText(name);

    }

    public void applyGenderText(String gender){
        eGender.setText(gender);

    }

    public void applyDBText(String DB){
        eDB.setText(DB);

    }

    public void applyHeightText(String height){
        eHeight.setText(height);

    }


    public void applyWeightText(String weight){
        eWeight.setText(weight);

    }

    public void applyAreaText(String area){
        eFocusArea.setText(area);

    }

    public void applyReminderText(String reminder){
        eReminder.setText(reminder);

    }

    public void applyDaysText(String days){
        eTrainingDays.setText(days);

    }

    public void onClick(View view) {
    }
}