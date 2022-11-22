package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RoomsServlet", value = "/rooms")
public class RoomsServlet extends HttpServlet {

    HashMap<String, Room> rooms;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        rooms = (HashMap<String, Room>) context.getAttribute("RoomsMap");
    }
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        Room actualRoom;
        String nextRoom = request.getParameter("nextRoom");
        if (nextRoom == null) {
            actualRoom = rooms.get("rabbitHole");
        } else {
            actualRoom = rooms.get(nextRoom);
        }

        Personage personage = rooms.get(actualRoom.getName()).getPersonage();
        user.setActualRoom(actualRoom.getName());

        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("actualRoom", actualRoom);
        request.getSession().setAttribute("personage",personage);


        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String invent = request.getParameter("getInvent");

        if (!(user.getInvents().contains(invent))) {
            user.getInvents().add(invent);
        } else {
            user.getInvents().remove(invent);
            user.getUsedInvents().add(invent);
            String actualRoom = user.getActualRoom();
            // если инвентарь является открывающим в текущей комнате,
            // пройтись по комнатам, если декущий инвентарь является открывающим

            for (Map.Entry<String, Room> room : rooms.entrySet()) {
                if (room.getValue().getOpenedInvent().equals(invent) ){
                    user.getOpenedDoors().addAll(rooms.get(room.getKey()).getDoor());
                    break;
                }
            }
            // то добавить недоставющую следующую комнату к открытым
        }
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
