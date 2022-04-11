package com.example.room;

import com.example.message.MessageService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private List<Book> books;
    private List<Room> rooms;
    private List<User> users;
    private MessageService messageService;


    
    


    private String name;
    private String messages;




    private List<Room> initRooms(){
        List<Room> rooms = new ArrayList<>();
        Room newRoom1 = new Room();

        newRoom1.setName("meno pokus");
        newRoom1.setUsers("adam");
        newRoom1.setId(1);

        rooms.add(newRoom1);

        return rooms;
    }
    
    public Integer createRoom(@RequestBody String name, String user) {
        Room r1 = new Room();
        r1.setUsers(user);
        
        this.rooms.add(r1);
        return this.rooms.size()-1;
        
    }
    
    

    /*public Integer createBorrowing(@RequestBody String borrower, String book){
        Room borrowed = new Room();
        borrowed.setBorrower(borrower);
        borrowed.setBook(book);

        this.rooms.add(borrowed);
        return this.rooms.size()-1;
    }*/




     public List<Room> getRooms(@RequestParam(required = false) String user){

        List<Room> filteredBooks = new ArrayList<>();
        for (Room room : rooms){
            if (room.getUsers().equals(user)){
                filteredBooks.add(room);
            }
        }
        //Book book = new Book();

       return this.rooms;
      }

    public Room getRooms(@PathVariable Integer id){
        return this.rooms.get(id);
    }



      public void DeleteRooms(@PathVariable Integer id){
          this.rooms.remove(this.rooms.get(id));
     }
}
