package com.careeradviser.LearningRoute;

import static com.careeradviser.Auxiliar.Generics.clearET;
import static com.careeradviser.Auxiliar.Generics.isEmpty;
import static com.careeradviser.Auxiliar.Generics.parseString;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.careeradviser.Auxiliar.Generics;
import com.careeradviser.R;

public class PositiveDecisionActivity extends AppCompatActivity {

    Button bClear, bNext;
    EditText etPositiveDecision1, etPositiveDecision2, etPositiveDecision3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive_decision);

        setData();
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Comprobar de mayor a menor e ir limpiando un et con cada uso del botón
                String negativeDecision2 = parseString(etPositiveDecision2);
                String negativeDecision3 = parseString(etPositiveDecision3);
                if (isEmpty(negativeDecision3)){
                    if (isEmpty(negativeDecision2)){
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

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setData() {
        bClear = findViewById(R.id.positive_clear_button);
        bNext = findViewById(R.id.positive_next_button);
        etPositiveDecision1 = findViewById(R.id.etPositiveTip1);
        etPositiveDecision2 = findViewById(R.id.etPositiveTip2);
        etPositiveDecision3 = findViewById(R.id.etPositiveTip3);
    }
}