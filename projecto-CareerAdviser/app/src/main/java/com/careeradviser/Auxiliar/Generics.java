package com.careeradviser.Auxiliar;

import android.widget.EditText;

import androidx.annotation.NonNull;

public class Generics {
    //CONSTANTES

    //AddCareerActivity
    public static final String ID_LEARNING_ROUTE = "LearningRoute";

    //NegativeDecisionActivity
    public static final String CLEAR_MESSAGE = "Podemos aportar más valor del que creemos a la comunidad";
    public static final String SAVE_CONFIRMATION_MESSAGE = "¿Desea guardar Ruta de Aprendizaje?";
    public static final String YES_CONFIRMATION_MESSAGE = "CONFIRMAR";
    public static final String NO_CONFIRMATION_MESSAGE = "CANCELAR";
    public static final String ABORTION_MESSAGE = "ABORTAR Y CANCELAR";
    public static final String NO_RESPONSE_MESSAGE = "Su progreso no ha sufrido cambios";
    public static final String YES_RESPONSE_MESSAGE = "Gracias por contribuir a una comunidad próspera, <3";
    public static final String ABORTION_RESPONSE_MESSAGE = "El proceso ha sido abortado con éxito";
    public static final String NEXT_MESSAGE = "Aporte al menos una decisión errónea para orientar a la comunidad";
    public static final String CLEAR_MESSAGE2 = "Pulse nuevamente para eliminar un registro anterior";

    //AddCareerActivity
    public static final String WRONG_INPUT_MESSAGE = "Introduzca valores válidos para los años de experiencia";
    public static final String ADD_CAREER_MESSAGE = "Nos llevará a la pantalla para dejar las decisiones";
    public static final String JOB_TITLE_EXCEPTION = "El nombre del empleo no puede ser nulo";

    @NonNull
    public static String parseString(EditText et) {
        return et.getText().toString();
    }

    public static boolean isEmpty(String s) {
        return s.trim().isEmpty();
    }

    public static void clearET(EditText et) {
        et.getText().clear();
    }
}
