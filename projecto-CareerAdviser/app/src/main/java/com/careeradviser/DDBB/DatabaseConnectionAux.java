package com.careeradviser.DDBB;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseConnectionAux {

    private static String learningRoute_route = "learning_route";
    public static FirebaseDatabase FBInstance = FirebaseDatabase.getInstance("https://careeradviser-54831-default-rtdb.europe-west1.firebasedatabase.app/");
    public static DatabaseReference DBReference = FBInstance.getReference(learningRoute_route);
}
