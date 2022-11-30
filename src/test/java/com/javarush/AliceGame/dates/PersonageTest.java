package com.javarush.AliceGame.dates;

import com.javarush.AliceGame.dates.Personage;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
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
    void equalsAndHashCodeContractTest() {
        EqualsVerifier.simple()
                .forClass(Personage.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }
}
