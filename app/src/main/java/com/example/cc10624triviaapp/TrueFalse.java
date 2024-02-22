package com.example.cc10624triviaapp;

public class TrueFalse {


    private int idxQuestion;
    private boolean keyAnswer;

    private  boolean isAnswered;




    public TrueFalse(int idxQuestion, boolean keyAnswer, boolean isAnswered){
        this.idxQuestion = idxQuestion;
        this.keyAnswer = keyAnswer;

        this.isAnswered = isAnswered;






    }




    public int getIdxQuestion() {
        return idxQuestion;
    }

    public void setIdxQuestion(int idxQuestion) {
        this.idxQuestion = idxQuestion;

    }

    public boolean isKeyAnswer() {
        return keyAnswer;
    }

    public void setKeyAnswer(boolean keyAnswer) {
        this.keyAnswer = keyAnswer;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
