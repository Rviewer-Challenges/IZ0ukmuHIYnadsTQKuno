package com.careeradviser.ProductTour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.MainActivity;
import com.careeradviser.R;

public class ProductTourFourthActivity extends AppCompatActivity {

    private Button goNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tour_fourth);

        goNextButton = findViewById(R.id.product_tour_4_btn);
        goNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductTourFourthActivity.this, MainActivity.class));
            }
        });
    }
}