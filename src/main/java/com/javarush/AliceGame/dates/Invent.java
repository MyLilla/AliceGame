package com.javarush.AliceGame.dates;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invent {
    private int id;
    private String name;
}
