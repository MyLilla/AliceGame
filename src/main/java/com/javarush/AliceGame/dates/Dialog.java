package com.javarush.AliceGame.dates;

import lombok.*;
import java.util.List;

@Data
@Builder
public class Dialog {

    private List<Message> messages;
    @Data
    @Builder
    public static class Message {
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
