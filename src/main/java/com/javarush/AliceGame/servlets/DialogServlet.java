package com.javarush.AliceGame.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet (name="DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pers = request.getParameter("personage");

        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }
}
