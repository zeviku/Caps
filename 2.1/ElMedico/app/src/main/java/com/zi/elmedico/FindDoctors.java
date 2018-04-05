package com.zi.elmedico;


import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import android.content.Intent;
import android.view.View;

public class FindDoctors extends AppCompatActivity {

    private DoctorListAdapter adapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctors);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView =  findViewById(R.id.doctorsList);
        TextInputEditText search=findViewById(R.id.textInputEditTextSearchDoctors);
        Doctor john = new Doctor("Dr.John","BONES","PHAGWARA");
        Doctor steve = new Doctor("Dr.Steve","PEDIA","JALANDHAR");
        Doctor stacy = new Doctor("Dr.Stacy","MEDICINE","PHAGWARA");
        Doctor ashley = new Doctor("Dr.Ashley","ORTHO","PHAGWARA");
        Doctor matt = new Doctor("Dr.Matt","SURGERY","JALANDHAR");
        //Add the Person objects to an ArrayList
        ArrayList<Doctor> doctorList = new ArrayList<>();
        doctorList.add(john);
        doctorList.add(steve);
        doctorList.add(stacy);
        doctorList.add(ashley);
        doctorList.add(matt);
        adapter = new DoctorListAdapter(this, R.layout.doctor_view_layout, doctorList);
        mListView.setAdapter(adapter);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            (FindDoctors.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        } );
    }

    public void backFromDocs(View view) {
        startActivity(new Intent(this,UserActivity.class));
    }
}