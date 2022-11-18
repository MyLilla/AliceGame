package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "RoomsServlet", value = "/rooms")
public class RoomsServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        Room actualRoom = user.getActualRoom();

        HashMap<String, Room> rooms = (HashMap<String, Room>) request.getSession().getAttribute("rooms");

        String nextRoom = request.getParameter("nextRoom");
        Room newRoom = rooms.get(nextRoom);
        user.setActualRoom(newRoom);
        request.getSession().setAttribute("user", user);

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
