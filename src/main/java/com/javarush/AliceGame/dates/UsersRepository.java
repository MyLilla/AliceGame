package com.javarush.AliceGame.dates;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class UsersRepository {

    private final HashMap<String, User> usersRep = new HashMap<>();

    public User addUser (String userName) {
        if (usersRep.containsKey(userName)) {
            return usersRep.get(userName);
        } else {
            User user = new User();
            user.setName(userName);
            usersRep.put(userName, user);
            return user;
        }
    }
}