package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.GameMap;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.UsersRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        GameMap gameMap = new GameMap();
        HashMap<String, Room> roomsMap = gameMap.createRoomsMap();
       context.setAttribute("RoomsMap", roomsMap);
        context.setAttribute("UsersRepository", new UsersRepository());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
    }
}
