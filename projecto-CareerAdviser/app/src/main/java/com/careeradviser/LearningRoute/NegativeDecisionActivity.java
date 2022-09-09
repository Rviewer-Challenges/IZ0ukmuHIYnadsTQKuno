package com.careeradviser.LearningRoute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.MainActivity;
import com.careeradviser.R;

import java.util.ArrayList;

public class NegativeDecisionActivity extends AppCompatActivity {

    EditText etNegativeDecision1, etNegativeDecision2, etNegativeDecision3;
    Button bClear, bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negative_decision);

        prepareData();
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NegativeDecisionActivity.this, Generics.CLEAR_MESSAGE, Toast.LENGTH_SHORT).show();
                //Comprobar de mayor a menor e ir limpiando in et con cada uso del botón
                String negativeDecision2 = parseString(etNegativeDecision2);
                String negativeDecision3 = parseString(etNegativeDecision3);
                if (isEmpty(negativeDecision3)){
                    if (isEmpty(negativeDecision2)){
                        clearET(etNegativeDecision1);
                    }else{
                        clearET(etNegativeDecision2);
                    }
                }else{
                    clearET(etNegativeDecision3);
                }
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!negativeDecisionKO()){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(NegativeDecisionActivity.this);
                    dialog.setTitle(Generics.SAVE_CONFIRMATION_MESSAGE)
                            .setPositiveButton(Generics.YES_CONFIRMATION_MESSAGE, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    saveRoute();
                                    Toast.makeText(NegativeDecisionActivity.this, Generics.YES_RESPONSE_MESSAGE, Toast.LENGTH_SHORT).show();
                                }
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
                            });
                }else{
                    Toast.makeText(NegativeDecisionActivity.this, Generics.NEXT_MESSAGE, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveRoute() {
        //Guardar el objeto dentro de la BBDD
        startActivity(new Intent(NegativeDecisionActivity.this, MainActivity.class));
    }

    private boolean negativeDecisionKO() {
        return isEmpty(parseString(etNegativeDecision1))
            && isEmpty(parseString(etNegativeDecision2))
            && isEmpty(parseString(etNegativeDecision3));
    }

    @NonNull
    private String parseString(EditText etNegativeDecision2) {
        return etNegativeDecision2.getText().toString();
    }

    private boolean isEmpty(String negativeDecision3) {
        return negativeDecision3.trim().isEmpty();
    }

    private void clearET(EditText etNegativeDecision3) {
        etNegativeDecision3.getText().clear();
    }

    private void prepareData() {
        etNegativeDecision1 = findViewById(R.id.etNegativeTip1);
        etNegativeDecision2 = findViewById(R.id.etNegativeTip2);
        etNegativeDecision3 = findViewById(R.id.etNegativeTip3);
        bClear = findViewById(R.id.negative_clear_button);
        bNext = findViewById(R.id.negative_next_button);
    }
}