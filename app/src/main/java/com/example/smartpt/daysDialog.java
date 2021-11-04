package com.example.smartpt;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import java.util.Arrays;
import java.util.List;

public class daysDialog extends AppCompatDialogFragment {
    private DialogListener listener;
    private int count=0;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        String[] tDays=new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        boolean[]checkedDays=new boolean[]{false,false,false,false,false,false,false};
        final List<String> dList= Arrays.asList(tDays);

        builder.setTitle("Training days")
                .setMultiChoiceItems(tDays, checkedDays, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedDays[which]=isChecked;

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                StringBuilder days=new StringBuilder();
                for(int i=0;i<checkedDays.length;i++){
                    boolean checked=checkedDays[i];
                    if(checked){
                        days.append(dList.get(i)).append(" ").toString();
                        count ++;
                    }
                }
                if(count<=1 || count>5){
                    Toast.makeText(getActivity(), "you can select 2 to 5 days only!",
                            Toast.LENGTH_LONG).show();
                }else {
                    String dStr = days.toString();
                    listener.applyDaysText(dStr);
                }


            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener=(DialogListener) context;
        } catch (Exception e){
            throw new ClassCastException(context.toString());
        }
    }

    public interface DialogListener{
        void applyDaysText(String days);
    }
}

