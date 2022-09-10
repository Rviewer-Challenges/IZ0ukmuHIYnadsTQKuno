package com.careeradviser.LearningRoute;

import static com.careeradviser.Auxiliar.Generics.ID_LEARNING_ROUTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;

public class LearningRouteActivity extends AppCompatActivity {

    EditText etLearningRoute;
    Button clearButton, nextButton;
    LearningRoute lRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_route);

        lRoute = (LearningRoute) getIntent().getSerializableExtra(ID_LEARNING_ROUTE);

        etLearningRoute = findViewById(R.id.learning_route);
        clearButton = findViewById(R.id.clear_button);
        nextButton = findViewById(R.id.next_button);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etLearningRoute.getText().clear();
                Toast.makeText(LearningRouteActivity.this, "Tómate tu tiempo, aclara tus ideas", Toast.LENGTH_SHORT).show();
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String explanation = etLearningRoute.getText().toString();
                if(explanation.length() < 20){
                    Toast.makeText(LearningRouteActivity.this, "Por favor, detalle un poco más para la comunidad", Toast.LENGTH_SHORT).show();
                }
                else if(!explanation.trim().isEmpty()) {
                    lRoute.setExplanation(explanation);
                    Intent iPositive = new Intent(LearningRouteActivity.this, PositiveDecisionActivity.class);
                    iPositive.putExtra(ID_LEARNING_ROUTE, lRoute);
                    startActivity(iPositive);
                }
            }
        });

    }
}