package com.careeradviser.ProductTour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.R;

public class ProductTourMainActivity extends AppCompatActivity {

    private Button goNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tour_main);

        goNextButton = findViewById(R.id.product_tour_1_btn);
        goNextButton.setOnClickListener(view -> startActivity(new Intent(ProductTourMainActivity.this, ProductTourSecondActivity.class)));
    }
}