package com.rizkidarms.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password ;
    Button login,register;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.inp_username);
        password = findViewById(R.id.inp_password);
        login    =  findViewById(R.id.btn_login);
        register =  findViewById(R.id.btn_register);

        preferences = getSharedPreferences("Userinfo",0);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                String registeredUsername = preferences.getString("username","");
                String registeredPassword = preferences.getString("password","");

                if (usernameValue.equals(registeredUsername) && passwordValue.equals(registeredPassword) ) {
                    Intent intent = new Intent(MainActivity.this, HomeActifity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Please enter valid username or password!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActifity.class);
                startActivity(intent);
            }
        });
    }
}