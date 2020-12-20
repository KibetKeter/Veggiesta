package com.example.veggiesta;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Authentication extends AppCompatActivity implements View.OnClickListener {
//    Initializing Login Widgets
    EditText textInputEditTextUsername,textInputEditTextPassword;
    Button buttonlogin;
    ProgressBar progressBar;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

////        Initialize the Register Button to go to the sign up page
        register = findViewById(R.id.register);
        register.setOnClickListener(this);

//    Initialize the variables
        textInputEditTextUsername = (EditText) findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonlogin = findViewById (R.id.buttonlogin);
        progressBar = findViewById (R.id.progress);

//        Listener for the Login Button
        buttonlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String username,password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

             if(!username.equals("")&&!password.equals(""))
                {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;

                            PutData putData = new PutData("http://192.168.2.2/LoginRegister/login.php", "POST", field, data);
                            if (putData.startPut())
                            {
                                if (putData.onComplete())
                                {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent (getApplicationContext(),Market.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                                //End ProgressBar (Set visibility to GONE)
                            }
                        }
                        //End Write and Read data with URL
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All Fields are required",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, Sign_up.class));
                break;
        }
    }
}

