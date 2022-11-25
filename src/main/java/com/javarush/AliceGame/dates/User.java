package com.javarush.AliceGame.dates;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private String name;
    private Integer locationId = 0;
    private ArrayList<String> invents = new ArrayList<>();
    private ArrayList<String> usedInvents = new ArrayList<>();
    private ArrayList<Integer> openedDoors = new ArrayList<>();

}
