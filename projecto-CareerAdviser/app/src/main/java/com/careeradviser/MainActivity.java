package com.careeradviser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.LearningRoute.AddCareerActivity;
import com.careeradviser.LearningRoute.LearningRouteAdapter;
import com.careeradviser.Model.LearningRoute;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addCareerBtn;
    private RecyclerView rv;
    private LearningRouteAdapter learningRouteAdapter;
    private ArrayList<LearningRoute> as = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        if (as.size()<=0){
            LearningRoute l = new LearningRoute("Junior Developer", 2, 1);

            l.setExplanation("Me encargo de crear y mantener diferentes aplicaciones web y movil desde hace aproximadamente 1 año");
            l.addNegativeDecision("No dedicar el tiempo suficiente a las tecnologías más complejas");
            l.addPositiveDecision("Ser proactivo y preguntar siempre que haya dudas");
            as.add(l);
        }
        if (LearningRoute.i != 0){
            LearningRoute nueva = (LearningRoute) getIntent().getExtras().getSerializable(Generics.ID_LEARNING_ROUTE);
            if (!(nueva == null)){
                as.add(nueva);
            }
        }


        learningRouteAdapter = new LearningRouteAdapter(as);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv = (RecyclerView) findViewById(R.id.rv_learning_route);
        rv.setLayoutManager(manager);
        rv.setAdapter(learningRouteAdapter);

        addCareerBtn = this.findViewById(R.id.addCareerBtn);
        Intent i = new Intent(this, AddCareerActivity.class);
        addCareerBtn.setOnClickListener(view -> startActivity(i));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}