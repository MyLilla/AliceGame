package com.javarush.AliceGame.exceptions;

public class RoomException extends RuntimeException{

    public RoomException() {
    }

    public RoomException(String message) {
        super(message);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
