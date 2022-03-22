package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BorrowedBookEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CustomerEntity borrower;

    @ManyToOne
    private BookEntity book;

    public CustomerEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(CustomerEntity borrower) {
        this.borrower = borrower;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
    //private String borrower;
    //private String book;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
