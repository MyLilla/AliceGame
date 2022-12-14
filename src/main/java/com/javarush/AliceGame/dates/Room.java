package com.javarush.AliceGame.dates;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Room {

    private Integer id;
    private String name;
    private List<Integer> door;
    private List<String> invents;
    private String openedInvent;
}
