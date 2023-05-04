package com.example.recycleapp;

public class QuestionModel {
    String question;
    String oA;
    String oB;
    String rightanswer;
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionModel(String question, String oA, String oB, String rightanswer, String Description) {
        this.question = question;
        this.oA = oA;
        this.oB = oB;
        this.rightanswer = rightanswer;
        this.description = Description;
    }

    public QuestionModel() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(String rightanswer) {
        this.rightanswer = rightanswer;
    }
}
