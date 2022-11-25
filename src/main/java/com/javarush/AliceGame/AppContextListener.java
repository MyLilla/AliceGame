package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.UsersRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        GameMap gameMap = new GameMap();
        context.setAttribute("persons", gameMap.createPersonsList());
        context.setAttribute("dialogs", gameMap.createDialogMap());
        context.setAttribute("rooms", gameMap.createRooms());
        context.setAttribute("UsersRepository", new UsersRepository());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
    }
}
