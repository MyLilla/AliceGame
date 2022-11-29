package com.javarush.AliceGame.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room room;
    List<String> invents;
    List<Integer> doors;

    @BeforeEach
    void setup() {
        invents = new ArrayList<>();
        invents.add("invent");

        doors = new ArrayList<>();
        doors.add(1);
        room = Room.builder()
                .id(0)
                .name("example")
                .invents(invents)
                .door(List.of(1))
                .openedInvent("openInvent")
                .build();
    }

    @Test
    void getIdTest() {
        assertEquals(0, room.getId());
    }

    @Test
    void getName() {
        assertEquals("example", room.getName());
    }

    @Test
    void getDoorTest() {
        assertEquals(doors, room.getDoor());
    }

    @Test
    void getInventsTest() {
        assertEquals(invents, room.getInvents());
    }

    @Test
    void getOpenedInventTest() {
        assertEquals("openInvent", room.getOpenedInvent());
    }
}
