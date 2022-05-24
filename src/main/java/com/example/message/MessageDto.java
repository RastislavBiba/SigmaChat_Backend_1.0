package com.example.message;

import com.example.room.RoomEntity;
import com.example.user.CustomerEntity;

public class MessageDto {
    private Long id;
    private String text;
    private Long id_odosielatel;
    private Long prijemca;

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

    public Long getId_odosielatel() {
        return id_odosielatel;
    }

    public void setId_odosielatel(Long id_odosielatel) {
        this.id_odosielatel = id_odosielatel;
    }

    public Long getPrijemca() {
        return prijemca;
    }

    public void setPrijemca(Long prijemca) {
        this.prijemca = prijemca;
    }
}
