package com.careeradviser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.Auxiliar.Generics;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCareerActivity extends AppCompatActivity {


    FloatingActionButton backBtn, addBtn;
    EditText jobTitle, studyYearsEt, workYearsEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_career);

        setData();
        addBtn.setOnClickListener(view -> {
            if (jobTitle.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), Generics.JOB_TITLE_EXCEPTION, Toast.LENGTH_SHORT).show();
            }else{
                String titulo = jobTitle.getText().toString();
                int studyYears = 0;
                int workYears = 0;
                if (!studyYearsEt.getText().toString().isEmpty() || studyYearsEt.getText().toString().equals("0")){
                    studyYears = Integer.parseInt(studyYearsEt.getText().toString());
                }
                if (!workYearsEt.getText().toString().isEmpty() || workYearsEt.getText().toString().equals("0")){
                    workYears = Integer.parseInt(workYearsEt.getText().toString());
                }
                if (workYears<0 || studyYears<0){
                    Toast.makeText(this, Generics.WRONG_INPUT_MESSAGE, Toast.LENGTH_SHORT).show();
                }else{
                    //Cambiar de pantalla
                    Toast.makeText(this, Generics.ADD_CAREER_MESSAGE, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent iMainActivity = new Intent(this, MainActivity.class);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iMainActivity);
            }
        });
    }

    private void setData() {
        backBtn = findViewById(R.id.add_back_btn);
        addBtn = findViewById(R.id.add_add_btn);
        jobTitle = findViewById(R.id.job_title);
        studyYearsEt = findViewById(R.id.add_study_years);
        workYearsEt = findViewById(R.id.add_work_years);
    }
}