package com.javarush.AliceGame.dates;

import com.javarush.AliceGame.dates.Personage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonageTest {
    Personage personage;

    @BeforeEach
    void setup() {
        personage = Personage.builder()
                .id(0)
                .name("cat")
                .imgPath("path")
                .build();
    }

    @Test
    void getIdTest() {
        assertEquals(0, personage.getId());
    }

    @Test
    void getNameTest() {
        assertEquals("cat", personage.getName());
    }

    @Test
    void getImgPathTest() {
        assertEquals("path", personage.getImgPath());
    }

    @Test
    void setIdTest() {
        personage.setId(3);
        assertEquals(3, personage.getId());
    }

    @Test
    void setNameTest() {
        personage.setName("dog");
        assertEquals("dog", personage.getName());
    }

    @Test
    void setImgPathTest() {
        personage.setImgPath("way");
        assertEquals("way", personage.getImgPath());
    }
}
