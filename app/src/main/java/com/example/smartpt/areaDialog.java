package com.example.smartpt;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;
import java.util.Arrays;
import java.util.List;

public class areaDialog extends AppCompatDialogFragment {
    private TextView eFocusArea;
    //private CheckBox eFocusArea;
    private DialogListener listener;
    private int count=0;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        String[] focusAreas=new String[]{"core","chest","Back","Arm","shoulder","leg","Glue"};
        boolean[]checkedAreas=new boolean[]{false,false,false,false,false,false,false};
        final List<String> aList= Arrays.asList(focusAreas);

        builder.setTitle("Focus Areas")
                .setMultiChoiceItems(focusAreas, checkedAreas, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedAreas[which]=isChecked;


                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                StringBuilder area=new StringBuilder();
                for(int i=0;i<checkedAreas.length;i++){
                    boolean checked=checkedAreas[i];
                    if(checked){
                        area.append(aList.get(i)).append(" ").toString();
                        count ++;
                    }
                }
                if(count==0){
                    Toast.makeText(getActivity(), "please select one area at least!",
                            Toast.LENGTH_LONG).show();
                }else {
                    String hStr = area.toString();
                    listener.applyAreaText(hStr);
                }


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
        void applyAreaText(String area);
    }
}

