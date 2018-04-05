package com.zi.elmedico;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Findhospitals extends AppCompatActivity {
    private ArrayAdapter adapter;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findhospitals);
        list=findViewById(R.id.hospitalsList);
        TextInputEditText search= findViewById(R.id.textInputEditTextSearchHospitals);
        String[] myItems = {"St.John's Hospital","Apollos Hospital","Sacred Heart Hospital","Faith Hospital","Apo Hospital","Freder Hospital", "Baldev Raj Mittal Hospital","Hopkins Hospital","Bethel Hospital"};
        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myItems);
        list.setAdapter(adapter);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (Findhospitals.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        } );
    }

    public void backFromhospitals(View view) {
        startActivity(new Intent(this, UserActivity.class));
    }
}
