package com.javarush.AliceGame.dates;

import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

@Getter
public class UsersRepository {
    private static final Logger LOGGER = LogManager.getLogger(UsersRepository.class);
    private final List <Integer> START_OPENED_ROOMS = List.of(3, 4);
    private final HashMap<String, User> usersRep = new HashMap<>();
    private int countUserId = 0;

    public User fetchUserByUsername (String userName) {

        if (ObjectUtils.isEmpty(userName)) {
            LOGGER.debug("user name is empty or null. Value: '{}'", userName);
            return null;
        }

        if (usersRep.containsKey(userName)) {
            LOGGER.info("User repository has this user: {}", userName);
            return usersRep.get(userName);
        }
        User user = new User();
        countUserId++;
        user.setId(countUserId);
        user.setName(userName);
        user.getOpenedDoors().addAll(START_OPENED_ROOMS);
        LOGGER.info("Created new user. id: {}, doors: {}",user.getId(), user.getOpenedDoors());

        usersRep.put(userName, user);
        return user;
    }

    public User resetProgress(User user) {

        user.setLocationId(0);
        user.getInvents().clear();
        user.getUsedInvents().clear();
        user.getOpenedDoors().clear();
        user.getOpenedDoors().addAll(START_OPENED_ROOMS);
        user.setCurrentGame(user.getCurrentGame() + 1);
        LOGGER.info("for user id: {} cleaning result, current game = {}", user.getId(), user.getCurrentGame());

        return user;
    }
}
