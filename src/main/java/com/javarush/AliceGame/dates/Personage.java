package com.javarush.AliceGame.dates;


import lombok.Getter;

@Getter
public class Personage {

    private int id;
    private String name;
    private String text;

    public Personage(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }
}
