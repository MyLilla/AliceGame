package com.javarush.AliceGame.dates;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Room {

    private String name;
    private List<String> door;
    private Personage personage;
    private List<String> invents;
    private String openedInvent;

}
