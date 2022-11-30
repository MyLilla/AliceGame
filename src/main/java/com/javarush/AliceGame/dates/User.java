package com.javarush.AliceGame.dates;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;

@Getter
@Setter
@EqualsAndHashCode
public class User {

    private String name;
    private Integer locationId = 0;
    private ArrayList<String> invents = new ArrayList<>();
    private ArrayList<String> usedInvents = new ArrayList<>();
    private HashSet<Integer> openedDoors = new HashSet<>();

    private int currentGame = 0;
}
