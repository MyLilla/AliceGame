package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.RoomsMap;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.dates.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        RoomsMap roomsMap = new RoomsMap();
        roomsMap.createRoomsMap();
        HashMap<String, Room> rooms = roomsMap.getRooms();
        session.setAttribute("rooms", rooms);


        UsersRepository usersRepository = new UsersRepository();
        User user = usersRepository.addUser(request.getParameter("name"));

        user.setActualRoom(rooms.get("rabbitHole"));
        session.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
