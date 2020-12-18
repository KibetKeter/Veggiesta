package com.example.veggiesta;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Authentication extends AppCompatActivity implements View.OnClickListener {
    private TextView register;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

////        Initialize the Register Button to go to the sign up page

        register = findViewById(R.id.register);
        register.setOnClickListener(this);

//    Initialize the SIgn In button to go to the market
        signin = findViewById(R.id.signinbutton);
        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, Sign_up.class));
                break;
            case R.id.signinbutton:
                startActivity(new Intent(com.example.veggiesta.Authentication.this ,Market.class));
                break;
        }
    }
}

