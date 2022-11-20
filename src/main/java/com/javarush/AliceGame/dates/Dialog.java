package com.javarush.AliceGame.dates;


import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
@Builder
public class Dialog {

    private List<Question> questions;
    private List<Answer> answers;

    @Data
    @Builder
    public static class Question {
        Integer id;
        String text;
    }
    @Data
    @Builder
    public static class Answer {
        String text;
        Integer nextQuestion;
    }

}
