package com.careeradviser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.careeradviser.DDBB.DatabaseConnectionAux;
import com.careeradviser.LearningRoute.AddCareerActivity;
import com.careeradviser.LearningRoute.LearningRouteAdapter;
import com.careeradviser.Model.LearningRoute;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addCareerBtn;
    private RecyclerView rv;
    private LearningRouteAdapter learningRouteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        FirebaseRecyclerOptions<LearningRoute> options =
                new FirebaseRecyclerOptions.Builder<LearningRoute>()
                        .setQuery(DatabaseConnectionAux.DBReference, LearningRoute.class)
                        .build();

        learningRouteAdapter = new LearningRouteAdapter(options);
        Log.e("Options", options.getSnapshots().toString());
        rv = findViewById(R.id.rv_learning_route);
        rv.setAdapter(learningRouteAdapter);

        addCareerBtn = this.findViewById(R.id.addCareerBtn);
        Intent i = new Intent(this, AddCareerActivity.class);
        //addCareerBtn.setOnClickListener(view -> startActivity(i));
        addCareerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> user = new HashMap<>();
                user.put("first", "Ada");
                user.put("last", "Lovelace");
                user.put("born", 1815);

// Add a new document with a generated ID
                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("asd", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("asd", "Error adding document", e);
                            }
                        });

                Map<String, Object> user2 = new HashMap<>();
                user.put("first", "Alan");
                user.put("middle", "Mathison");
                user.put("last", "Turing");
                user.put("born", 1912);

// Add a new document with a generated ID
                db.collection("users")
                        .add(user2)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("zs", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("zsd", "Error adding document", e);
                            }
                        });
            }
        });
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