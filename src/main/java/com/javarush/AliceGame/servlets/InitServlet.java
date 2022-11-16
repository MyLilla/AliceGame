package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        User user = new User();
        user.setName(request.getParameter("name"));

        session.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
