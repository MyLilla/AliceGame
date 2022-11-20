package com.javarush.AliceGame.dates;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

@Getter
@Setter
public class Dialog {

    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList <Answer> answers = new ArrayList<>();

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Question {
        Integer id;
        String text;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Answer {
        String text;
        Integer nextQuestion;
    }
}
