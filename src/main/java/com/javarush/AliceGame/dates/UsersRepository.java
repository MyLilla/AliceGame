package com.javarush.AliceGame.dates;

import com.javarush.AliceGame.exceptions.UserInitException;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

@Getter
public class UsersRepository {
    protected static final Logger LOGGER = LogManager.getLogger(UsersRepository.class);
    private final HashMap<String, User> usersRep = new HashMap<>();
    public User getUserObj (String userName) {
        if (userName == null) {
            LOGGER.debug("User name is null" );
            throw new UserInitException("User name can't be null");
        }

        if (userName.isEmpty()) {
            LOGGER.debug("user name is empty");
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
            LOGGER.info("Created new user: {}", user);

            usersRep.put(userName, user);
            return user;

    }
}
