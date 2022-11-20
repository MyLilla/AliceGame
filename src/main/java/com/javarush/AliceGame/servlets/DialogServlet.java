package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet (name="DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Room room = (Room) request.getSession().getAttribute("actualRoom");
        Personage personage = room.getPersonage();
        Dialog dialog = personage.getDialog();

        String textQuestion;
        String nextQuestion = request.getParameter("nextQuestion");
        if (nextQuestion == null) {
            textQuestion = dialog.getQuestions().get(0).getText();
        } else {
            Integer nextQuestionId = Integer.parseInt(nextQuestion);
            textQuestion = dialog.getQuestions().get(nextQuestionId).getText();
        }

            request.setAttribute("room", room.getName());
            request.setAttribute("personage", personage);
            request.setAttribute("dialog", dialog);
            request.setAttribute("textQuestion", textQuestion);


        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }
}
