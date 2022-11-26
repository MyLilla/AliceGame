package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "FinishServlet", value = "/finish")
public class FinishServlet extends HttpServlet {
    protected static final Logger LOGGER = LogManager.getLogger(FinishServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        LOGGER.info("user: {} finished game", user);

        user.setLocationId(0);
        user.getInvents().clear();
        user.getUsedInvents().clear();
        user.getOpenedDoors().clear();
        user.getOpenedDoors().add(3);
        user.getOpenedDoors().add(4);
        user.setCurrentGame(user.getCurrentGame() + 1);
        LOGGER.info("user: {} cleaning result, current game = {}", user, user.getCurrentGame());

        request.getSession().setAttribute("user", user);

        request.setAttribute("win", request.getParameter("win"));

        getServletContext().getRequestDispatcher("/WEB-INF/finish.jsp").forward(request, response);
    }
}
