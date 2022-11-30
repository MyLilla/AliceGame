package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameMapTest {

    @Spy
    ArrayList<Room> rooms;
    @Mock
    GameMap gameMap;
    @Mock
    Room room;

    @BeforeEach
    void init() {
        rooms = new ArrayList<>();
    }

    @Test
    void createRoomsTest() {
        assertEquals(ArrayList.class, gameMap.createRooms().getClass());
    }

    @Test
    void createRoomsTest_RoomsShouldContainRoom() {
        rooms.add(room);
        assertTrue(rooms.contains(room));
    }
}
