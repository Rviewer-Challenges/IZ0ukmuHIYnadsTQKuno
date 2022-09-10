package com.careeradviser;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.careeradviser.DDBB.DatabaseConnectionAux;
import com.careeradviser.LearningRoute.AddCareerActivity;
import com.careeradviser.LearningRoute.LearningRouteAdapter;
import com.careeradviser.Model.LearningRoute;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addCareerBtn;
    private RecyclerView rv;
    private LearningRouteAdapter learningRouteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseRecyclerOptions<LearningRoute> options =
                new FirebaseRecyclerOptions.Builder<LearningRoute>()
                        .setQuery(DatabaseConnectionAux.DBReference, LearningRoute.class)
                        .build();

        learningRouteAdapter = new LearningRouteAdapter(options);

        rv = findViewById(R.id.rv_learning_route);
        rv.setAdapter(learningRouteAdapter);

        addCareerBtn = this.findViewById(R.id.addCareerBtn);
        Intent i = new Intent(this, AddCareerActivity.class);
        addCareerBtn.setOnClickListener(view -> startActivity(i));
    }

    @Override
    protected void onStart() {
        super.onStart();
        learningRouteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        learningRouteAdapter.startListening();
    }
}