package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.UsersRepository;
import com.javarush.AliceGame.service.QuestService;
import com.javarush.AliceGame.service.RoomService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        context.setAttribute("UsersRepository", new UsersRepository());

        GameMap game = new GameMap();
        context.setAttribute("persons", game.createPersonsList());

        ArrayList<Dialog> dialogs = game.createDialogMap();
        context.setAttribute("dialogs", dialogs);

        ArrayList<Room> rooms = game.createRooms();
        context.setAttribute("rooms", rooms);

        context.setAttribute("questService", new QuestService(rooms, dialogs));
        context.setAttribute("roomService", new RoomService(rooms));
    }
}
