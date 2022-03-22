package com.example.message;

public class MessageDto {
    private String text;
    private String odosielatel;
    private String prijimatel;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOdosielatel() {
        return odosielatel;
    }

    public void setOdosielatel(String odosielatel) {
        this.odosielatel = odosielatel;
    }

    public String getPrijimatel() {
        return prijimatel;
    }

    public void setPrijimatel(String prijimatel) {
        this.prijimatel = prijimatel;
    }
}
