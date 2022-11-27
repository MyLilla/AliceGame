package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.exceptions.RoomException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
public class RoomService {
    protected static final Logger LOGGER = LogManager.getLogger(RoomService.class);
    private final ArrayList<Room> rooms;

    public RoomService(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public int parseNextRoom(String nextRoom) {

        if (ObjectUtils.isEmpty(nextRoom)) {
            LOGGER.error("next room is null or empty");
            throw new RoomException("next room is null or empty");
        }
        return Integer.parseInt(nextRoom);
    }

    public Integer getFinishRoomId() {
        return rooms.size() - 1;
    }

    public boolean checkWin(Integer nextRoomId, User user) {
        Integer finishRoom = getFinishRoomId();
        if (Objects.equals(nextRoomId, finishRoom)) {
            LOGGER.debug("Objects {} == {}", nextRoomId, finishRoom);

            int openedDoors = user.getOpenedDoors().size();

            LOGGER.debug("opened doors: {}  finished doors: {}", openedDoors, rooms.size());
            return openedDoors + 1 == rooms.size();
        }
        return false;
    }
}
