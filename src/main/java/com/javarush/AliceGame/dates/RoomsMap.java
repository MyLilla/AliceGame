package com.javarush.AliceGame.dates;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class RoomsMap {

    HashMap <String, Room> rooms = createRoomsMap();
    public HashMap <String, Room> createRoomsMap () {

        HashMap <String, Room> roomsMap = new HashMap<>();

        Room rabbitHole = new Room("rabbitHole");
        rabbitHole.getDoor().add("mushroomForest");
        roomsMap.put(rabbitHole.getName(), rabbitHole);

        Room mushroomForest = new Room("mushroomForest");
        mushroomForest.getDoor().add("hatterHome");
        mushroomForest.getDoor().add("caterpillarArea");
        roomsMap.put(mushroomForest.getName(), mushroomForest);

        Room caterpillarArea = new Room("mushroomForest");
        caterpillarArea.getDoor().add("mushroomForest");
        roomsMap.put(caterpillarArea.getName(), caterpillarArea);

        Room hatterHome = new Room("hatterHome");
        hatterHome.getDoor().add("mushroomForest");
        hatterHome.getDoor().add("redKingdom");
        hatterHome.getDoor().add("whiteKingdom");
        roomsMap.put(hatterHome.getName(), hatterHome);

        Room redKingdom = new Room("redKingdom");
        redKingdom.getDoor().add("dungeon");
        redKingdom.getDoor().add("hatterHome");
        roomsMap.put(redKingdom.getName(), redKingdom);

        Room dungeon = new Room("dungeon");
        dungeon.getDoor().add("redKingdom");
        roomsMap.put(dungeon.getName(), dungeon);

        Room whiteKingdom = new Room("whiteKingdom");
        whiteKingdom.getDoor().add("london");
        whiteKingdom.getDoor().add("hatterHome");
        roomsMap.put(whiteKingdom.getName(), whiteKingdom);

        Room london = new Room("london");
        dungeon.getDoor().add("rabbitHole");
        roomsMap.put(london.getName(), london);

        return roomsMap;
    }
}
