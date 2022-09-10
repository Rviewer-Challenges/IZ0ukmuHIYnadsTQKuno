package com.careeradviser.LearningRoute;

import static com.careeradviser.Auxiliar.Generics.ID_LEARNING_ROUTE;
import static com.careeradviser.Auxiliar.Generics.clearET;
import static com.careeradviser.Auxiliar.Generics.isEmpty;
import static com.careeradviser.Auxiliar.Generics.parseString;
import static com.careeradviser.DDBB.DatabaseConnectionAux.DBReference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.MainActivity;
import com.careeradviser.Model.LearningRoute;
import com.careeradviser.R;

import java.util.ArrayList;
import java.util.List;

public class NegativeDecisionActivity extends AppCompatActivity {

    EditText etNegativeDecision1, etNegativeDecision2, etNegativeDecision3;
    Button bClear, bNext;
    LearningRoute lRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negative_decision);

        setData();
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Comprobar de mayor a menor e ir limpiando un et con cada uso del botón
                String negativeDecision2 = parseString(etNegativeDecision2);
                String negativeDecision3 = parseString(etNegativeDecision3);
                if (isEmpty(negativeDecision3)){
                    if (isEmpty(negativeDecision2)){
                        clearET(etNegativeDecision1);
                        Toast.makeText(NegativeDecisionActivity.this, Generics.CLEAR_MESSAGE, Toast.LENGTH_SHORT).show();
                    }else{
                        clearET(etNegativeDecision2);

                    }
                }else{
                    clearET(etNegativeDecision3);
                    Toast.makeText(NegativeDecisionActivity.this, Generics.CLEAR_MESSAGE2, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDecisions();
                if (lRoute.getNegativeDecisions()>0){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(NegativeDecisionActivity.this);
                    dialog.setTitle(Generics.SAVE_CONFIRMATION_MESSAGE)
                            .setPositiveButton(Generics.YES_CONFIRMATION_MESSAGE, (dialogInterface, i) -> {
                                saveRoute();
                                Toast.makeText(NegativeDecisionActivity.this, Generics.YES_RESPONSE_MESSAGE, Toast.LENGTH_SHORT).show();
                            })
                            .setNegativeButton(Generics.NO_CONFIRMATION_MESSAGE, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(NegativeDecisionActivity.this, Generics.NO_RESPONSE_MESSAGE, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNeutralButton(Generics.ABORTION_MESSAGE, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(NegativeDecisionActivity.this, MainActivity.class));
                                    Toast.makeText(NegativeDecisionActivity.this, Generics.ABORTION_RESPONSE_MESSAGE, Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }else{
                    Toast.makeText(NegativeDecisionActivity.this, Generics.NEXT_MESSAGE, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkDecisions() {
        List<EditText> aDecisions = new ArrayList<>();
        aDecisions.add(etNegativeDecision1);
        aDecisions.add(etNegativeDecision2);
        aDecisions.add(etNegativeDecision3);

        for (EditText et: aDecisions) {
            if (!Generics.isEmpty(parseString(et))){
                lRoute.addNegativeDecision(parseString(et));
            }
        }
    }

    private void saveRoute() {
        //Guardar el objeto dentro de la BBDD
        Log.e("Learning route", lRoute.toString());
        DBReference.push().setValue(lRoute);
        startActivity(new Intent(NegativeDecisionActivity.this, MainActivity.class));
    }

    private boolean negativeDecisionKO() {
        return isEmpty(parseString(etNegativeDecision1))
            && isEmpty(parseString(etNegativeDecision2))
            && isEmpty(parseString(etNegativeDecision3));
    }

    private void setData() {
        etNegativeDecision1 = findViewById(R.id.etNegativeTip1);
        etNegativeDecision2 = findViewById(R.id.etNegativeTip2);
        etNegativeDecision3 = findViewById(R.id.etNegativeTip3);
        bClear = findViewById(R.id.negative_clear_button);
        bNext = findViewById(R.id.negative_next_button);

        lRoute = (LearningRoute) getIntent().getSerializableExtra(ID_LEARNING_ROUTE);
    }
}