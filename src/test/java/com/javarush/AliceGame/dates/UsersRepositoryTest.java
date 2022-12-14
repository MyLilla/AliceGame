package com.javarush.AliceGame.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsersRepositoryTest {

    @Spy
    User user;
    @Spy
    UsersRepository usersRepository;

    @BeforeEach
    void setup() {
        usersRepository.getUsersRep().put("Name", user);
        System.out.println(user);
    }

    @Test
    void getUserObjTest_When_users_contain_userName() {
        assertEquals(user, usersRepository.fetchUserByUsername("Name"));
    }

    @Test
    void getUserObjTest_if_userName_isEmpty() {
        assertEquals(null, usersRepository.fetchUserByUsername(""));
    }

    @Test
    void getUserObjTest_if_userName_is_null() {
        assertEquals(null, usersRepository.fetchUserByUsername(null));
    }

    @Spy
    User expectedUser = new User();

    @Test
    void getUserObjTest_newUser_added_inRepo() {
        expectedUser.setName("Other");
        expectedUser.getOpenedDoors().add(3);
        expectedUser.getOpenedDoors().add(4);
        usersRepository.getUsersRep().put(expectedUser.getName(), expectedUser);
        assertEquals(expectedUser, usersRepository.fetchUserByUsername("Other"));
    }

    @Test
    void resetProgressTest() {

        user.setLocationId(0);
        user.getOpenedDoors().add(3);
        user.getOpenedDoors().add(4);
        user.setCurrentGame(2);

        assertEquals(user, usersRepository.resetProgress(user));
    }
}
