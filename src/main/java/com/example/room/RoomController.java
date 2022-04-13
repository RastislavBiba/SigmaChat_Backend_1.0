package com.example.room;

import com.example.room.RoomDto;
import com.example.room.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping("/api/rooms")
    public List<RoomDto> getRooms(@RequestParam(required = false) String name ){
        return roomService.getRooms(name);
    }

    @GetMapping("/api/rooms/{roomId}")
    public RoomDto getRoom(@PathVariable Long roomId){
        return roomService.getRoom(roomId);
    }

    @PostMapping("/api/rooms")
    public Long createRoom(@RequestBody RoomDto roomDto){
      return roomService.createRoom(roomDto);
    }

   @DeleteMapping("/api/rooms{roomId}")
    public void deleteRoom(@PathVariable int roomId){
       roomService.deleteRoom(roomId);
   }

   @PutMapping("/api/rooms/{roomId}")
    public void updateRoom(@PathVariable int roomId, @RequestBody RoomDto roomDto){
       roomService.updateRoom(roomId, roomDto);
   }
}
