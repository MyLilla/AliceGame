package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.exceptions.InvalidStateException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Getter
@Setter
public class QuestService {
    protected static final Logger LOGGER = LogManager.getLogger(QuestService.class);

    private final ArrayList<Room> rooms;
    private final ArrayList<Dialog> dialogs;

    public QuestService(ArrayList<Room> rooms, ArrayList<Dialog> dialogs) {
        this.rooms = rooms;
        this.dialogs = dialogs;
        LOGGER.debug("QuestService created");
    }

    public void addInventToUser(User user, String invent) {
        if (ObjectUtils.isEmpty(invent)){
            LOGGER.error("invent is null or empty");
            throw new InvalidStateException("invent can't be null or empty");
        }
        if (user == null){
            LOGGER.error("user is null or empty");
            throw new InvalidStateException("user can't be null or empty");
        }

        if (!(user.getInvents().contains(invent))) {
            user.getInvents().add(invent);
            LOGGER.info("In user invent added: {}", invent);
        }
    }

    public void usedInvent(User user, String invent) {

        if (ObjectUtils.isEmpty(invent)){
            LOGGER.error("invent is null or empty");
            throw new InvalidStateException("invent can't be null or empty");
        }
        if (user == null){
            LOGGER.error("user is null or empty");
            throw new InvalidStateException("user can't be null or empty");
        }

        user.getInvents().remove(invent);
        user.getUsedInvents().add(invent);
        LOGGER.info("{} - was used", invent);

        openDoors(user, invent);
    }

    private void openDoors(User user, String invent) {
        for (Room room : rooms) {
            if (user.getUsedInvents()
                    .contains(room.getOpenedInvent())) {
                user.getOpenedDoors().addAll(room.getDoor());
                LOGGER.info("in room: {} was opened all doors. With invent: {}", room.getId(), invent);
            }
        }
    }

    public boolean checkFail(String invent) {
        return invent.equals("red mushroom");
    }
}
