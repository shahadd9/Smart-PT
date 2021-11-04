package com.example.smartpt;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatDialogFragment;

public class reminderDialog extends AppCompatDialogFragment {
    private TimePicker eReminder;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.reminder_dialog, null);



        builder.setView(view)
                .setTitle("Reminder")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                eReminder=view.findViewById(R.id.eReminder);
                int rHour = eReminder.getHour();
                int rMin = eReminder.getMinute();

                StringBuilder sb=new StringBuilder();
                sb.append(Integer.toString(rHour)).append(":").append(Integer.toString(rMin));
                String dobStr=sb.toString();
                listener.applyReminderText(dobStr);


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
        void applyReminderText(String gender);
    }
}
