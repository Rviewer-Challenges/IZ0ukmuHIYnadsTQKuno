package com.careeradviser.LearningRoute;

import static com.careeradviser.Auxiliar.Generics.ID_LEARNING_ROUTE;
import static com.careeradviser.Auxiliar.Generics.isEmpty;
import static com.careeradviser.Auxiliar.Generics.parseString;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.MainActivity;
import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCareerActivity extends AppCompatActivity {


    FloatingActionButton backBtn, addBtn;
    EditText jobTitle, studyYearsEt, workYearsEt;
    LearningRoute lRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_career);

        setData();
        addBtn.setOnClickListener(view -> {
            if (isEmpty(parseString(jobTitle))){
                Toast.makeText(getApplicationContext(), Generics.JOB_TITLE_EXCEPTION, Toast.LENGTH_SHORT).show();
            }else{
                String job = parseString(jobTitle);
                int studyingYears = 0;
                int workingYears = 0;
                if (!isEmpty(parseString(studyYearsEt)) || parseString(studyYearsEt).equals("0")){
                    studyingYears = Integer.parseInt(parseString(studyYearsEt));
                }
                if (!isEmpty(parseString(workYearsEt)) || parseString(workYearsEt).equals("0")){
                    workingYears = Integer.parseInt(parseString(workYearsEt));
                }
                if (workingYears<0 || studyingYears<0){
                    Toast.makeText(this, Generics.WRONG_INPUT_MESSAGE, Toast.LENGTH_SHORT).show();
                }else{
                    //Cambiar de pantalla
                    lRoute = createLearningRoute(job, studyingYears, workingYears);
                    Intent iLearningRouteActivity = new Intent(AddCareerActivity.this, LearningRouteActivity.class);
                    iLearningRouteActivity.putExtra(ID_LEARNING_ROUTE, lRoute);
                    startActivity(iLearningRouteActivity);
                }
            }
        });

        Intent iMainActivity = new Intent(this, MainActivity.class);
        backBtn.setOnClickListener(view -> startActivity(iMainActivity));
    }

    private LearningRoute createLearningRoute(String job, int studyingYears, int workingYears) {
        return new LearningRoute(job, studyingYears, workingYears);
    }

    private void setData() {
        backBtn = findViewById(R.id.add_back_btn);
        addBtn = findViewById(R.id.add_add_btn);
        jobTitle = findViewById(R.id.job_title);
        studyYearsEt = findViewById(R.id.add_study_years);
        workYearsEt = findViewById(R.id.add_work_years);
    }
}