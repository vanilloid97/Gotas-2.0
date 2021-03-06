package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpPage extends AppCompatActivity {

    //Variables
    Button callSignIn, signedUp;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        callSignIn = findViewById(R.id.btnRedirectLoginPage);

        callSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

        signedUp = findViewById(R.id.btnSignUp);

        signedUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(SignUpPage.this, OnBoardingPage.class);
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(SignUpPage.this, OnBoardingPage.class);
                    startActivity(intent);
                    finish();

                }
                else{

                    Intent intent = new Intent(SignUpPage.this, Dashboard.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }
}