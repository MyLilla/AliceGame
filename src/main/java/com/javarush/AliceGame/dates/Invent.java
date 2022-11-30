package com.javarush.AliceGame.dates;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Invent {
    private int id;
    private String name;
}
