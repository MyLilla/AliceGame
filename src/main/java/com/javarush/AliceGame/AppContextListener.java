package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.UsersRepository;
import com.javarush.AliceGame.service.DialogService;
import com.javarush.AliceGame.service.QuestService;
import com.javarush.AliceGame.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class AppContextListener implements ServletContextListener {
    protected static final Logger LOGGER = LogManager.getLogger(AppContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        context.setAttribute("usersRepository", new UsersRepository());

        GameMap game = new GameMap();

        ArrayList<Personage> persons = game.createPersonsList();
        LOGGER.debug("created persons list: {}", persons);
        context.setAttribute("persons", persons);

        ArrayList<Dialog> dialogs = game.createDialogMap();
        LOGGER.debug("created dialogs list: {}", dialogs);
        context.setAttribute("dialogs", dialogs);

        ArrayList<Room> rooms = game.createRooms();
        LOGGER.debug("created rooms list: {}", rooms);
        context.setAttribute("rooms", rooms);

        context.setAttribute("questService", new QuestService(rooms, dialogs));
        context.setAttribute("roomService", new RoomService(rooms));
        context.setAttribute("dialogService", new DialogService(dialogs));
    }
}
