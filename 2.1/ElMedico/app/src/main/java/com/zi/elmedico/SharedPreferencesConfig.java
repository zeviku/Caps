package com.zi.elmedico;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zi on 3/18/2018.
 */

public class SharedPreferencesConfig {
        private SharedPreferences sharedPreferences;
        private Context context;
        public SharedPreferencesConfig(Context context){
            this.context=context;
            sharedPreferences=context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);

        }
            public void writeloginstatus(boolean status){
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean(context.getResources().getString(R.string.login_preference_status), status);
            editor.commit();
            }
            public boolean readLoginStatus(boolean status){
                status=sharedPreferences.getBoolean(context.getResources().getString(R.string.login_preference_status),false);
                return status;
            }
}
