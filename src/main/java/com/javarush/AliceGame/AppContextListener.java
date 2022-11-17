package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.RoomsMap;
import com.javarush.AliceGame.dates.UsersRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("RoomsMap", new RoomsMap().getRooms());
        context.setAttribute("UsersRepo", new UsersRepository().getUsersRep());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
    }
}
