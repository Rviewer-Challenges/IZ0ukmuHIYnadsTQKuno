package com.careeradviser.LearningRoute;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.MainActivity;
import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    TextView job, tip1, tip2, tip3;
    Button backButton, reverseButton;
    LearningRoute learningRoute;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        job = findViewById(R.id.view_job);
        tip1 = findViewById(R.id.tip_1);
        tip2 = findViewById(R.id.tip_2);
        tip3 = findViewById(R.id.tip_3);
        backButton = findViewById(R.id.item_back_button);
        reverseButton = findViewById(R.id.item_reverse_button);
        reverseButton.setText("Errores");
        reverseButton.setBackgroundColor(R.color.red);

        learningRoute = (LearningRoute) getIntent().getExtras().getSerializable(Generics.ID_LEARNING_ROUTE);
        populate(learningRoute.getPositiveDecision());
        if (learningRoute.getWorkingYears()==0 && learningRoute.getStudyingYears()==0){
            job.setText(learningRoute.getJob() + ", sin estudios ni trabajo");
        }else{
            if (learningRoute.getStudyingYears()>0 && learningRoute.getWorkingYears()>0){
                job.setText(learningRoute.getJob() + " tras estudiar durante " + learningRoute.getStudyingYears() + " años y trabajar por otros " + learningRoute.getWorkingYears());
            }else{
                if (learningRoute.getStudyingYears()==0){
                    job.setText(learningRoute.getJob() + " tras trabajar durante " + learningRoute.getWorkingYears() + " años");
                }else{
                    job.setText(learningRoute.getJob() + " tras estudiar durante " + learningRoute.getStudyingYears() +" años");
                }
            }
        }



        backButton.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));

        reverseButton.setOnClickListener(view -> {
            tip1.setText("");
            tip2.setText("");
            tip3.setText("");
            if (reverseButton.getText().toString().equals("Consejos")) {
                populate(learningRoute.getPositiveDecision());
                reverseButton.setText("Errores");
                reverseButton.setBackgroundColor(R.color.red);
            }else{
                reverseButton.setText("Consejos");
                reverseButton.setBackgroundColor(R.color.teal_700);
                populate(learningRoute.getNegativeDecision());
            }
        });
    }

    private void populate(ArrayList<String> positiveDecision) {
        for (String decision : positiveDecision) {
            if (tip1.getText().toString().isEmpty() || tip1.getText().toString().equals("")) {
                tip1.setText(decision);
            } else {
                if (tip2.getText().toString().isEmpty() || tip2.getText().toString().equals("")) {
                    tip2.setText(decision);
                } else {
                    tip3.setText(decision);
                }
            }
        }
    }
}