package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class GameMap {

    private static final Logger LOGGER = LogManager.getLogger(GameMap.class);

    public List<Room> createRooms() {

        ArrayList<Room> rooms = new ArrayList<>();

        Room rabbitHole = Room.builder()
                .id(0)
                .name("rabbitHole")
                .invents(List.of("potion"))
                .door(List.of(1))
                .openedInvent("potion")
                .build();
        LOGGER.info("created {} with id: {}", rabbitHole.getName(), rabbitHole.getId());
        rooms.add(rabbitHole.getId(), rabbitHole);

        Room mushroomForest = Room.builder()
                .id(1)
                .name("mushroomForest")
                .invents(List.of("red mushroom", "horror mushroom", "white mushroom", "talking mushroom"))
                .door(List.of(3, 2))
                .openedInvent("white mushroom")
                .build();
        LOGGER.info("created {} with id: {}", mushroomForest.getName(), mushroomForest.getId());
        rooms.add(mushroomForest.getId(), mushroomForest);

        Room caterpillarArea = Room.builder()
                .id(2)
                .name("caterpillarArea")
                .invents(List.of("watch"))
                .door(List.of(1))
                .openedInvent("")
                .build();
        LOGGER.info("created {} with id: {}", caterpillarArea.getName(), caterpillarArea.getId());
        rooms.add(caterpillarArea.getId(), caterpillarArea);

        Room hatterHome = Room.builder()
                .id(3)
                .name("hatterHome")
                .door(List.of(1, 4, 5))
                .openedInvent("watch")
                .build();
        LOGGER.info("created {} with id: {}", hatterHome.getName(), hatterHome.getId());
        rooms.add(hatterHome.getId(), hatterHome);

        Room redKingdom = Room.builder()
                .id(4)
                .name("redKingdom")
                .door(List.of(6, 3))
                .openedInvent("knife")
                .build();
        LOGGER.info("created {} with id: {}", redKingdom.getName(), redKingdom.getId());
        rooms.add(redKingdom.getId(), redKingdom);

        Room whiteKingdom = Room.builder()
                .id(5)
                .name("whiteKingdom")
                .invents(List.of("knife", "sword"))
                .door(List.of(7, 3))
                .openedInvent("cake")
                .build();
        LOGGER.info("created {} with id: {}", whiteKingdom.getName(), whiteKingdom.getId());
        rooms.add(whiteKingdom.getId(), whiteKingdom);

        Room dungeon = Room.builder()
                .id(6)
                .name("dungeon")
                .invents(List.of("cake"))
                .door(List.of(4))
                .build();
        LOGGER.info("created {} with id: {}", dungeon.getName(), dungeon.getId());
        rooms.add(dungeon.getId(), dungeon);

        Room london = Room.builder()
                .id(7)
                .name("london")
                .door(List.of(0))
                .openedInvent("")
                .build();
        LOGGER.info("created {} with id: {}", london.getName(), london.getId());
        rooms.add(london.getId(), london);

        LOGGER.debug("Rooms list size: {}", rooms.size());
        return Collections.unmodifiableList(rooms);
    }

    public List<Personage> createPersonsList() {

        ArrayList<Personage> personages = new ArrayList<>();

        personages.add(Personage.builder()
                .id(0)
                .name("whiteRabbit")
                .imgPath("img/rabbit.png\" width=\"300\" height=\"500")
                .build());

        personages.add(Personage.builder()
                .id(1)
                .name("cat")
                .imgPath("img/cat.png\" width=\"300\" height=\"500")
                .build());

        personages.add(Personage.builder()
                .id(2)
                .name("caterpillar")
                .imgPath("img/caterpillar.png")
                .build());

        personages.add(Personage.builder()
                .id(3)
                .name("hatter")
                .imgPath("img/hatter.png")
                .build());

        personages.add(Personage.builder()
                .id(4)
                .name("Red Quin")
                .imgPath("img/red.png")
                .build());

        personages.add(Personage.builder()
                .id(5)
                .name("card")
                .imgPath("img/card.png")
                .build());

        personages.add(Personage.builder()
                .id(6)
                .name("dragon")
                .imgPath("img/drag.png")
                .build());

        LOGGER.debug("Persons list size: {}", personages.size());
        return Collections.unmodifiableList(personages);
    }

    public List<Dialog> createDialogMap() {

        ArrayList<Dialog> personsDialogs = new ArrayList<>();

        personsDialogs.add(0, Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                                .id(0)
                                .text("There is only an entrance to the hole, but no exit. ")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text("How to get to London?").
                                        nextQuestion(1).build())).build(),
                        Dialog.Message.builder()
                                .id(1)
                                .text("You have to go through all the wonderland that's behind that little door")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("I don't see the door").
                                                nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text("look for the door")
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text("Where is the wonderland?")
                                                .nextQuestion(2)
                                                .build())).build(),
                        Dialog.Message.builder()
                                .id(2)
                                .text("The door is very small, and you are huge. You don't fit the size. You need some magic")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Look for the potion")
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text("Where is London??").
                                                nextQuestion(1).build())).build())).build());

        personsDialogs.add(1, Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                                .id(0)
                                .text("Cat is smiling")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Where is the door to London?").
                                                nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text("What mushrooms are edible?").
                                                nextQuestion(2).build())).build(),
                        Dialog.Message.builder()
                                .id(1)
                                .text("Various things can be hidden from view.")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text("Where is the door to London?").
                                        nextQuestion(0).build()))
                                .build(),
                        Dialog.Message.builder()
                                .id(2)
                                .text("Better ask the hatter about it, he understands")
                                .build())).build());

        personsDialogs.add(2, Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                                .id(0)
                                .text("What do you need, character?")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Nothing").build(),
                                        Dialog.Answer.builder()
                                                .text("Where is the door to London?")
                                                .nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text("I wanna smoke with you")
                                                .nextQuestion(2).build())).build(),
                        Dialog.Message.builder()
                                .id(1)
                                .text("Smoke hookah with me. Maybe you'll start finding them.")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("No, I didn't smoke")
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text("Accept")
                                                .nextQuestion(2).build())).build(),
                        Dialog.Message.builder()
                                .id(2)
                                .text("Thanks for the company! Door to wonderland in the white kingdom. " +
                                        "And by the way, give the watch to the hatter, he's probably looking for it.")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text("find the watch")
                                        .build())).build())).build());

        personsDialogs.add(3, Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                                .id(0)
                                .text("I can't find my watch, have you seen my watch?")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("give away the watch")
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text("What mushrooms are edible??")
                                                .nextQuestion(1).build())).build(),
                        Dialog.Message.builder()
                                .id(1)
                                .text("Not all mushrooms are edible, some increase, some kill .. " +
                                        "For example, \"white\" ones show secret doors, and some are just mushrooms")
                                .build())).build());

        personsDialogs.add(4, Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                                .id(0)
                                .text("What do you need?")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text("I find the cake")
                                        .nextQuestion(1)
                                        .build())).build(),
                        Dialog.Message.builder()
                                .id(1)
                                .text("I have a cake in the dungeon, but I can't give it to you.")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text("Ask for a piece")
                                        .nextQuestion(2)
                                        .build(), Dialog.Answer.builder()
                                        .text("Look for the entrance to the dungeon")
                                        .build())).build(),
                        Dialog.Message.builder()
                                .id(2)
                                .text("If you have the knife, You can enter in the dungeon")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Look for the knife")
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text("Use the knife")
                                                .build())).build())).build());

        personsDialogs.add(5, Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                        .id(0)
                        .text("To pass, you need to eat a growth cake.")
                        .answers(List.of(Dialog.Answer.builder()
                                .text("Look for cake")
                                .build())).build())).build());

        personsDialogs.add(Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                        .id(0)
                        .text("I'm watching you. \nOne creature - one piece of cake")
                        .build())).build());

        LOGGER.debug("DialogMap list size: {}", personsDialogs.size());
        return Collections.unmodifiableList(personsDialogs);
    }
}
