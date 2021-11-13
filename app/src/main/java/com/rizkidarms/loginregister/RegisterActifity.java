package com.rizkidarms.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActifity extends AppCompatActivity {
    EditText username,password ;
    Button register;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.reg_username);
        password = findViewById(R.id.reg_password);
        register =  findViewById(R.id.btn_reg);

        preferences = getSharedPreferences("Userinfo",0);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                if (usernameValue.length() > 1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",usernameValue);
                    editor.putString("password",passwordValue);
                    editor.apply();

                    Toast.makeText(RegisterActifity.this, "User registered",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterActifity.this, "Enter value in the field",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}