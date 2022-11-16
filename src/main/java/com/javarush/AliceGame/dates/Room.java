package com.javarush.AliceGame.dates;


import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Room {

    private String name;
    private ArrayList<String> door;
    public Room(String name) {
        this.name = name;
        this.door = new ArrayList<>();
    }
}
