package com.example.smartpt;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatDialogFragment;

public class weightDialog extends AppCompatDialogFragment {
    private DialogListener listener;
    private NumberPicker eWeightPicker,units;
    private String[] weightUnits;
    private String pickedUnit = "Kg";


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.weight_dialog, null);

        eWeightPicker=view.findViewById(R.id.weightPicker);

        units=view.findViewById(R.id.wUnitPicker);
        units.setMinValue(0);
        units.setMaxValue(1);
        weightUnits=getResources().getStringArray(R.array.weightUnits);
        units.setDisplayedValues(weightUnits);

        eWeightPicker.setMinValue(39);
        eWeightPicker.setMaxValue(150);


        units.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                switch (picker.getValue()){
                    case 0:
                        eWeightPicker.setMinValue(39);
                        eWeightPicker.setMaxValue(150);
                        pickedUnit = "Kg";
                        break;

                    case 1:
                        eWeightPicker.setMinValue(85);
                        eWeightPicker.setMaxValue(330);
                        pickedUnit = "lbs";
                        break;

                }

            }
        });


        builder.setView(view)
                .setTitle("Weight")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                int pickedValue = eWeightPicker.getValue();
                StringBuilder sb=new StringBuilder();
                sb.append(Integer.toString(pickedValue)).append(pickedUnit);
                String wStr=sb.toString();
                listener.applyWeightText(wStr);


            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(DialogListener) context;
        } catch (Exception e){
            throw new ClassCastException(context.toString());
        }
    }

    public interface DialogListener{
        void applyWeightText(String weight);
    }
}

