package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameMap {

    public ArrayList<Room> createRooms() {

        ArrayList<Room> rooms = new ArrayList<>();

        Room rabbitHole = Room.builder()
                .id(0)
                .name("rabbitHole")
                .invents(List.of("potion"))
                .door(List.of(1))
                .openedInvent("potion")
                .build();
        rooms.add(rabbitHole.getId(), rabbitHole);

        Room mushroomForest = Room.builder()
                .id(1)
                .name("mushroomForest")
                .invents(List.of("red mushroom", "horror mushroom", "white mushroom", "talking mushroom"))
                .door(List.of(3, 2))
                .openedInvent("white mushroom")
                .build();
        rooms.add(mushroomForest.getId(), mushroomForest);

        Room caterpillarArea = Room.builder()
                .id(2)
                .name("caterpillarArea")
                .invents(List.of("watch"))
                .door(List.of(1))
                .openedInvent("")
                .build();
        rooms.add(caterpillarArea.getId(), caterpillarArea);

        Room hatterHome = Room.builder()
                .id(3)
                .name("hatterHome")
                .door(List.of(1, 4, 5))
                .openedInvent("watch")
                .build();
        rooms.add(hatterHome.getId(), hatterHome);

        Room redKingdom = Room.builder()
                .id(4)
                .name("redKingdom")
                .door(List.of(6, 3))
                .openedInvent("knife")
                .build();
        rooms.add(redKingdom.getId(), redKingdom);

        Room whiteKingdom = Room.builder()
                .id(5)
                .name("whiteKingdom")
                .invents(List.of("knife"))
                .door(List.of(7, 3))
                .openedInvent("cake")
                .build();
        rooms.add(whiteKingdom.getId(), whiteKingdom);

        Room dungeon = Room.builder()
                .id(6)
                .name("dungeon")
                .invents(List.of("cake"))
                .door(List.of(4))
                .build();
        rooms.add(dungeon.getId(), dungeon);

        Room london = Room.builder()
                .id(7)
                .name("london")
                .door(List.of(0))
                .openedInvent("")
                .build();
        rooms.add(london.getId(), london);

        return rooms;
    }

    public ArrayList<Personage> createPersonsList() {

        ArrayList<Personage> list = new ArrayList<>();

        list.add(Personage.builder()
                .id(0)
                .name("whiteRabbit")
                .imgPath("img/rabbit.png\" width=\"300\" height=\"500")
                .build());

        list.add(Personage.builder()
                .id(1)
                .name("cat")
                .imgPath("img/cat.png\" width=\"300\" height=\"500")
                .build());

        list.add(Personage.builder()
                .id(2)
                .name("caterpillar")
                .imgPath("img/caterpillar.png")
                .build());

        list.add(Personage.builder()
                .id(3)
                .name("hatter")
                .imgPath("img/hatter.png")
                .build());

        list.add(Personage.builder()
                .id(4)
                .name("Red Quin")
                .imgPath("img/red.png")
                .build());

        list.add(Personage.builder()
                .id(5)
                .name("card")
                .imgPath("img/card.png")
                .build());

        list.add(Personage.builder()
                .id(6)
                .name("dragon")
                .imgPath("img/drag.png")
                .build());

        return list;
    }

    public ArrayList<Dialog> createDialogMap() {

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
                        .text("Do you have a knife to destroy the Queen?")
                        .answers(List.of(Dialog.Answer.builder()
                                        .text("Find the knife")
                                        .build(),
                                Dialog.Answer.builder()
                                        .text("Use knife")
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
                        .text("Need to kill him and take away \"cake\"")
                        .build())).build());

        return personsDialogs;
    }
}
