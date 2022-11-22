package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.GameMap;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.dates.UsersRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {

    UsersRepository usersRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        usersRepository = (UsersRepository) context.getAttribute("UsersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(true);

        User user = usersRepository.addUser(request.getParameter("name"));
        if (user.getActualRoom() == null) {
            user.setActualRoom("rabbitHole");
            user.getUsedInvents().add("");
            user.getOpenedDoors().add("hatterHome");
            user.getOpenedDoors().add("redKingdom");

        }
        session.setAttribute("user", user);

        response.sendRedirect("rooms");
    }
}
