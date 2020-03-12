package com.example.e_tournament;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class LoginActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.button_login) {

            Username = (EditText) findViewById(R.id.edittext_username);
            String str = Username.getText().toString();
            Password = (EditText) findViewById(R.id.edittext_password);
            String pass = Password.getText().toString();
            String password = helper.searchPass(str);


            if (pass.equals(password)) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);

            } else {
                Toast IncorrectLogin = Toast.makeText(LoginActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT);
                IncorrectLogin.show();

            }

        }
        if (v.getId() == R.id.textview_register)
        {
            Intent j = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(j);
        }
    }
}
