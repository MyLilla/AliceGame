package com.javarush.AliceGame.dates;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Mock
    ArrayList<String> invents;
    @Mock
    ArrayList<String> usedInvents;
    @Mock
    HashSet<Integer> openedDoors;
    User user;

    @BeforeEach
    void setup(){
        user = new User();
        user.setName("name");
        user.setInvents(invents);
        user.setUsedInvents(usedInvents);
        user.setOpenedDoors(openedDoors);

    }

    @Test
    void getNameTest() {
        assertEquals("name", user.getName());
    }

    @Test
    void getLocationIdTest() {
        assertEquals(0, user.getLocationId());
    }

    @Test
    void getInventsTest() {
        assertEquals(invents, user.getInvents());
    }

    @Test
    void getUsedInventsTest() {
        assertEquals(usedInvents, user.getUsedInvents());
    }

    @Test
    void getOpenedDoorsTest() {
        assertEquals(openedDoors, user.getOpenedDoors());
    }

    @Test
    void getCurrentGameTest() {
        assertEquals(0, user.getCurrentGame());
    }

    @Test
    void setNameTest() {
        user.setName("Other");
        assertEquals("Other", user.getName());
    }

    @Test
    void setLocationIdTest() {
        user.setLocationId(2);
        assertEquals(2, user.getLocationId());
    }

    @Test
    void setCurrentGameTest() {
        user.setCurrentGame(1);
        assertEquals(1, user.getCurrentGame());
    }

    @Test
    void equalsAndHashCodeContractTest() {
        EqualsVerifier.simple()
                .forClass(User.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }
}