package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.service.QuestService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "RoomsServlet", value = "/rooms")
public class RoomsServlet extends HttpServlet {

    ArrayList <Room> rooms;
    ArrayList <Personage> persons;
    QuestService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        rooms = (ArrayList<Room>) context.getAttribute("rooms");
        persons = (ArrayList<Personage>) context.getAttribute("persons");
        service = new QuestService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        String nextRoom = request.getParameter("nextRoom");
        if (nextRoom == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }

        user.setLocationId(Integer.parseInt(nextRoom));

        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("actualRoom", rooms.get(user.getLocationId()));
        request.getSession().setAttribute("personage", persons.get(user.getLocationId()));

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String invent = request.getParameter("getInvent");

        service.checkQuestStatus(user, invent, rooms);

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
