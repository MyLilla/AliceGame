package com.javarush.AliceGame.dates;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Dialog {

    private List<Question> questions;

    @Data
    @Builder
    public static class Question {
        Integer id;
        String text;
        private List<Answer> answers;
    }
    @Data
    @Builder
    public static class Answer {
        String text;
        Integer nextQuestion;
    }

}
