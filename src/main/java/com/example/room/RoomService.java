package com.example.room;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    private static RoomDto maptoRoomDto(RoomEntity roomEntity){
        RoomDto roomDto = new RoomDto();
        roomDto.setName(roomEntity.getName());
        roomDto.setId(roomEntity.getId());

       // roomDto.setLogin(RoomEntity.getLogin());
        return roomDto;
    }
    @Transactional
    public List<RoomDto> getRooms(String roomName){
        List<RoomDto> ret = new LinkedList<>();
        for (RoomEntity c1 : roomRepository.findAll()){
            RoomDto c2 = maptoRoomDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public RoomDto getRoom(Long roomId){
        Optional<RoomEntity> byId = roomRepository.findById(roomId);
        if (byId.isPresent()){
            return maptoRoomDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createRoom(RoomDto roomDto){
        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setName(roomDto.getName());

        this.roomRepository.save(roomEntity);

        return roomEntity.getId();
    }
    @Transactional
    public void updateRoom(int roomId, RoomDto roomDto){
        Optional<RoomEntity> byId = roomRepository.findById((long)roomId);
        if (byId.isPresent()){
            byId.get().setName(roomDto.getName());
        }
    }

    @Transactional
    public void deleteRoom(int roomId){
        Optional<RoomEntity> byId = roomRepository.findById((long)roomId);
        if (byId.isPresent()){
            roomRepository.delete(byId.get());
        }
    }


///////////////////////////////////////////////////
////old
/*
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




    /* public List<Room> getRooms(@RequestParam(required = false) String user){

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
     }*/



}
