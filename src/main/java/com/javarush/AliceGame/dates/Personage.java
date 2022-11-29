package com.javarush.AliceGame.dates;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Personage {

    private int id;
    private String name;
    private String imgPath;
}
