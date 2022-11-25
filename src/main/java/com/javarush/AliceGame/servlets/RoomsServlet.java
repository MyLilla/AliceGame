package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.service.QuestService;
import com.javarush.AliceGame.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
    protected static final Logger LOGGER = LogManager.getLogger(RoomsServlet.class);
    ArrayList<Room> rooms;
    ArrayList<Personage> persons;
    RoomService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        rooms = (ArrayList<Room>) context.getAttribute("rooms");
        persons = (ArrayList<Personage>) context.getAttribute("persons");
        service = (RoomService) context.getAttribute("roomService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String nextRoom = request.getParameter("nextRoom");
        LOGGER.info("nextRoom = {}", nextRoom);

        if (nextRoom == null) {
            LOGGER.debug("Parameter: nextRoom is null");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }

        int nextRoomId = service.parseNextRoom(nextRoom);

        if (nextRoomId == (rooms.size() - 1)) {

            LOGGER.info("next room size: {}, room size: {}", nextRoom, rooms.size());

            response.sendRedirect(request.getContextPath() + "/finish");
        } else {

            user.setLocationId(nextRoomId);
            LOGGER.debug("New locationId: {} for user: {}", nextRoom, user);

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("actualRoom", rooms.get(user.getLocationId()));
            request.getSession().setAttribute("personage", persons.get(user.getLocationId()));

            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
    }
}
