package com.javarush.AliceGame.dates;


import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;


@Data
@Builder
public class Personage {

    private String name;
    private String text;
    // private String imgPath;
    private Dialog dialog;
}
