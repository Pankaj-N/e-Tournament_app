package com.example.e_tournament;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onLoginClick(View view){
        if(view.getId()==R.id.button_login){
            Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(login);
        }
        else{
            Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(login);
        }
    }

    public void onSignUpClick(View view) {

        if(view.getId()==R.id.button_register) {
            EditText RUsername = (EditText) findViewById(R.id.edittext_username);
            EditText RSurname = (EditText) findViewById(R.id.edittext_Surname);
            EditText RFullname = (EditText) findViewById(R.id.edittext_First_Name);
            EditText REmail = (EditText) findViewById(R.id.edittext_Email);
            EditText RPassword = (EditText) findViewById(R.id.edittext_password);
            EditText RConfirmPassword = (EditText) findViewById(R.id.edittext_cnf_password);
            EditText RDOB = (EditText) findViewById(R.id.edittext_DOB);

            String RUsernameStr = RUsername.getText().toString();
            String RFullnameStr = RFullname.getText().toString();
            String RSurnameStr = RSurname.getText().toString();
            String REmailStr = REmail.getText().toString();
            String ConPassStr = RConfirmPassword.getText().toString();
            String RegPassStr = RPassword.getText().toString();
            String RDOBStr = RDOB.getText().toString();

            if(!RegPassStr.equals(ConPassStr))
            {
                Toast pass = Toast.makeText(RegisterActivity.this, "Passwords Does Not Match!", Toast.LENGTH_SHORT);
                pass.show();
            }else{

                Contact c = new Contact();
                c.setfname(RFullnameStr);
                c.setuname(RUsernameStr);
                c.setemail(REmailStr);
                c.setpass(RegPassStr);
                c.setDOB(RDOBStr);
                c.setSname(RSurnameStr);

                helper.insertContact(c);

                Toast pass = Toast.makeText(RegisterActivity.this, "You Have Registered!", Toast.LENGTH_SHORT);
                pass.show();

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);


            }
        }


    }


}
