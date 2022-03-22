package com.example.message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String prijimatel;
    private String odosielatel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrijimatel() {
        return prijimatel;
    }

    public void setPrijimatel(String prijimatel) {
        this.prijimatel = prijimatel;
    }

    public String getOdosielatel() {
        return odosielatel;
    }

    public void setOdosielatel(String odosielatel) {
        this.odosielatel = odosielatel;
    }
}
