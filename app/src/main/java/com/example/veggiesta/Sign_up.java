package com.example.veggiesta;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Sign_up extends AppCompatActivity {

EditText textInputEditTextFullname,textInputEditTextUsername,textInputEditTextPassword,textInputEditTextEmail;
Button buttonSignup;
ProgressBar progressBar;


    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        textInputEditTextFullname = findViewById(R.id.fullname);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextEmail = findViewById(R.id.email);
        buttonSignup = findViewById(R.id.buttonsignup);
        progressBar = findViewById(R.id.progress);

        buttonSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String fullname;
                final String username;
                final String email;
                final String password;

                fullname = String.valueOf(textInputEditTextFullname.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                password = String.valueOf(textInputEditTextPassword.getText());


                if(!fullname.equals("") && !username.equals("") && !email.equals("") && !password.equals(""))
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
                                        String[] field = new String[4];
                                        field[0] = "fullname";
                                        field[1] = "username";
                                        field[2] = "email";
                                        field[3] = "password";

                                        //Creating array for data
                                        String[] data = new String[4];
                                        data[0] = fullname;
                                        data[1] = username;
                                        data[2] = email;
                                        data[3] = password;

                                        PutData putData = new PutData("http://192.168.2.2/LoginRegister/signup.php", "POST", field, data);
                                        if (putData.startPut())
                                            {
                                                if (putData.onComplete())
                                                        {
                                                            progressBar.setVisibility(View.GONE);
                                                            String result = putData.getResult();
                                                                if(result.equals("Sign Up Success"))
                                                                    {
                                                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                                        Intent intent = new Intent (getApplicationContext(),Authentication.class);
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


}