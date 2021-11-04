package com.example.smartpt;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.view.ActionBarPolicy;

import java.util.Calendar;

public class DB_Dialog extends AppCompatDialogFragment {
    private DatePicker eDB;
    private DialogListener listener;


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.db_dialog, null);



        builder.setView(view)
                .setTitle("birthday date")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                eDB=view.findViewById(R.id.eDB);
                int dobYear = eDB.getYear();
                int dobMonth = eDB.getMonth()+1;
                int dobDate = eDB.getDayOfMonth();
                int cur= Calendar.getInstance().get(Calendar.YEAR);

                if(cur-dobYear<=17){
                    Toast.makeText(getActivity(), "Age must be 18 at least!",
                            Toast.LENGTH_LONG).show();

                }else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Integer.toString(dobYear)).append("-").append(Integer.toString(dobMonth)).append("-")
                            .append(Integer.toString(dobDate));
                    String dobStr = sb.toString();
                    listener.applyDBText(dobStr);
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
        void applyDBText(String gender);
    }
}

