package com.example.interactivestoryapp.Model;

public class Page {
    private int imgaeId;
    private int textId;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;

    public Page(int imgaeId, int textId) {
        this.imgaeId = imgaeId;
        this.textId = textId;
        isFinalPage = true;
    }

    public Page(int imgaeId, int textId, Choice choice1, Choice choice2) {
        this.imgaeId = imgaeId;
        this.textId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }

    public int getImgaeId() {
        return imgaeId;
    }

    public void setImgaeId(int imgaeId) {
        this.imgaeId = imgaeId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
