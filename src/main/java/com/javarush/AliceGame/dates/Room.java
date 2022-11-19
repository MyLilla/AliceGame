package com.javarush.AliceGame.dates;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Room {

    private String name;
    private List<String> door = new ArrayList<>();
    private Personage personage;
   // private List<String> invents = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    }



