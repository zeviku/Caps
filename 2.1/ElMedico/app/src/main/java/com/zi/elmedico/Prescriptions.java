package com.zi.elmedico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Prescriptions extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptions);
        RadioButton rbPrescriptions = findViewById(R.id.rbPrescription);
        RadioButton rbReports = findViewById(R.id.rbReports);
        radioGroup=findViewById(R.id.rgPresRep);
        submit=findViewById(R.id.submitB);
    }

    public void submitPresRep(View view) {
        int selection=radioGroup.getCheckedRadioButtonId();
        switch (selection){
            case R.id.rbPrescription:
                startActivity(new Intent(Prescriptions.this,UserActivity.class));
                break;
            case R.id.rbReports:
                startActivity(new Intent(Prescriptions.this,Reports.class));
                break;
        }
}
}
