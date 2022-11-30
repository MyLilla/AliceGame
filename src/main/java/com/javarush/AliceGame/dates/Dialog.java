package com.javarush.AliceGame.dates;

import lombok.*;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
public class Dialog {

    private List<Message> messages;

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class Message {
        Integer id;
        String text;
        private List<Answer> answers;
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class Answer {
        String text;
        Integer nextQuestion;
    }
}
