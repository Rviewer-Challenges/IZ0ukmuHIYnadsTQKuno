package com.careeradviser.ProductTour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.R;

public class ProductTourThirdActivity extends AppCompatActivity {

    private Button goNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tour_third);

        goNextButton = findViewById(R.id.product_tour_3_btn);
        goNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductTourThirdActivity.this, ProductTourFourthActivity.class));
            }
        });
    }
}