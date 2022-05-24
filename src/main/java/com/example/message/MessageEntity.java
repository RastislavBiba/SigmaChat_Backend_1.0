package com.example.message;

import com.example.room.RoomEntity;
import com.example.user.CustomerEntity;

import javax.persistence.*;

@Entity
public class MessageEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    private CustomerEntity id_odosielatel;


    @ManyToOne(fetch = FetchType.LAZY)
    private RoomEntity prijemca;

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
        return id_odosielatel.getId();
    }

    public void setId_odosielatel(Long id_odosielatel) {
        this.id_odosielatel.setId(id_odosielatel);
    }

    public RoomEntity getPrijemca() {
        return prijemca;
    }

    public void setPrijemca(Long prijemca) {
        this.prijemca.setRoom_id(prijemca);
    }
}
