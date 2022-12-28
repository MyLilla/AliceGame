package com.javarush.AliceGame.dates;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private int id;

    private String name;
    private Integer locationId = 0;
    private List<String> invents = new ArrayList<>();
    private List<String> usedInvents = new ArrayList<>();
    private HashSet<Integer> openedDoors = new HashSet<>();

    private int currentGame = 0;
}
