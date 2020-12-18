package com.example.veggiesta;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;



            public class MainActivity extends AppCompatActivity {
//                Variable
                Button start_button;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    setContentView(R.layout.activity_main);
//    Initialize button
                    start_button = findViewById(R.id.start_button);

                    start_button.setOnClickListener(new View.OnClickListener()
                    {

                        @Override
                        public void onClick(View view) {
                            openLoginActivity();
                        }

                        private void openLoginActivity() {
                            Intent intent = new Intent(com.example.veggiesta.MainActivity.this, Authentication.class);
                            startActivity(intent);
                        }
                    });
    }
}