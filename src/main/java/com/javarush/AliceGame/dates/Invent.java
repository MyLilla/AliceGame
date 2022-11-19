package com.javarush.AliceGame.dates;


import lombok.Getter;

@Getter
public class Invent {
    private int id;
    private String name;

    public Invent(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
