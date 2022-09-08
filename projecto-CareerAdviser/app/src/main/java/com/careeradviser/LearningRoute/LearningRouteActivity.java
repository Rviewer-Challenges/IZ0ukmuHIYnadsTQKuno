package com.careeradviser.LearningRoute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.careeradviser.R;

public class LearningRouteActivity extends AppCompatActivity {

    EditText etLearningRoute;
    Button clearButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_route);

        etLearningRoute = findViewById(R.id.learning_route);
        clearButton = findViewById(R.id.clear_button);
        nextButton = findViewById(R.id.next_button);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etLearningRoute.getText().clear();
                Toast.makeText(LearningRouteActivity.this, "Tómate tu tiempo, aclara tus ideas.", Toast.LENGTH_SHORT).show();
            }
        });

        Intent iPositive = new Intent(this, PositiveDecisionActivity.class);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String learningRoute = etLearningRoute.getText().toString();
                if(learningRoute.length() < 20){
                    Toast.makeText(LearningRouteActivity.this, "Por favor, detalle un poco más para la comunidad.", Toast.LENGTH_SHORT).show();
                }
                if(!learningRoute.trim().isEmpty()) {
                    iPositive.putExtra("learningRoute", learningRoute);
                    startActivity(iPositive);
                }
            }
        });

    }
}