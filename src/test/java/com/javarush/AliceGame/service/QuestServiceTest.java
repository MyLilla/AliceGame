package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.exceptions.InvalidStateException;
import com.javarush.AliceGame.service.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestServiceTest {

    @Mock
    Dialog dialog;
    @Spy
    ArrayList<Dialog> dialogs;
    @Mock
    Room room;
    @Spy
    ArrayList<Room> rooms;
    @Mock
    QuestService questService;
    @Spy
    User user;

    @BeforeEach
    void setup() {
        dialog = Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                        .id(0)
                        .text("Message text")
                        .answers(List.of(Dialog.Answer.builder()
                                .text("Answer text").
                                nextQuestion(1).build())).build())).build();
        dialogs.add(dialog);
        room = Room.builder()
                .id(0)
                .name("rabbitHole")
                .invents(List.of("potion"))
                .door(List.of(1))
                .openedInvent("potion")
                .build();
        rooms.add(room);
        questService = new QuestService(rooms, dialogs);
    }

    @Test
    void addInventToUserTest_positive() {
        questService.addInventToUser(user, "tool");
        assertTrue(user.getInvents().contains("tool"));
    }

    @Test
    void addInventToUserTest_WhenInventIsNull() {
        assertThrows(InvalidStateException.class,
                () -> questService.addInventToUser(user, null));
    }

    @Test
    void addInventToUserTest_WhenInventIsEmpty() {
        assertThrows(InvalidStateException.class,
                () -> questService.addInventToUser(user, ""));
    }

    @Test
    void addInventToUserTest_WhenUserIsNull() {
        assertThrows(InvalidStateException.class,
                () -> questService.addInventToUser(null, "tool"));
    }

    @Test
    void addInventToUserTest_WhenBothArgsAreNull() {
        assertThrows(InvalidStateException.class,
                () -> questService.addInventToUser(null, null));
    }

    @Test
    void usedInventTest_PositiveUsed() {
        questService.usedInvent(user, "tool");
        assertTrue(user.getUsedInvents().contains("tool"));
    }

    @Test
    void usedInventTest_WhenInventIsNull() {
        assertThrows(InvalidStateException.class,
                () -> questService.usedInvent(user, null));
    }

    @Test
    void usedInventTest_WhenUserIsNull() {
        assertThrows(InvalidStateException.class,
                () -> questService.usedInvent(null, "tool"));
    }

    @Test
    void usedInventTest_WhenBothArgsAreNull() {
        assertThrows(InvalidStateException.class,
                () -> questService.usedInvent(null, null));
    }

    @Test
    void usedInventTest_PositiveOpenDoors() {
        questService.usedInvent(user,"potion");
       assertEquals(1, user.getOpenedDoors().size());
    }

    @Test
    void checkFailTest_whenInventIsTrue() {
        assertTrue(questService.checkFail("red mushroom"));
    }

    @Test
    void checkFailTest_whenInventIsFalse() {
        assertFalse(questService.checkFail("Something"));
    }

    @Test
    void getRoomsTest_Positive() {
        assertEquals(rooms, questService.getRooms());
    }

    @Test
    void getDialogsTest_Positive() {
        assertEquals(dialogs, questService.getDialogs());
    }
}