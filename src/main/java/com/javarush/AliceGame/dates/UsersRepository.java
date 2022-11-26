package com.javarush.AliceGame.dates;

import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

@Getter
public class UsersRepository {
    protected static final Logger LOGGER = LogManager.getLogger(UsersRepository.class);
    private final HashMap<String, User> usersRep = new HashMap<>();

    public User getUserObj(String userName) {

        if (ObjectUtils.isEmpty(userName)) {
            LOGGER.debug("user name is empty or null");
            return null;
        }

        if (usersRep.containsKey(userName)) {
            LOGGER.info("User repository has this user: {}", userName);
            return usersRep.get(userName);
        }
        User user = new User();
        user.setName(userName);
        user.getOpenedDoors().add(3);
        user.getOpenedDoors().add(4);
        LOGGER.info("Created new user: {}, name: {}, doors: {}", user, user.getName(), user.getOpenedDoors());

        usersRep.put(userName, user);
        return user;
    }
}
