package com.example.smartpt;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Color;
        import android.nfc.Tag;
        import android.os.Bundle;
        import android.util.Log;
        import android.util.TypedValue;
        import android.view.Gravity;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.FrameLayout;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.firestore.DocumentReference;
        import com.google.firebase.firestore.DocumentSnapshot;
        import com.google.firebase.firestore.FirebaseFirestore;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;



public class PlanView extends AppCompatActivity {
    private Button buttonSat;
    private Button buttonSun;
    private Button buttonMon;
    private Button buttonTue;
    private Button buttonWed;
    private Button buttonFri;
    private Button buttonThu;
    private Button buttonALeart;

    private TextView TextviewEx1;

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference ex1=db.collection("Exercise").document("9kfu4LzQIe8ZF9PxHTur");

    private static final String TAG = "PlanView";

    private static final String KEY_Name = "name";
    private static final String KEY_TARGET = "targetedMuscle";


    //DatabaseRefernce databaseRefernce;
    //private FirebaseFirestore db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_view);
        LinearLayout exFrame = (LinearLayout) findViewById(R.id.ExFrame);

        buttonALeart = (Button) findViewById(R.id.alertButton);
        FrameLayout alertFrame = (FrameLayout) findViewById(R.id.alertFrame);

        //ex
        TextviewEx1 = findViewById(R.id.textViewex1);


        buttonALeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.alertText);
                text.setVisibility(View.GONE);
                alertFrame.setVisibility(View.GONE);
                v.setVisibility(View.GONE);




            }
        });


        buttonMon = (Button) findViewById(R.id.buttonMon);
        buttonMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.background));
                buttonSun.setBackground(getDrawable(R.drawable.background));
                buttonMon.setBackground(getDrawable(R.drawable.button_color));
                buttonMon.setTextColor(getResources().getColor(R.color.white));

                buttonTue.setBackground(getDrawable(R.drawable.background));
                buttonWed.setBackground(getDrawable(R.drawable.background));
                buttonThu.setBackground(getDrawable(R.drawable.background));
                buttonFri.setBackground(getDrawable(R.drawable.background));

                buttonSat.setTextColor(getResources().getColor(R.color.black));
                buttonSun.setTextColor(getResources().getColor(R.color.black));
                buttonTue.setTextColor(getResources().getColor(R.color.black));
                buttonWed.setTextColor(getResources().getColor(R.color.black));
                buttonThu.setTextColor(getResources().getColor(R.color.black));
                buttonFri.setTextColor(getResources().getColor(R.color.black));


                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);
                    loadEx(v);

                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);


                }

            }
        });


        buttonSat = (Button) findViewById(R.id.buttonSat);
        buttonSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.button_color));
                buttonSat.setTextColor(getResources().getColor(R.color.white));

                buttonSun.setBackground(getDrawable(R.drawable.background));
                buttonMon.setBackground(getDrawable(R.drawable.background));
                buttonTue.setBackground(getDrawable(R.drawable.background));
                buttonWed.setBackground(getDrawable(R.drawable.background));
                buttonThu.setBackground(getDrawable(R.drawable.background));
                buttonFri.setBackground(getDrawable(R.drawable.background));


                buttonMon.setTextColor(getResources().getColor(R.color.black));
                buttonSun.setTextColor(getResources().getColor(R.color.black));
                buttonTue.setTextColor(getResources().getColor(R.color.black));
                buttonWed.setTextColor(getResources().getColor(R.color.black));
                buttonThu.setTextColor(getResources().getColor(R.color.black));
                buttonFri.setTextColor(getResources().getColor(R.color.black));

                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);

                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }
        });

        buttonSun = (Button) findViewById(R.id.buttonSun);
        buttonSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.background));
                buttonSun.setBackground(getDrawable(R.drawable.button_color));
                buttonSun.setTextColor(getResources().getColor(R.color.white));

                buttonMon.setBackground(getDrawable(R.drawable.background));
                buttonTue.setBackground(getDrawable(R.drawable.background));
                buttonWed.setBackground(getDrawable(R.drawable.background));
                buttonThu.setBackground(getDrawable(R.drawable.background));
                buttonFri.setBackground(getDrawable(R.drawable.background));

                buttonMon.setTextColor(getResources().getColor(R.color.black));
                buttonSat.setTextColor(getResources().getColor(R.color.black));
                buttonTue.setTextColor(getResources().getColor(R.color.black));
                buttonWed.setTextColor(getResources().getColor(R.color.black));
                buttonThu.setTextColor(getResources().getColor(R.color.black));
                buttonFri.setTextColor(getResources().getColor(R.color.black));

                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);

                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }
        });
        buttonTue = (Button) findViewById(R.id.buttonTue);
        buttonTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.background));
                buttonSun.setBackground(getDrawable(R.drawable.background));
                buttonMon.setBackground(getDrawable(R.drawable.background));
                buttonTue.setBackground(getDrawable(R.drawable.button_color));
                buttonTue.setTextColor(getResources().getColor(R.color.white));

                buttonWed.setBackground(getDrawable(R.drawable.background));
                buttonThu.setBackground(getDrawable(R.drawable.background));
                buttonFri.setBackground(getDrawable(R.drawable.background));

                buttonMon.setTextColor(getResources().getColor(R.color.black));
                buttonSat.setTextColor(getResources().getColor(R.color.black));
                buttonSun.setTextColor(getResources().getColor(R.color.black));
                buttonWed.setTextColor(getResources().getColor(R.color.black));
                buttonThu.setTextColor(getResources().getColor(R.color.black));
                buttonFri.setTextColor(getResources().getColor(R.color.black));

                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);

                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }
        });


        buttonWed = (Button) findViewById(R.id.buttonWed);
        buttonWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.background));
                buttonSun.setBackground(getDrawable(R.drawable.background));
                buttonMon.setBackground(getDrawable(R.drawable.background));
                buttonTue.setBackground(getDrawable(R.drawable.background));
                buttonWed.setBackground(getDrawable(R.drawable.button_color));
                buttonWed.setTextColor(getResources().getColor(R.color.white));

                buttonThu.setBackground(getDrawable(R.drawable.background));
                buttonFri.setBackground(getDrawable(R.drawable.background));


                buttonMon.setTextColor(getResources().getColor(R.color.black));
                buttonSat.setTextColor(getResources().getColor(R.color.black));
                buttonSun.setTextColor(getResources().getColor(R.color.black));
                buttonTue.setTextColor(getResources().getColor(R.color.black));
                buttonThu.setTextColor(getResources().getColor(R.color.black));
                buttonFri.setTextColor(getResources().getColor(R.color.black));

                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);

                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }
        });

        buttonThu = (Button) findViewById(R.id.buttonThu);
        buttonThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.background));
                buttonSun.setBackground(getDrawable(R.drawable.background));
                buttonMon.setBackground(getDrawable(R.drawable.background));
                buttonTue.setBackground(getDrawable(R.drawable.background));
                buttonWed.setBackground(getDrawable(R.drawable.background));
                buttonThu.setBackground(getDrawable(R.drawable.button_color));
                buttonThu.setTextColor(getResources().getColor(R.color.white));

                buttonFri.setBackground(getDrawable(R.drawable.background));

                buttonMon.setTextColor(getResources().getColor(R.color.black));
                buttonSat.setTextColor(getResources().getColor(R.color.black));
                buttonSun.setTextColor(getResources().getColor(R.color.black));
                buttonTue.setTextColor(getResources().getColor(R.color.black));
                buttonWed.setTextColor(getResources().getColor(R.color.black));
                buttonFri.setTextColor(getResources().getColor(R.color.black));

                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);
                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }
        });

        buttonFri = (Button) findViewById(R.id.buttonFri);
        buttonFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mon = (TextView) findViewById(R.id.ExercisesView);
                buttonSat.setBackground(getDrawable(R.drawable.background));
                buttonSun.setBackground(getDrawable(R.drawable.background));
                buttonMon.setBackground(getDrawable(R.drawable.background));
                buttonTue.setBackground(getDrawable(R.drawable.background));
                buttonWed.setBackground(getDrawable(R.drawable.background));
                buttonThu.setBackground(getDrawable(R.drawable.background));
                buttonFri.setBackground(getDrawable(R.drawable.button_color));
                buttonFri.setTextColor(getResources().getColor(R.color.white));

                buttonMon.setTextColor(getResources().getColor(R.color.black));
                buttonSat.setTextColor(getResources().getColor(R.color.black));
                buttonSun.setTextColor(getResources().getColor(R.color.black));
                buttonTue.setTextColor(getResources().getColor(R.color.black));
                buttonWed.setTextColor(getResources().getColor(R.color.black));
                buttonThu.setTextColor(getResources().getColor(R.color.black));


                if (mon.getText().equals("")) {
                    mon.setText("My Exercises for today");
                    exFrame.setVisibility(View.VISIBLE);
                } else {
                    mon.setText("There is no exercises for today");
                    exFrame.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

//               Data Exercise

        public void loadEx(View v){
            ex1.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){
                                String name =documentSnapshot.getString(KEY_Name);
                                String target=documentSnapshot.getString(KEY_TARGET);

                                TextviewEx1.setText(name+"\n"+"Targe Muscle: "+target);

                            }else {
                                Toast.makeText(PlanView.this,"Document not exist",Toast.LENGTH_SHORT).show();
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(PlanView.this, "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());

                        }
                    });
        }










}