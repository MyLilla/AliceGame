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
import java.util.List;

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        context.setAttribute("usersRepository", new UsersRepository());

        GameMap game = new GameMap();
        LOGGER.info("created GameMap: {}", game);

        List<Personage> persons = game.createPersonsList();
        context.setAttribute("persons", persons);
        LOGGER.info("persons list: {} created and added to context like: \"persons\"", persons);

        List<Dialog> dialogs = game.createDialogMap();
        context.setAttribute("dialogs", dialogs);
        LOGGER.info("dialogs list: {} created and added to context like: \"dialogs\"", dialogs);

        List<Room> rooms = game.createRooms();
        context.setAttribute("rooms", rooms);
        LOGGER.info("dialogs rooms: {} created and added to context like: \"rooms\"", rooms);

        context.setAttribute("questService", new QuestService(rooms, dialogs));
        LOGGER.info("created QuestService and added to context like: \"questService\"");

        context.setAttribute("roomService", new RoomService(rooms, persons));
        LOGGER.info("created RoomService and added to context like: \"roomService\"");

        context.setAttribute("dialogService", new DialogService(dialogs));
        LOGGER.info("created DialogService and added to context like: \"dialogService\"");
    }
}
