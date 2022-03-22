package com.example.demo;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowedService {
    private List<Book> books;
    private List<BorrowedBook> borrowings;
    private List<User> users;
    private BookService bookService;
    //borrowings


    private List<BorrowedBook> initBorrowed(){
        List<BorrowedBook> borrowings = new ArrayList<>();
        BorrowedBook borrowed1 = new BorrowedBook();

        borrowed1.setBook("skuska");
        borrowed1.setBorrower("pokus"); //pokus
        borrowed1.setId(1);

        borrowings.add(borrowed1);

        return borrowings;
    }


    public Integer createBorrowing(@RequestBody String borrower, String book){
        BorrowedBook borrowed = new BorrowedBook();
        borrowed.setBorrower(borrower);
        borrowed.setBook(book);


        this.borrowings.add(borrowed);
        return this.borrowings.size()-1;
    }




     public List<BorrowedBook> getBorrowings(@RequestParam(required = false) String borrower){

        List<BorrowedBook> filteredBooks = new ArrayList<>();
        for (BorrowedBook borrowedBook : borrowings){
            if (borrowedBook.getBorrower().equals(borrower)){
                filteredBooks.add(borrowedBook);
            }
        }
        Book book = new Book();

       return this.borrowings;
      }

    public BorrowedBook getBorrowings(@PathVariable Integer id){
        return this.borrowings.get(id);
    }



      public void DeleteBorrowing(@PathVariable Integer id){
          this.borrowings.remove(this.borrowings.get(id));
     }
}
