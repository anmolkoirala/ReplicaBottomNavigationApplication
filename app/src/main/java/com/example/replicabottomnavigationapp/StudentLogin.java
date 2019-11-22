package com.example.replicabottomnavigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener{

    Button button;
    private EditText editTextUserName,editTextPassword;
    private String usrname, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        editTextUserName = findViewById(R.id.loginusername);
        editTextPassword = findViewById(R.id.loginpassword);
        button = findViewById(R.id.buttonlogin);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonlogin)
        {
            usrname   = editTextUserName.getText().toString();
            password  = editTextPassword.getText().toString();
            if(loginvalidate()) {

                if( usrname.equals("anmol") && password.equals("anmol")) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Either Username or Password is incorrect. Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    private boolean loginvalidate(){
        if(TextUtils.isEmpty(usrname))
        {
            editTextUserName.setError("Please Enter your Username");
            editTextUserName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(password))
        {
            editTextPassword.setError("Please Enter Password");
            editTextPassword.requestFocus();
            return false;
        }
        return  true;
    }
}
