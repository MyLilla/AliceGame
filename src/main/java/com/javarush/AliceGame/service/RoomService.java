package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.exceptions.RoomException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class RoomService {
    private static final Logger LOGGER = LogManager.getLogger(RoomService.class);
    private final List<Room> rooms;
    private final List<Personage> personages;

    public RoomService(List<Room> rooms, List<Personage> personages) {
        this.rooms = rooms;
        this.personages = personages;
        LOGGER.info("Created RoomService");
    }

    public Room getActualRoom(User user) {
        return rooms.get(user.getLocationId());
    }

    public Personage getActualPersonage(User user) {
        return personages.get(user.getLocationId());
    }

    public int parseNextRoom(String nextRoom) {

        if (ObjectUtils.isEmpty(nextRoom)) {
            LOGGER.error("next room is null or empty. Value: '{}'", nextRoom);
            throw new RoomException("next room is null or empty. Value: '" + nextRoom + "'");
        }
        try {
            return Integer.parseInt(nextRoom);
        } catch (NumberFormatException exception) {
            LOGGER.error("next room is not number. Value: {}", nextRoom);
            throw new RoomException("next room is not number. Value: " + nextRoom + exception.getMessage());
        }
    }

    private Integer getFinishRoomId() {
        return rooms.size() - 1;
    }

    public boolean checkWin(Integer nextRoomId, User user) {
        Integer finishRoom = getFinishRoomId();
        LOGGER.debug("Get finishRoomId: {}", finishRoom);

        if (Objects.equals(nextRoomId, finishRoom)) {
            LOGGER.debug("Objects {} equals {}", nextRoomId, finishRoom);

            int openedDoors = user.getOpenedDoors().size();
            LOGGER.debug("opened doors: {} finished doors: {}", openedDoors, rooms.size());

            return openedDoors + 1 == rooms.size();
        }
        return false;
    }
}
