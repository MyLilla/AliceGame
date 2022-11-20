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
import java.util.List;

@WebServlet (name="DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Room room = (Room) request.getSession().getAttribute("actualRoom");
        Dialog dialog = room.getPersonage().getDialog();

        List<Dialog.Question> questions = dialog.getQuestions();  // лист вопросов

        String textQuestion;
        List<Dialog.Answer> answers;

        String nextQuestion = request.getParameter("nextQuestion");

        if (nextQuestion == null) {
            textQuestion = questions.get(0).getText();
            answers = questions.get(0).getAnswers();
        } else {
            Integer nextQuestionId = Integer.parseInt(nextQuestion);
            if (nextQuestionId == 2) {

                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
            textQuestion = questions.get(nextQuestionId).getText();
            answers = questions.get(nextQuestionId).getAnswers();
        }

        request.setAttribute("room", room.getName());
        request.setAttribute("answers", answers);
        request.setAttribute("textQuestion", textQuestion);

        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }
}
