package com.javarush.AliceGame.dates;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GameMap {

    ArrayList<Personage> personages = createPersonsList();

    public HashMap<String, Room> createRoomsMap() {

        HashMap<String, Room> roomsMap = new HashMap<>();

        Room rabbitHole = new Room("rabbitHole");
        rabbitHole.setPersonage(personages.get(0));
        rabbitHole.getDoor().add("mushroomForest");
        rabbitHole.getInvents().add(Invent.builder().id(1).name("elexir").build());
        roomsMap.put(rabbitHole.getName(), rabbitHole);

        Room mushroomForest = new Room("mushroomForest");
        mushroomForest.getDoor().add("hatterHome");
        mushroomForest.getDoor().add("caterpillarArea");
        roomsMap.put(mushroomForest.getName(), mushroomForest);


        return roomsMap;
    }

    private ArrayList<Personage> createPersonsList() {
        ArrayList<Personage> list = new ArrayList<>();

        HashMap<String, Dialog> personsDialogs = createDialogMap();

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

        Dialog rabbitDialog = new Dialog();

        Dialog.Question firstQuestion = new Dialog.Question(1, "Question 1");
        rabbitDialog.getQuestions().add(firstQuestion);

        Dialog.Answer answerOne = new Dialog.Answer("ответ 1", 2);
        rabbitDialog.getAnswers().add(answerOne);

        personsDialogs.put("whiteRabbit", rabbitDialog);

        return personsDialogs;
    }

//
////        Room mushroomForest = Room.builder()
////                .name("mushroomForest")
////                .door(List.of("hatterHome", "caterpillarArea"))
////                .invents(List.of("mushroom"))
////                .personage(new Personage("Cat"))
////                .build();
////        roomsMap.put(mushroomForest.getName(), mushroomForest);
//
////            Room caterpillarArea = new Room("caterpillarArea");
////            caterpillarArea.getDoor().add("mushroomForest");
////            roomsMap.put(caterpillarArea.getName(), caterpillarArea);
////
////            Room hatterHome = new Room("hatterHome");
////            hatterHome.getDoor().add("mushroomForest");
////            hatterHome.getDoor().add("redKingdom");
////            hatterHome.getDoor().add("whiteKingdom");
////            roomsMap.put(hatterHome.getName(), hatterHome);
////
////            Room redKingdom = new Room("redKingdom");
////            redKingdom.getDoor().add("dungeon");
////            redKingdom.getDoor().add("hatterHome");
////            roomsMap.put(redKingdom.getName(), redKingdom);
////
////            Room dungeon = new Room("dungeon");
////            dungeon.getDoor().add("redKingdom");
////            roomsMap.put(dungeon.getName(), dungeon);
////
////            Room whiteKingdom = new Room("whiteKingdom");
////            whiteKingdom.getDoor().add("london");
////            whiteKingdom.getDoor().add("hatterHome");
////            roomsMap.put(whiteKingdom.getName(), whiteKingdom);
////
////            Room london = new Room("london");
////            london.getDoor().add("rabbitHole");
////            roomsMap.put(london.getName(), london);


}
