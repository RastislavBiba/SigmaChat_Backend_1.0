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
    private Long id_odosielatel;
    private Long room_id;


    public Long getRoom_id() {
        return room_id;
    }

    public Long getId_odosielatel() {
        return id_odosielatel;
    }

    public void setId_odosielatel(Long id_odosielatel) {
        this.id_odosielatel = id_odosielatel;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

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

}
