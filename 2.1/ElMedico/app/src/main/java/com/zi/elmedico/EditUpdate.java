package com.zi.elmedico;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditUpdate extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private EditText editable_item;
    DatabaseHelper mDatabaseHelper;
    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_update);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        editable_item = (EditText) findViewById(R.id.editable_item);
        mDatabaseHelper = new DatabaseHelper(this);
        TextView editProfile= findViewById(R.id.editProfile);


        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id",-1);
        selectedName = receivedIntent.getStringExtra("name");
        editable_item.setText(selectedName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editable_item.getText().toString();
                if(!item.equals("")){
                    mDatabaseHelper.updateName(item,selectedID,selectedName);
                    startActivity(new Intent(EditUpdate.this, ListDataActivity.class));
                }else{
                    toastMessage("You must enter a name");
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(EditUpdate.this,ListDataActivity.class));
            }
        }

        );

    }

      private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed(){
        finish();
    }
}