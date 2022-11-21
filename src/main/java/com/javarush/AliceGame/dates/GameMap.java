package com.javarush.AliceGame.dates;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class GameMap {
    ArrayList<Personage> personages = createPersonsList();

    public HashMap<String, Room> createRoomsMap() {

        HashMap<String, Room> roomsMap = new HashMap<>();

        Room rabbitHole = Room.builder()
                .name("rabbitHole")
                .personage(personages.get(1))
                .invents(List.of("potion"))
                .door(List.of("mushroomForest"))
                .openedInvent("potion")
                .build();
        roomsMap.put(rabbitHole.getName(), rabbitHole);

        Room mushroomForest = Room.builder()
                .name("mushroomForest")
                .invents(List.of("white mushroom", "red mushroom", "horror mushroom", "talking mushroom"))
                .personage(personages.get(2))
                .door(List.of("hatterHome", "caterpillarArea"))
                .openedInvent("white mushroom")
                .openedDoors(List.of("hatterHome"))
                .build();
        roomsMap.put(mushroomForest.getName(), mushroomForest);

        Room caterpillarArea = Room.builder()
                .name("caterpillarArea")
                .invents(List.of("big bong"))
                .personage(personages.get(0))
                .door(List.of("mushroomForest"))
                .openedDoors(List.of("mushroomForest"))
                .build();
        roomsMap.put(caterpillarArea.getName(), caterpillarArea);

        Room hatterHome = Room.builder()
                .name("hatterHome")
                .personage(personages.get(0))
                .door(List.of("mushroomForest", "redKingdom", "whiteKingdom"))
                .openedDoors(List.of("mushroomForest", "redKingdom"))
                .openedInvent("big bong")
                .build();
        roomsMap.put(hatterHome.getName(), hatterHome);

        Room redKingdom = Room.builder()
                .name("redKingdom")
                .personage(personages.get(0))
                .door(List.of("dungeon", "hatterHome"))
                .openedDoors(List.of("hatterHome"))
                .openedInvent("knife")
                .build();
        roomsMap.put(redKingdom.getName(), redKingdom);

        Room dungeon = Room.builder()
                .name("dungeon")
                .personage(personages.get(0))
                .door(List.of("redKingdom"))
                .build();
        roomsMap.put(dungeon.getName(), dungeon);

        Room whiteKingdom = Room.builder()
                .name("whiteKingdom")
                .personage(personages.get(0))
                .door(List.of("london", "hatterHome"))
                .build();
        roomsMap.put(whiteKingdom.getName(), whiteKingdom);


        Room london = Room.builder()
                .name("london")
                .personage(personages.get(0))
                .door(List.of("rabbitHole"))
                .build();
        roomsMap.put(london.getName(), london);

        return roomsMap;
    }

    private ArrayList<Personage> createPersonsList() {
        ArrayList<Personage> list = new ArrayList<>();

        HashMap<String, Dialog> personsDialogs = createDialogMap();

        list.add(Personage.builder()
                .name("null")
                .imgPath("")
                .build());
        list.add(Personage.builder()
                .name("whiteRabbit")
                .imgPath("img/hatter.png")
                .dialog(personsDialogs.get("whiteRabbit"))
                .build());

        list.add(Personage.builder()
                .name("cat")
                .imgPath("img/cat.png")
                .dialog(personsDialogs.get("cat"))
                .build());
        list.add(Personage.builder()
                .name("caterpillar")
                .imgPath("img/caterpillar.png")
                .dialog(personsDialogs.get("caterpillar"))
                .build());

        return list;
    }

    private HashMap<String, Dialog> createDialogMap() {

        final String EXIT = "exit";
        HashMap<String, Dialog> personsDialogs = new HashMap<>();

        Dialog rabbitDialog = Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("There is only an entrance to the hole, but no exit. " +
                                        "There is a portal to London in the White Kingdom")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("How to get to the white kingdom?").
                                                nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(2).build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("You need to find the potion at the location and drink it.")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text(EXIT).
                                        nextQuestion(2).build())).build())).build();

        Dialog cat = Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("Ты папал на грибное поле. Все может быть не таким, каким кажется")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Как пройти в белое королевство?").
                                                nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text("What??")
                                                .nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text("Грибы съедобные?").
                                                nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("Разные вещи могут быть скрыты от разума")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Грибы съедобные?").
                                                nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(2)
                                .text("Только если Шляпник позволит")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text(EXIT).
                                        nextQuestion(3).build())).build())).build();

        Dialog caterpillar = Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("Привет, хочешь кальян?")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("yes")
                                                .nextQuestion(1)
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text("нет, спасибо. Как пройти в белое королевство?")
                                                .nextQuestion(1)
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(2)
                                                .build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("Дым такой густой, что гуменица не слышит тебя")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("спросить как пройти в белое королевство?")
                                                .nextQuestion(1)
                                                .build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(2)
                                                .build())).build())).build();

        personsDialogs.put("whiteRabbit", rabbitDialog);
        personsDialogs.put("cat", cat);
        personsDialogs.put("caterpillar", caterpillar);

        return personsDialogs;
    }
}
