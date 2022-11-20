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
                .invents(List.of(Invent.builder().id(1).name("elexir").build()))
                .door(List.of("mushroomForest"))
                .build();
        roomsMap.put(rabbitHole.getName(), rabbitHole);

        Room mushroomForest = Room.builder()
                .name("mushroomForest")
                .invents(List.of(Invent.builder().id(2).name("mushroom").build()))
                .personage(personages.get(2))
                .door(List.of("hatterHome", "caterpillarArea"))
                .build();
        roomsMap.put(mushroomForest.getName(), mushroomForest);

            Room caterpillarArea = Room.builder()
                    .name("caterpillarArea")
                    .personage(personages.get(0))
                    .door(List.of("mushroomForest"))
                    .build();
            roomsMap.put(caterpillarArea.getName(), caterpillarArea);

        Room hatterHome = Room.builder()
                .name("hatterHome")
                .personage(personages.get(0))
                .door(List.of("mushroomForest", "redKingdom", "whiteKingdom"))
                .build();
            roomsMap.put(hatterHome.getName(), hatterHome);

        Room redKingdom = Room.builder()
                .name("redKingdom")
                .personage(personages.get(0))
                .door(List.of("dungeon", "hatterHome"))
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
                        .text("null")
                .build());
        list.add(Personage.builder()
                .name("whiteRabbit")
                .text("rabbis says")
                .dialog(personsDialogs.get("whiteRabbit"))
                .build());

        list.add(Personage.builder()
                .name("cat")
                .text("catSays")
                .build());

        return list;
    }

    private HashMap<String, Dialog> createDialogMap() {

        HashMap<String, Dialog> personsDialogs = new HashMap<>();

        Dialog rabbitDialog = Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                        .id(0)
                        .text("Кролик говорит, о правилах, и что надо выпить зелье")
                        .build()))
                .answers(List.of(Dialog.Answer.builder()
                        .text("выпить").
                        nextQuestion(0).build(),
                        Dialog.Answer.builder()
                                .text("не выпить").
                                nextQuestion(1).build()))
                .build();

        personsDialogs.put("whiteRabbit", rabbitDialog);

        return personsDialogs;
    }
}
