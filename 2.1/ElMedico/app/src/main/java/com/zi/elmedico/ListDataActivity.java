package com.zi.elmedico;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by zi on 2/28/2018.
 */

public class ListDataActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final String TAG = "USER DETAILSy";
    DatabaseHelper mDatabaseHelper;
    private  User user;
    private ListView profileListView;
    private ListView list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_data);
        profileListView = findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);
        list = findViewById(R.id.listView1);
        populateListView();

        String[] myItems = {"Id","Name", "Email", "Age"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myItems);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    private void populateListView() {
        Log.d(TAG, "ELMEDICO: USER DETAILS .");
        //Cursor data = mDatabaseHelper.getItemI(email);
        //Intent fromLogin=getIntent();
        //String email=fromLogin.getStringExtra("U");
        //Cursor data = mDatabaseHelper.getItemI(email);
        int id=1;
        Cursor data =mDatabaseHelper.getData(id);
        ArrayList<String> listData = new ArrayList<String>();
        while(data.moveToNext()){
            listData.add(data.getString(0));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
            listData.add(data.getString(1));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);
        profileListView.setAdapter(adapter);


    profileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name);
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(ListDataActivity.this, EditUpdate.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }
         }
        });
        }

      private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this, FindDoctors.class));
        TextView tv= (TextView)view;
        Toast.makeText(this,"You clicked on "+ tv.getText(),Toast.LENGTH_SHORT).show();
    }

    public void Back(View view) {
          startActivity(new Intent(this, UserActivity.class));
    }
}
