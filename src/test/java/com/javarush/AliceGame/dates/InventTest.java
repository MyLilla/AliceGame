package com.javarush.AliceGame.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventTest {

    Invent invent;

    @BeforeEach
    void setup () {
        invent = Invent.builder()
                .id(0)
                .name("Example")
                .build();
    }

    @Test
    void getId() {
        assertEquals(0, invent.getId());
    }

    @Test
    void getNameTest() {
        assertEquals("Example", invent.getName());
    }
}
