package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name="DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Room room = (Room) request.getSession().getAttribute("actualRoom");
        String text = room.getPersonage().getText();

        request.setAttribute("room", room.getName());
        request.setAttribute("text", text);

        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }
}
