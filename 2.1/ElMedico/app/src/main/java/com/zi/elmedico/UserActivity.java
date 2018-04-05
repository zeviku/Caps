package com.zi.elmedico;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;

/**
 * Created by zi on 2/27/2018.
 */


public class UserActivity extends AppCompatActivity {

    private SharedPreferencesConfig preferencesConfig;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        preferencesConfig=new SharedPreferencesConfig(getApplicationContext());

    }
    @Override
    public void onBackPressed(){
        finish();
    }

    public void logout(View view) {

        preferencesConfig.writeloginstatus(false);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void searchHospitals(View view) {
        Intent sh = new Intent(this, Findhospitals.class);
        startActivity(sh);
    }

    public void searchDoctor(View view) {
        Intent sd=new Intent(this,FindDoctors.class);
        startActivity(sd);
    }

    public void bookappoint(View view) {
        Intent ba= new Intent(this,Bookappointment.class);
        startActivity(ba);
    }

    public void viewPrescription(View view) {
        Intent p =new Intent(this, Prescriptions.class);
        startActivity(p);
    }

    public void profile(View view) {
        startActivity(new Intent(this,ListDataActivity.class));


    }

}



