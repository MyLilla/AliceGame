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
                .personage(personages.get(0))
                .invents(List.of("potion"))
                .door(List.of("mushroomForest"))
                .openedInvent("potion")
                .build();
        roomsMap.put(rabbitHole.getName(), rabbitHole);

        Room mushroomForest = Room.builder()
                .name("mushroomForest")
                .invents(List.of("white mushroom", "red mushroom", "horror mushroom", "talking mushroom"))
                .personage(personages.get(1))
                .door(List.of("hatterHome", "caterpillarArea"))
                .openedInvent("white mushroom")
                .build();
        roomsMap.put(mushroomForest.getName(), mushroomForest);

        Room caterpillarArea = Room.builder()
                .name("caterpillarArea")
                .invents(List.of("bigBong"))
                .personage(personages.get(2))
                .door(List.of("mushroomForest"))
                .openedInvent("")
                .build();
        roomsMap.put(caterpillarArea.getName(), caterpillarArea);

        Room hatterHome = Room.builder()
                .name("hatterHome")
                .personage(personages.get(3))
                .door(List.of("mushroomForest", "redKingdom", "whiteKingdom"))
                .openedInvent("bigBong")
                .build();
        roomsMap.put(hatterHome.getName(), hatterHome);

        Room redKingdom = Room.builder()
                .name("redKingdom")
                .personage(personages.get(4))
                .door(List.of("dungeon", "hatterHome"))
                .openedInvent("knife")
                .build();
        roomsMap.put(redKingdom.getName(), redKingdom);

        Room dungeon = Room.builder()
                .name("dungeon")
                .invents(List.of("cake"))
                .personage(personages.get(5))
                .door(List.of("redKingdom"))
                .openedInvent("")
                .build();
        roomsMap.put(dungeon.getName(), dungeon);

        Room whiteKingdom = Room.builder()
                .name("whiteKingdom")
                .personage(personages.get(6))
                .door(List.of("london", "hatterHome"))
                .openedInvent("cake")
                .build();
        roomsMap.put(whiteKingdom.getName(), whiteKingdom);


        Room london = Room.builder()
                .name("london")
                .door(List.of("rabbitHole"))
                .openedInvent("")
                .build();
        roomsMap.put(london.getName(), london);

        return roomsMap;
    }

    private ArrayList<Personage> createPersonsList() {
        ArrayList<Personage> list = new ArrayList<>();

        ArrayList<Dialog> personsDialogs = createDialogMap();

        list.add(Personage.builder()
                .id(0)
                .name("whiteRabbit")
                .imgPath("img/rabbit.png")
                .dialog(personsDialogs.get(0)).build());

        list.add(Personage.builder()
                .id(1)
                .name("cat")
                .imgPath("img/cat.png")
                .dialog(personsDialogs.get(1)).build());

        list.add(Personage.builder()
                .id(2)
                .name("caterpillar")
                .imgPath("img/caterpillar.png")
                .dialog(personsDialogs.get(2)).build());

        list.add(Personage.builder()
                .id(3)
                .name("hatter")
                .imgPath("img/hatter.png")
                .dialog(personsDialogs.get(3)).build());

        list.add(Personage.builder()
                .id(4)
                .name("card")
                .imgPath("img/card.png")
                .dialog(personsDialogs.get(4)).build());

        list.add(Personage.builder()
                .id(5)
                .name("dragon")
                .imgPath("img/drag.png")
                .dialog(personsDialogs.get(5)).build());

        list.add(Personage.builder()
                .id(6)
                .name("null")
                .imgPath("img/drag.png")
                .dialog(personsDialogs.get(6)).build());

        return list;
    }

    private ArrayList<Dialog> createDialogMap() {

        final String EXIT = "exit";
        ArrayList<Dialog> personsDialogs = new ArrayList<>();

        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("There is only an entrance to the hole, but no exit. ")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("How to get to the London?").
                                                nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("Дверь в Лондон на другом конце Страны чудес. Поищи дверь")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Я не вижу двери").
                                                nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text("Поискать").
                                                nextQuestion(3).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(2)
                                .text("Дверь совсем маленькая, а ты огромная. Ты по размерам не проходишь." +
                                        "Нужно какое-то зелье для уменьшения")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Искать зелье").
                                                nextQuestion(3).build(),
                                        Dialog.Answer.builder()
                                                .text("Где дверь?").
                                                nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(3).build())).build())).build());

        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("Кого только не увидешь на грибном поле. И чего не увидешь?")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Где дверь в Лондон?").
                                                nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text("Чего не увидешь?")
                                                .nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text("Какие рибы съедобные?").
                                                nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT).
                                                nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("Разные вещи могут быть скрыты от взгляда, например двери.")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text(EXIT).
                                        nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(2)
                                .text("Лучше спроси об этом шляпника, он в них разбирается")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text(EXIT).
                                        nextQuestion(3).build())).build())).build());

        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("Привет, хочешь кальян?")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("согласиться")
                                                .nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text("нет, спасибо. Как найти дверь в лондон?")
                                                .nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("Это не просто кальян, а кальян-просветления. С ним ты можешь увидеть то, " +
                                        "чего не видел вокруг раньше")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("отказаться")
                                                .nextQuestion(3).build(),
                                        Dialog.Answer.builder()
                                                .text("согласиться")
                                                .nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(2)
                                .text("Ты заметил как изменился мир? Спасибо за компанию, возьми кальян в дорогу, " +
                                        "вдруг еще что-то нужно будет увидеть")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Найти кальян")
                                                .nextQuestion(3).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(3)
                                                .build())).build())).build());

        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                                .id(0)
                                .text("Ты из грибной рощи? Ну как тебе гибы?")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("Ок, нормальные")
                                                .nextQuestion(3).build(),
                                        Dialog.Answer.builder()
                                                .text("Их можно есть?")
                                                .nextQuestion(1).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(3).build())).build(),
                        Dialog.Question.builder()
                                .id(1)
                                .text("Не все грибы съедобные, какие-то показывают двери, какие-то увеличивают, " +
                                        "какие-то удивают, а какие-то просто грибы")
                                .answers(List.of(Dialog.Answer.builder()
                                                .text("какой съесть чтобы увидить дверь?")
                                                .nextQuestion(2).build(),
                                        Dialog.Answer.builder()
                                                .text(EXIT)
                                                .nextQuestion(3).build()))
                                .build(),
                        Dialog.Question.builder()
                                .id(2)
                                .text("Вроде бы белые, но не точно")
                                .answers(List.of(Dialog.Answer.builder()
                                        .text(EXIT)
                                        .nextQuestion(3).build()))
                                .build()))
                .build());

        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                        .id(0)
                        .text("card")
                        .answers(List.of(Dialog.Answer.builder()
                                .text(EXIT)
                                .nextQuestion(1).build())).build())).build());
        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                        .id(0)
                        .text("dragon")
                        .answers(List.of(Dialog.Answer.builder()
                                .text(EXIT)
                                .nextQuestion(1).build())).build())).build());

        personsDialogs.add(Dialog.builder()
                .questions(List.of(Dialog.Question.builder()
                        .id(0)
                        .text("dragon")
                        .answers(List.of(Dialog.Answer.builder()
                                .text(EXIT)
                                .nextQuestion(1).build())).build())).build());

        return personsDialogs;
    }
}
