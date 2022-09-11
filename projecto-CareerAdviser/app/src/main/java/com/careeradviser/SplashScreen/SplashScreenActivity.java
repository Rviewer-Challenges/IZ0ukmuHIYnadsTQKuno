package com.careeradviser.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.ProductTour.ProductTourMainActivity;
import com.careeradviser.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> startActivity(new Intent(SplashScreenActivity.this, ProductTourMainActivity.class)), 3000);
    }
}