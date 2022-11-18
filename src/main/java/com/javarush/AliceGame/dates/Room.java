package com.javarush.AliceGame.dates;


import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Room {
    private Integer id;
    private String name;
    private ArrayList<String> door;

    public Room(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.door = new ArrayList<>();
    }
}
