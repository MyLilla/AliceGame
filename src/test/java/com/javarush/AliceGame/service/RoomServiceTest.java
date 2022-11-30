package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.exceptions.RoomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    Room room;
    @Spy
    ArrayList<Room> rooms;
    @Mock
    Personage personage;
    @Spy
    ArrayList<Personage> personages;
    @Mock
    RoomService roomService;

    @BeforeEach
    void setup() {
        room = Room.builder()
                .id(0)
                .name("roomName")
                .invents(List.of("invent"))
                .door(List.of(1))
                .openedInvent("invent")
                .build();
        rooms.add(room.getId(), room);
        roomService = new RoomService(rooms, personages);

        personage = Personage.builder()
                .id(0)
                .name("personage")
                .imgPath("img")
                .build();
        personages.add(personage);
    }

    @Test
    void getRoomsTest() {
        assertEquals(rooms, roomService.getRooms());
    }


    @Test
    void getPersonagesTest() {
        assertEquals(personage, roomService.getPersonages());
    }

    @Test
    void getActualRoomTest() {
        when(user.getLocationId()).thenReturn(0);
        assertEquals(room, roomService.getActualRoom(user));
    }

    @Test
    void getActualPersonageTest() {
        when(user.getLocationId()).thenReturn(0);
        assertEquals(personage, roomService.getActualPersonage(user));
    }

    @Test
    void parseNextRoomTest_WhenNextRoomIsNull() {
        assertThrows(RoomException.class,
                () -> roomService.parseNextRoom(null));
    }

    @Test
    void parseNextRoomTest_WhenNextRoomIsEmpty() {
        assertThrows(RoomException.class,
                () -> roomService.parseNextRoom(""));
    }

    @Test
    void parseNextRoomTest_WhenNextRoomCorrect() {
        assertEquals(0, roomService.parseNextRoom("0"));
    }

    @Test
    void getFinishRoomIdTest_Positive() {
        rooms.add(room);
        rooms.add(room);
        assertEquals(2, roomService.getFinishRoomId());
    }

    @Spy
    User user;

    @Test
    void checkWinTest_WhenUserIsWin_True() {
        user.getOpenedDoors().add(0);
        user.getOpenedDoors().add(1);
        rooms.add(1, room);
        rooms.add(2, room);
        assertTrue(roomService.checkWin(2, user));
    }

    @Test
    void checkWinTest_WhenUserIsNotWin_False() {
        assertFalse(roomService.checkWin(2, user));
    }
}
