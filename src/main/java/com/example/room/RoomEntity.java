package com.example.room;

import com.example.message.MessageEntity;
import com.example.user.CustomerEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RoomEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long id_user;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    private CustomerEntity user;

    @ManyToOne
    private MessageEntity message;

    public CustomerEntity getUser() {
        return user;
    }

    public void setUser(CustomerEntity borrower) {
        this.user = borrower;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity book) {
        this.message = book;
    }
    //private String borrower;
    //private String book;


    /*public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }*/

}
