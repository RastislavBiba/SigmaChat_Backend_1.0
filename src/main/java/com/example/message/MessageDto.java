package com.example.message;

public class MessageDto {
    private String text;
    private Long id_odosielatel;
    private Long room_id;

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
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
}
