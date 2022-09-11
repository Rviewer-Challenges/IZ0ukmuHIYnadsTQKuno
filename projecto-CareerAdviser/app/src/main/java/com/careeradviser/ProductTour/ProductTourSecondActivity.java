package com.careeradviser.ProductTour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.R;

public class ProductTourSecondActivity extends AppCompatActivity {

    private Button goNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tour_second);

        goNextButton = findViewById(R.id.product_tour_2_btn);
        goNextButton.setOnClickListener(view -> startActivity(new Intent(ProductTourSecondActivity.this, ProductTourThirdActivity.class)));
    }
}