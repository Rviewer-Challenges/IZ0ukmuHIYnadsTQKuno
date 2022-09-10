package com.careeradviser.LearningRoute;

import static com.careeradviser.Auxiliar.Generics.ID_LEARNING_ROUTE;
import static com.careeradviser.Auxiliar.Generics.clearET;
import static com.careeradviser.Auxiliar.Generics.isEmpty;
import static com.careeradviser.Auxiliar.Generics.parseString;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositiveDecisionActivity extends AppCompatActivity {

    Button bClear, bNext;
    EditText etPositiveDecision1, etPositiveDecision2, etPositiveDecision3;
    LearningRoute lRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive_decision);

        setData();
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Comprobar de mayor a menor e ir limpiando un et con cada uso del botón
                String positiveDecision2 = parseString(etPositiveDecision2);
                String positiveDecision3 = parseString(etPositiveDecision3);
                if (isEmpty(positiveDecision3)){
                    if (isEmpty(positiveDecision2)){
                        clearET(etPositiveDecision1);
                        Toast.makeText(PositiveDecisionActivity.this, Generics.CLEAR_MESSAGE, Toast.LENGTH_SHORT).show();
                    }else{
                        clearET(etPositiveDecision2);

                    }
                }else{
                    clearET(etPositiveDecision3);
                    Toast.makeText(PositiveDecisionActivity.this, Generics.CLEAR_MESSAGE2, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bNext.setOnClickListener(view -> {
            List<EditText> aDecisions = new ArrayList<>();
            aDecisions.add(etPositiveDecision1);
            aDecisions.add(etPositiveDecision2);
            aDecisions.add(etPositiveDecision3);

            for (EditText et: aDecisions) {
                if (!Generics.isEmpty(parseString(et))){
                    lRoute.addPositiveDecision(parseString(et));
                }
            }

            if (lRoute.getPositiveDecisions()<=0){
                Toast.makeText(PositiveDecisionActivity.this, "Asegurese de aportar valor a la comunidad", Toast.LENGTH_SHORT).show();
            }else{
                Intent iNegativeDecisions = new Intent(PositiveDecisionActivity.this, NegativeDecisionActivity.class);
                iNegativeDecisions.putExtra(ID_LEARNING_ROUTE, lRoute);
                startActivity(iNegativeDecisions);
            }
        });
    }

    private void setData() {
        bClear = findViewById(R.id.positive_clear_button);
        bNext = findViewById(R.id.positive_next_button);
        etPositiveDecision1 = findViewById(R.id.etPositiveTip1);
        etPositiveDecision2 = findViewById(R.id.etPositiveTip2);
        etPositiveDecision3 = findViewById(R.id.etPositiveTip3);

        lRoute = (LearningRoute) getIntent().getSerializableExtra(ID_LEARNING_ROUTE);
    }
}