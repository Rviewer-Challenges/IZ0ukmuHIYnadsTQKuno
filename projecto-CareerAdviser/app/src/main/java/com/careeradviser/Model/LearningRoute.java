package com.careeradviser.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class LearningRoute implements Serializable {
    private String job, explanation;
    private int studyingYears, workingYears;
    private ArrayList<String> positiveDecision;
    private ArrayList<String> negativeDecision;

    public LearningRoute(String job, int studyingYears, int workingYears){
        this.job = job;
        this.studyingYears = studyingYears;
        this.workingYears = workingYears;
        this.positiveDecision = new ArrayList<>();
        this.negativeDecision = new ArrayList<>();
    }

    public String getJob() {
        return job;
    }

    public int getStudyingYears() {
        return studyingYears;
    }

    public int getWorkingYears() {
        return workingYears;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getPositiveDecisions(){
        return positiveDecision.size();
    }

    public int getNegativeDecisions(){
        return negativeDecision.size();
    }

    public void addPositiveDecision(String positiveDecision){
        this.positiveDecision.add(positiveDecision);
    }

    public void addNegativeDecision(String negativeDecision){
        this.negativeDecision.add(negativeDecision);
    }

    @Override
    public String toString() {
        return "LearningRoute{" +
                "job='" + job + '\'' +
                ", explanation='" + explanation + '\'' +
                ", studyingYears=" + studyingYears +
                ", workingYears=" + workingYears +
                ", positiveDecision=" + positiveDecision +
                ", negativeDecision=" + negativeDecision +
                '}';
    }
}
