package com.javarush.AliceGame.dates;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Personage {

    private int id;
    private String name;
    private String imgPath;
    private Dialog dialog;
    // лист диалогов
}
