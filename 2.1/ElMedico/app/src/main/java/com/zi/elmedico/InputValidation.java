package com.zi.elmedico;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by zi on 3/2/2018.
 */

public class InputValidation {


    private Context context;

    public InputValidation(Context context){
        this.context = context;
    }

    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()){
            textInputLayout.setError(message);
           hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextAge(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        int age=Integer.parseInt(value);
        if (value.isEmpty() || (age>100)){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
    public boolean isInputEditTextPassword(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || (value.length()<6)){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextMatches(TextInputEditText textInputEditText1,
                                          TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message ){
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText2);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private void hideKeyboardFrom(View view){
        InputMethodManager hk =(InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert hk != null;
        hk.hideSoftInputFromInputMethod(view.getWindowToken(),0);
    }
}

