package com.javarush.AliceGame.dates;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class GameMap {

    public HashMap <String, Room> createRoomsMap () {

        HashMap <String, Room> roomsMap = new HashMap<>();
        ArrayList<Personage> personages = createPersesList();


        Room rabbitHole = new Room("rabbitHole");
        rabbitHole.setPersonage(personages.get(0));
        rabbitHole.getDoor().add("mushroomForest");
        roomsMap.put(rabbitHole.getName(), rabbitHole);

        Room mushroomForest = new Room( "mushroomForest");
        mushroomForest.getDoor().add("hatterHome");
        mushroomForest.getDoor().add("caterpillarArea");
        roomsMap.put(mushroomForest.getName(), mushroomForest);


        return roomsMap;
    }

    private ArrayList<Personage> createPersesList() {
        ArrayList<Personage> list = new ArrayList<>();

        Personage rabbit = new  Personage (0, "whiteRabbit", "rabbis says");

        list.add(rabbit.getId(), rabbit);
        return list;
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
//
//        return roomsMap;
//    }
//

}
