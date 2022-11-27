package com.javarush.AliceGame.exceptions;

public class DialogException extends RuntimeException{

    public DialogException() {
    }

    public DialogException(String message) {
        super(message);
    }
}
