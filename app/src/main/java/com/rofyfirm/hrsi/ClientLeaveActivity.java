package com.rofyfirm.hrsi;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ClientLeaveActivity extends AppCompatActivity {

    EditText editTextFrom, editTextTo;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_leave);

        editTextFrom = findViewById(R.id.txtDateFrom);
        editTextTo = findViewById(R.id.txtDateTo);

        editTextFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickCalendar();
            }
        });

        editTextTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickCalendar();
            }
        });
    }

    private void pickCalendar(){
        final Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(ClientLeaveActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                String string = dayOfMonth+"/"+month+"/"+year;
                if (editTextFrom.hasFocus()){
                    editTextFrom.setText(string);
                }
                else editTextTo.setText(string);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        finish();
    }
}
