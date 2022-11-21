package com.javarush.AliceGame.dates;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class User {

    private String name;
    private String actualRoom;
    private ArrayList<String> invents = new ArrayList<>();
    private ArrayList<String> usedInvents = new ArrayList<>();
}
