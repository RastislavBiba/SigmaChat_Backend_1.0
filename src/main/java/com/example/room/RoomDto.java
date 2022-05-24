package com.example.room;

public class RoomDto {
    private Long room_id;
    private String name;
    private Long id_user;

    public Long getId() { return room_id; }

    public void setId(Long id) {
        this.room_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}
